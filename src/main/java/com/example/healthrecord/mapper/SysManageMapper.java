package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.SysManage;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("SysManageMapper")
public interface SysManageMapper {
    int deleteByPrimaryKey(String sMId);

    int insert(SysManage record);

    int insertSelective(SysManage record);

    SysManage selectByPrimaryKey(String sMId);

    int updateByPrimaryKeySelective(SysManage record);

    int updateByPrimaryKey(SysManage record);

    SysManage searchByName(@Param("username")String username);

    int selectByExampleCount(SysManage sys);

    List<SysManage> searchByExampleWithPage(@Param("sys") SysManage sys, @Param("begin") int begin, @Param("limit") int limit);

    int searchNum();



}