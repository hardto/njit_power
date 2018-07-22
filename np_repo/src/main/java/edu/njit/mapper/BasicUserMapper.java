package edu.njit.mapper;

import edu.njit.model.BasicUser;

public interface BasicUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicUser record);

    int insertSelective(BasicUser record);

    BasicUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BasicUser record);

    int updateByPrimaryKeyWithBLOBs(BasicUser record);

    int updateByPrimaryKey(BasicUser record);

    int getTablePrimaryKeyForNext();

    /**
     *
     * @param id 基本用户主键
     * @return 1返回true 即是学生 0返回false 即不是学生
     */
    boolean isStuWithFlag(String id);

    BasicUser selectUserByAccount(String account);

    BasicUser selectUserByAccountAndPwd(String account,String pwd);

    /**
     * 由二级用户表主键查询到一级用户表信息
     * @param user_id
     * @return
     */
    BasicUser getBasicUserByUserId(int user_id);
}