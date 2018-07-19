package edu.njit.mapper;

import edu.njit.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    @Results({
            @Result(property = "id",  column = "id",jdbcType = JdbcType.INTEGER,javaType = Integer.class),
            @Result(property = "name", column = "name")
    })
    List<User> getAll();


}
