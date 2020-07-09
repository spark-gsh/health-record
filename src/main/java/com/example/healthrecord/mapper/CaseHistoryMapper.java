package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.CaseHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("CaseHistoryMapper")
public interface CaseHistoryMapper {
    int deleteByPrimaryKey(String cHId);

    int insert(CaseHistory record);

    int insertSelective(CaseHistory record);

    CaseHistory selectByPrimaryKey(String cHId);

    int updateByPrimaryKeySelective(CaseHistory record);

    int updateByPrimaryKey(CaseHistory record);

    int selectByExampleCount(CaseHistory record);

    List<CaseHistory> searchByExampleWithPage(@Param("record") CaseHistory record, @Param("begin") int begin, @Param("limit") int limit);

    int searchNum();

    CaseHistory searchBybRId(String bRId);

}