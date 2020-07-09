package com.example.healthrecord.controller;

import com.example.healthrecord.Utils.TableData;

import com.example.healthrecord.Utils.UUIDTools;
import com.example.healthrecord.entity.BasicRecord;
import com.example.healthrecord.entity.CaseHistory;
import com.example.healthrecord.service.HistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class HistoryController {

    @Autowired
    private HistoryService service;


    @RequestMapping("history/searchByChid")
    public CaseHistory searchByChid(String cHId){

        return service.searchByChid(cHId);
    }

    @RequestMapping("history/search")
    public TableData<CaseHistory> searchAll(CaseHistory caseHistory,int page,int limit){

        TableData<CaseHistory> tableData = new TableData<>();

        int count = service.searchByExampleCount(caseHistory);
        List<CaseHistory> result = service.searchByExampleWithPage(caseHistory, page, limit);

        tableData.setCode(0);
        tableData.setCount(count);
        tableData.setData(result);
        return tableData;
    }

    @RequestMapping("history/searchNum")
    public int searchNum(){
        System.out.println(service.searchNum());
        return service.searchNum();
    }

    @RequestMapping("history/update")
    public int updateCase(CaseHistory caseHistory){
        return service.updateCase(caseHistory);
    }

    @RequestMapping("history/basic/name")
    public BasicRecord searchByName(String name){
        return service.searchByName(name);
    }

    @RequestMapping("history/insert")
    public int insert(CaseHistory caseHistory){

        UUIDTools uuidTools = new UUIDTools();
        String chid = uuidTools.uuid();
        caseHistory.setcHId(chid);

        return service.insert(caseHistory);
    }

    @RequestMapping("history/delete")
    public int deleteAll(String[] cHIds){
        int num = 0;

        for (int i=0;i<cHIds.length;i++){
            service.deleteAll(cHIds[i]);
            num++;
        }
        System.out.println("num:"+num);
        return num-1;
    }

    @RequestMapping("history/searchBybRId")
    public CaseHistory searchBybRId(String bRId){

        System.out.println("chid:"+service.searchBybRId(bRId).getcHId());
        return service.searchBybRId(bRId);
    }
}

