package edu.njit.mapper;

import edu.njit.model.RoleAuthKey;

public interface RoleAuthMapper {
    int deleteByPrimaryKey(RoleAuthKey key);

    int insert(RoleAuthKey record);

    int insertSelective(RoleAuthKey record);
}