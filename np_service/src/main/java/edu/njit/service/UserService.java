package edu.njit.service;

import edu.njit.Message.SimpleSystemMessage;
import edu.njit.Message.SystemMessage;
import edu.njit.WebUtils.Const;
import edu.njit.WebUtils.ObectUtils;
import edu.njit.mapper.BasicUserMapper;
import edu.njit.mapper.UserMapper;
import edu.njit.model.BasicUser;
import edu.njit.WebUtils.ObectUtils;
import edu.njit.model.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BasicUserMapper basicUserMapper;

    public SimpleSystemMessage updateUser(User user){
        SystemMessage<Object> returnMsg = new SystemMessage<>();
        if(ObectUtils.isNone(user)){
            returnMsg.setMessage("信息获取失败");
            returnMsg.setSuccess(true);
            returnMsg.setFlag(0);
        }else{
            try{
                //更新两张表
                User userOrigin = userMapper.getUserByAccount(user.getAccount());
                BasicUser basicUser = basicUserMapper.getBasicUserByUserId(userOrigin.getId());
                user.setId(userOrigin.getId());
                basicUser.setAccount(user.getAccount());
                basicUser.setPassword(user.getPassword());
                basicUserMapper.updateByPrimaryKeySelective(basicUser);
                userMapper.updateByPrimaryKeyWithBLOBs(user);
                returnMsg.setMessage("修改成功");
                returnMsg.setSuccess(true);
                returnMsg.setFlag(1);
            }catch (Exception e){
                returnMsg.setMessage("修改失败，由于:"+e.getMessage());
                returnMsg.setSuccess(true);
                returnMsg.setFlag(-1);
            }
        }
        return returnMsg;
    }

    public SimpleSystemMessage hasUser(String account, String password, HttpServletRequest request) {
        SystemMessage<Object> returnMsg = new SystemMessage<>();
        if (ObectUtils.isEmpty(account) || ObectUtils.isEmpty(password)) {
            returnMsg.setFlag(0);
            returnMsg.setSuccess(true);
            returnMsg.setMessage("请输入符合要求的数据");
        } else {
            BasicUser user = basicUserMapper.selectUserByAccount(account);
            if(!ObectUtils.isNone(user)){
                returnMsg.setFlag(1);
                returnMsg.setSuccess(true);
                request.getSession(true).setAttribute(Const.USER_KEY,account);
            }else{
                returnMsg.setFlag(0);
                returnMsg.setSuccess(true);
                returnMsg.setMessage("不存在此用户");
            }
        }
        return returnMsg;
    }
}
