package edu.njit.service;

import edu.njit.Message.SimpleSystemMessage;
import edu.njit.Message.SystemMessage;
import edu.njit.WebUtils.Const;
import edu.njit.WebUtils.EmailContent;
import edu.njit.WebUtils.WebUtils;
import edu.njit.mapper.UserMapper;
import edu.njit.model.User;
import edu.njit.WebUtils.ObectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class SystemService {
    @Autowired
    private UserMapper userMapper;

    public SimpleSystemMessage sendEmail(HttpServletRequest request,String email){
        User user = userMapper.getUserByEmail(email);
        SystemMessage<Object> returnMsg = new SystemMessage<>();
        if(!ObectUtils.isNone(user)){
            HttpSession session = request.getSession(true);
            if(!ObectUtils.isEmpty((String) session.getAttribute(Const.USER_ECODE))){
                returnMsg.setMessage("已发送验证码");
                returnMsg.setSuccess(true);
                returnMsg.setFlag(0);
            }else {
                String code = EmailContent.VerificationCodes();
                session.setAttribute(Const.USER_ECODE,code);
                try {
                    WebUtils.sendEmail(code,email);
                    returnMsg.setMessage("已发送至您的邮箱");
                    returnMsg.setSuccess(true);
                    returnMsg.setFlag(1);
                } catch (MessagingException e) {
                    returnMsg.setMessage("系统出现异常");
                    returnMsg.setSuccess(false);
                    returnMsg.setFlag(-1);
                }
            }

        }else{
            returnMsg.setMessage("未发现有此用户");
            returnMsg.setSuccess(true);
        }
        return returnMsg;
    }

    public SimpleSystemMessage validMailCode(HttpServletRequest request,String code) {
        HttpSession session = request.getSession(true);
        SystemMessage<Object> returnMsg = new SystemMessage<>();
        if(ObectUtils.isEmpty(code)){
            returnMsg.setSuccess(true);
            returnMsg.setMessage("确保验证码符合要求");
            return returnMsg;
        }
        if (!ObectUtils.isEmpty((String) session.getAttribute(Const.USER_ECODE))) {
            if (code.equalsIgnoreCase((String) session.getAttribute(Const.USER_ECODE))) {
                returnMsg.setMessage("验证通过");
                returnMsg.setSuccess(true);
                returnMsg.setFlag(1);
                session.setAttribute(Const.USER_ECODE,"");
            } else {
                returnMsg.setMessage("验证码不一致");
                returnMsg.setSuccess(true);
                returnMsg.setFlag(0);
            }

        } else {
            returnMsg.setMessage("请重新获取验证码");
            returnMsg.setSuccess(true);
            returnMsg.setFlag(0);
        }
        return returnMsg;
    }
}
