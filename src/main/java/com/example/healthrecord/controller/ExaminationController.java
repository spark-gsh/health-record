package com.example.healthrecord.controller;

import com.example.healthrecord.Utils.TableData;
import com.example.healthrecord.Utils.UUIDTools;
import com.example.healthrecord.entity.CaseHistory;
import com.example.healthrecord.entity.MedicalCheck;
import com.example.healthrecord.service.ExaminationService;
import com.example.healthrecord.service.HistoryService;
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
public class ExaminationController {

    @Autowired
    private ExaminationService service;


    @RequestMapping("examination/searchBymCId")
    public MedicalCheck searchByMCid(String mCId){

        return service.searchByMCid(mCId);
    }

    @RequestMapping("examination/search")
    public TableData<MedicalCheck> searchAll(MedicalCheck medicalCheck, int page, int limit){

        System.out.println("mcid:"+medicalCheck.getmCId());

        TableData<MedicalCheck> tableData = new TableData<>();

        int count = service.searchByExampleCount(medicalCheck);
        List<MedicalCheck> result = service.searchByExampleWithPage(medicalCheck, page, limit);

        tableData.setCode(0);
        tableData.setCount(count);
        tableData.setData(result);

        System.out.println("tableDate:"+tableData);

        return tableData;



    }

    @RequestMapping("examination/searchNum")
    public int searchNum(){
        System.out.println(service.searchNum());
        return service.searchNum();
    }
    @RequestMapping("examination/insert")
    public int insert(MedicalCheck medicalCheck){

        UUIDTools uuidTools = new UUIDTools();
        String mcid = uuidTools.uuid();
        medicalCheck.setmCId(mcid);

        return service.insert(medicalCheck);
    }

    @RequestMapping("examination/searchBybRId")
    public MedicalCheck searchBybRId(String bRId){

        System.out.println("mcid:"+service.searchBybRId(bRId).getmCId());
        return service.searchBybRId(bRId);
    }

    @RequestMapping("examination/update")
    public int updateExamination(MedicalCheck medicalCheck){
        return service.updateExamination(medicalCheck);
    }

    @RequestMapping("examination/delete")
    public int deleteAll(String[] mCIds){
        int num = 0;

        for (int i=0;i<mCIds.length;i++){
            service.deleteAll(mCIds[i]);
            num++;
        }
        System.out.println("num:"+num);
        return num-1;
    }



}
