package edu.njit.mapper;

import edu.njit.model.Message;
import edu.njit.model.MessageWithBLOBs;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MessageWithBLOBs record);

    int insertSelective(MessageWithBLOBs record);

    MessageWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MessageWithBLOBs record);

    int updateByPrimaryKey(Message record);

    int getTablePrimaryKeyForNext();
}