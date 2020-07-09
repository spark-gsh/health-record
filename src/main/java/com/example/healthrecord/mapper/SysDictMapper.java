package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.SysDict;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("SysDictMapper")
public interface SysDictMapper {
    int deleteByPrimaryKey(String sDId);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(String sDId);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    SysDict selectByVartity(String vartityId);

    List<SysDict> searchAll();
}