package com.example.healthrecord.service;

import com.example.healthrecord.entity.ReturnVisit;
import com.example.healthrecord.mapper.BasicRecordMapper;
import com.example.healthrecord.mapper.ReturnVisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: 类名称
 *
 * @Description: 描述
 * @Author 类创建者
 * @CreatDate 创建日期
 */

@Service
public class ReturnService {

    @Autowired
    private ReturnVisitMapper mapper;
    @Autowired
    private BasicRecordMapper recordMapper;

    public int searchByExampleCount(ReturnVisit returnVisit){
        return mapper.selectByExampleCount(returnVisit);
    }

    public List<ReturnVisit> searchByExampleWithPage(ReturnVisit returnVisit, int page, int limit){
        int begin = limit * (page - 1);

        List<ReturnVisit> result = mapper.searchByExampleWithPage(returnVisit,begin,limit);

        System.out.println("result："+result);
        return result;
    }

    public int deleteAll(String rvid){
        return mapper.deleteByPrimaryKey(rvid);
    }

    public int searchNum(){
        return mapper.searchNum();
    }

    public int insert(ReturnVisit returnVisit){
        return mapper.insert(returnVisit);
    }

    public int updateReturn(ReturnVisit returnVisit){
        return mapper.updateByPrimaryKey(returnVisit);
    }




}
