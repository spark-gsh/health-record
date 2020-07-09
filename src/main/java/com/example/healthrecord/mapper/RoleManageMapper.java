package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.RoleManage;
import org.springframework.stereotype.Component;

@Component("RoleManageMapper")

public interface RoleManageMapper {
    int deleteByPrimaryKey(String rMId);

    int insert(RoleManage record);

    int insertSelective(RoleManage record);

    RoleManage selectByPrimaryKey(String rMId);

    int updateByPrimaryKeySelective(RoleManage record);

    int updateByPrimaryKey(RoleManage record);


}