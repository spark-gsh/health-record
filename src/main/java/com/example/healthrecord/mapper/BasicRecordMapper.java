package com.example.healthrecord.mapper;

import com.example.healthrecord.entity.BasicRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("BasicRecordMapper")
public interface BasicRecordMapper {
    int deleteByPrimaryKey(String bRId);

    int insert(BasicRecord record);

    int insertSelective(BasicRecord record);

    BasicRecord selectByPrimaryKey(String bRId);

    int updateByPrimaryKeySelective(BasicRecord record);

    int updateByPrimaryKey(BasicRecord record);

    int selectByExampleCount(@Param("record")BasicRecord record);

    List<BasicRecord> searchByExampleWithPage(@Param("record") BasicRecord record, @Param("begin") int begin, @Param("limit") int limit);

    int searchNum();

    BasicRecord selectByName(String name);
//图表
    List<BasicRecord> groupByNum();

    List<BasicRecord> groupByRecord();
//新建病历，逆向插入chid
    int updateBybRId(@Param("bRId")String bRId,@Param("cHId")String cHId);

    //新建病历，逆向插入mcid
    int updateBymCId(@Param("bRId")String bRId,@Param("mCId")String mCId);
    //疾病类型
    List<BasicRecord> selectBypypertension(@Param("record")BasicRecord record);
}