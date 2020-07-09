package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.AreaDivide;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("AreaDivideMapper")
public interface AreaDivideMapper {
    int deleteByPrimaryKey(String aDId);

    int insert(AreaDivide record);

    int insertSelective(AreaDivide record);

    AreaDivide selectByPrimaryKey(String aDId);

    int updateByPrimaryKeySelective(AreaDivide record);

    int updateByPrimaryKey(AreaDivide record);

    List<AreaDivide> searchAll();

}