package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.ReturnVisit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component("ReturnVisitMapper")
public interface ReturnVisitMapper {
    int deleteByPrimaryKey(String rVId);

    int insert(ReturnVisit record);

    int insertSelective(ReturnVisit record);

    ReturnVisit selectByPrimaryKey(String rVId);

    int updateByPrimaryKeySelective(ReturnVisit record);

    int updateByPrimaryKey(ReturnVisit record);

    int selectByExampleCount(ReturnVisit record);

    List<ReturnVisit> searchByExampleWithPage(@Param("record") ReturnVisit record, @Param("begin") int begin, @Param("limit") int limit);

    int searchNum();

}