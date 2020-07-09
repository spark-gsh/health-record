package com.example.healthrecord.controller;

import com.example.healthrecord.Utils.TableData;
import com.example.healthrecord.Utils.UUIDTools;
import com.example.healthrecord.entity.ReturnVisit;
import com.example.healthrecord.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: 类名称
 *
 * @Description: 描述
 * @Author 类创建者
 * @CreatDate 创建日期
 */
@RestController
public class ReturnController {

    @Autowired
    private ReturnService service;


    @RequestMapping("return/search")
    public TableData<ReturnVisit> searchAll(ReturnVisit returnVisit, int page, int limit){

        TableData<ReturnVisit> tableData = new TableData<>();

        int count = service.searchByExampleCount(returnVisit);
        List<ReturnVisit> result = service.searchByExampleWithPage(returnVisit, page, limit);

        tableData.setCode(0);
        tableData.setCount(count);
        tableData.setData(result);
        return tableData;
    }

    @RequestMapping("return/delete")
    public int deleteAll(String[] rVIds){
        int num = 0;

        for (int i=0;i<rVIds.length;i++){
            service.deleteAll(rVIds[i]);
            num++;
        }
        System.out.println("num:"+num);
        return num-1;
    }

    @RequestMapping("return/searchNum")
    public int searchNum(){
        System.out.println(service.searchNum());
        return service.searchNum();
    }

    @RequestMapping("return/insert")
    public int insert(ReturnVisit returnVisit){
        UUIDTools uuidTools = new UUIDTools();
        String rvid = uuidTools.uuid();
        returnVisit.setrVId(rvid);

        return service.insert(returnVisit);
    }

    @RequestMapping("return/update")
    public int updateReturn(ReturnVisit returnVisit){
        return service.updateReturn(returnVisit);
    }



}
