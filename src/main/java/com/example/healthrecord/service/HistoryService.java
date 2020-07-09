package com.example.healthrecord.service;

import com.example.healthrecord.entity.BasicRecord;
import com.example.healthrecord.entity.CaseHistory;
import com.example.healthrecord.mapper.BasicRecordMapper;
import com.example.healthrecord.mapper.CaseHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    private CaseHistoryMapper mapper;

    @Autowired
    private BasicRecordMapper recordMapper;

    public CaseHistory searchByChid(String cHId){
        return mapper.selectByPrimaryKey(cHId);
    }

    public int searchByExampleCount(CaseHistory caseHistory){
        return mapper.selectByExampleCount(caseHistory);
    }

    public List<CaseHistory> searchByExampleWithPage(CaseHistory caseHistory, int page, int limit){
        int begin = limit * (page - 1);

        List<CaseHistory> result = mapper.searchByExampleWithPage(caseHistory,begin,limit);

        return result;
    }

    public int searchNum(){
        return mapper.searchNum();
    }

    public int updateCase(CaseHistory caseHistory){
        return mapper.updateByPrimaryKey(caseHistory);
    }

    public BasicRecord searchByName(String name){
        return recordMapper.selectByName(name);
    }

    public int insert(CaseHistory caseHistory){
        return mapper.insert(caseHistory);
    }

    public int deleteAll(String chid){
        return mapper.deleteByPrimaryKey(chid);
    }

    public CaseHistory searchBybRId(String bRId){
        return mapper.searchBybRId(bRId);
    }



}
