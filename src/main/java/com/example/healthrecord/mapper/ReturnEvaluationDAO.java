package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.ReturnEvaluation;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnEvaluationDAO {
    int deleteByPrimaryKey(String rEId);

    int insert(ReturnEvaluation record);

    int insertSelective(ReturnEvaluation record);

    ReturnEvaluation selectByPrimaryKey(String rEId);

    int updateByPrimaryKeySelective(ReturnEvaluation record);

    int updateByPrimaryKey(ReturnEvaluation record);
}