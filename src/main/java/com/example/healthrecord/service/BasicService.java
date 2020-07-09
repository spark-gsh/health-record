package com.example.healthrecord.service;

import com.example.healthrecord.entity.BasicRecord;
import com.example.healthrecord.mapper.BasicRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BasicService {

    @Autowired
    private BasicRecordMapper mapper;

    public int searchByExampleCount(BasicRecord basicRecord){
        return mapper.selectByExampleCount(basicRecord);
    }

    public List<BasicRecord> searchByExampleWithPage(BasicRecord basicRecord, int page, int limit){
        int begin = limit * (page - 1);

        List<BasicRecord> result = mapper.searchByExampleWithPage(basicRecord,begin,limit);

        return result;
    }

    public int searchNum(){
        return mapper.searchNum();
    }

    public Boolean add(BasicRecord basicRecord){
        return mapper.insert(basicRecord)>0?true:false;
    }

    public int updateBasic(BasicRecord basicRecord){
        return mapper.updateByPrimaryKey(basicRecord);
    }

    public int deleteAll(String brid){
        return mapper.deleteByPrimaryKey(brid);
    }

    //图表
    public Map<String,Object> groupByNum(){

        //创建一个集合接收数据库数据
        List<BasicRecord> blist = new ArrayList<>();

        //创建一个map集合存放num
        Map<String,Object> map = new HashMap<>();

        blist = mapper.groupByNum();

        //创建一个数组存放

        Integer[] num = new Integer[blist.size()];

        int i = 0;
        for (BasicRecord basicRecord:blist){
            num[i] = basicRecord.getRecordCount();
            i++;
        }


        map.put("recordCount",num);


        return map;
    }

    public Map<String,Object> groupByDisease(){



        //创建一个集合接收数据库数据
        List<BasicRecord> blist = new ArrayList<>();

        //创建一个map集合存放num
        Map<String,Object> map = new HashMap<>();

        blist = mapper.groupByRecord();

        //创建一个数组存放

        Integer[] num = new Integer[blist.size()];

        int i = 0;
        for (BasicRecord basicRecord:blist){
            num[i] = basicRecord.getDiseaseCount();
            System.out.println(num[i]);
            i++;
        }


        map.put("diseaseCount",num);

        return map;
    }

    //新建病历后，添加病历编号
    public int updatecHId(String bRId,String cHId){
        return mapper.updateBybRId(bRId,cHId);
    }

    //新建病历后，添加体检编号
    public int updatemCId(String bRId,String mCId){
        return mapper.updateBymCId(bRId,mCId);
    }

    //疾病类型
    public List<BasicRecord> selectHypertension(BasicRecord basicRecord){
        return mapper.selectBypypertension(basicRecord);
    }
}
