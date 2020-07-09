package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.RecordType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RecordTypeMapper")
public interface RecordTypeMapper {
    int deleteByPrimaryKey(String rTId);

    int insert(RecordType record);

    int insertSelective(RecordType record);

    RecordType selectByPrimaryKey(String rTId);

    int updateByPrimaryKeySelective(RecordType record);

    int updateByPrimaryKey(RecordType record);

    List<RecordType> searchAll();
}