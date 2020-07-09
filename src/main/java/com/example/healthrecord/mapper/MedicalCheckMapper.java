package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.MedicalCheck;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component("MedicalCheckMapper")
public interface MedicalCheckMapper {
    int deleteByPrimaryKey(String mCId);

    int insert(MedicalCheck record);

    int insertSelective(MedicalCheck record);

    MedicalCheck selectByPrimaryKey(String mCId);

    int updateByPrimaryKeySelective(MedicalCheck record);

    int updateByPrimaryKey(MedicalCheck record);

    int selectByExampleCount(MedicalCheck record);

    List<MedicalCheck> searchByExampleWithPage(@Param("record") MedicalCheck record, @Param("begin") int begin, @Param("limit") int limit);

    int searchNum();

    MedicalCheck searchBybRId(String bRId);


}