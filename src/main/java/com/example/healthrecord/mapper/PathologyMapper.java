package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.Pathology;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("PathologyMapper")
public interface PathologyMapper {
    int deleteByPrimaryKey(String pId);

    int insert(Pathology record);

    int insertSelective(Pathology record);

    Pathology selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(Pathology record);

    int updateByPrimaryKey(Pathology record);

    List<Pathology> selectBypathology(@Param("record")Pathology record);

}