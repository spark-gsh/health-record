package com.example.healthrecord.service;

import com.example.healthrecord.entity.MedicalCheck;
import com.example.healthrecord.mapper.BasicRecordMapper;
import com.example.healthrecord.mapper.MedicalCheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

/**
 * ClassName: 类名称
 *
 * @Description: 描述
 * @Author 类创建者
 * @CreatDate 创建日期
 */

@Service
public class ExaminationService {

    @Autowired
    private MedicalCheckMapper mapper;

    @Autowired
    private BasicRecordMapper recordMapper;

    public MedicalCheck searchByMCid(String mCId){
        return mapper.selectByPrimaryKey(mCId);
    }

    public int searchByExampleCount(MedicalCheck medicalCheck){
        return mapper.selectByExampleCount(medicalCheck);
    }

    public List<MedicalCheck> searchByExampleWithPage(MedicalCheck medicalCheck, int page, int limit){
        int begin = limit * (page - 1);

        List<MedicalCheck> result = mapper.searchByExampleWithPage(medicalCheck,begin,limit);


        System.out.println("result："+result);
        return result;
    }

    public int searchNum(){
        return mapper.searchNum();
    }

    public int insert(MedicalCheck medicalCheck){
        return mapper.insert(medicalCheck);
    }

    public MedicalCheck searchBybRId(String bRId){
        return mapper.searchBybRId(bRId);
    }

    public int updateExamination(MedicalCheck medicalCheck){
        return mapper.updateByPrimaryKey(medicalCheck);
    }

    public int deleteAll(String mcid){
        return mapper.deleteByPrimaryKey(mcid);
    }



}
