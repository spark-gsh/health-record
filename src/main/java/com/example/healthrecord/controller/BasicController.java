package com.example.healthrecord.controller;

import com.example.healthrecord.Utils.TableData;
import com.example.healthrecord.entity.BasicRecord;
import com.example.healthrecord.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BasicController {

    @Autowired
    private BasicService service;

    @RequestMapping("basic/search")
    public TableData<BasicRecord> searchAll(BasicRecord basicRecord,int page,int limit){
        System.out.println(basicRecord.getName());

        TableData<BasicRecord> tableData = new TableData<>();

        int count = service.searchByExampleCount(basicRecord);
        List<BasicRecord> result = service.searchByExampleWithPage(basicRecord, page, limit);

        tableData.setCode(0);
        tableData.setCount(count);
        tableData.setData(result);

        return tableData;
    }

    @RequestMapping("basic/searchNum")
    public int searchNum(){
        System.out.println(service.searchNum());
        return service.searchNum();

    }

    @RequestMapping("basic/add")
    public boolean add(BasicRecord basicRecord){

        //设置户口类型
        if ("1".equals(basicRecord.getRprType())){
            basicRecord.setRprType("农业户口");
        }else {
            basicRecord.setRprType("非农业户口");
        }

        //设置性别
        if("1".equals(basicRecord.getGender())){
            basicRecord.setGender("男");
        }else {
            basicRecord.setGender("女");
        }

        //设置血型
        String blood = basicRecord.getBloodType();
//        System.out.println("blood:"+blood);
        if ("1".equals(blood)){
            basicRecord.setBloodType("A型");
        }if ("2".equals(blood)){
            basicRecord.setBloodType("B型");
        }if ("3".equals(blood)){
            basicRecord.setBloodType("O型");
        }if ("4".equals(blood)){
            basicRecord.setBloodType("AB型");
        }if ("5".equals(blood)){
            basicRecord.setBloodType("RH阴型");
        }

        //设置婚否
        if("1".equals(basicRecord.getMaritalStatus())){
            basicRecord.setMaritalStatus("是");
        }else {
            basicRecord.setMaritalStatus("否");
        }

//        System.out.println(basicRecord.getBloodType()+basicRecord.getRprType()+basicRecord.getGender()+basicRecord.getMaritalStatus());

        return service.add(basicRecord);
    }

    @RequestMapping("basic/update")
    public int updateBasic(BasicRecord basicRecord){
        //设置户口类型
        if ("1".equals(basicRecord.getRprType())){
            basicRecord.setRprType("农业户口");
        }else {
            basicRecord.setRprType("非农业户口");
        }

        //设置性别
        if("1".equals(basicRecord.getGender())){
            basicRecord.setGender("男");
        }else {
            basicRecord.setGender("女");
        }

        //设置血型
        String blood = basicRecord.getBloodType();
        System.out.println("blood:"+blood);
        if ("1".equals(blood)){
            basicRecord.setBloodType("A型");
        }if ("2".equals(blood)){
            basicRecord.setBloodType("B型");
        }if ("3".equals(blood)){
            basicRecord.setBloodType("O型");
        }if ("4".equals(blood)){
            basicRecord.setBloodType("AB型");
        }if ("5".equals(blood)){
            basicRecord.setBloodType("RH阴型");
        }

        //设置婚否
        if("1".equals(basicRecord.getMaritalStatus())){
            basicRecord.setMaritalStatus("是");
        }else {
            basicRecord.setMaritalStatus("否");
        }

        System.out.println(basicRecord.getBloodType()+basicRecord.getRprType()+basicRecord.getGender()+basicRecord.getMaritalStatus());

        int result = service.updateBasic(basicRecord);

        System.out.println("result:"+result);
        return result;
    }

    @RequestMapping("basic/delete")
    public int deleteAll(String[] bRIds){
        int num = 0;

        for (int i=0;i<bRIds.length;i++){
            service.deleteAll(bRIds[i]);
            num++;
        }
        System.out.println("num:"+num);
        return num-1;

    }

    //图表查询
    @RequestMapping("basic/searchCount")
    public Map<String,Object> groupByNum(){
        return service.groupByNum();
    }

    @RequestMapping("basic/searchDisease")
    public Map<String,Object> groupByDisease(){
        return service.groupByDisease();
    }


    //新建病历，逆向插入chid
    @RequestMapping("basic/updatecHId")
    public int updatecHId(String bRId,String cHId){
        System.out.println("返回条目数："+service.updatecHId(bRId,cHId));
        return service.updatecHId(bRId,cHId);
    }
    @RequestMapping("basic/updatemCId")
    public int updatemCId(String bRId,String mCId){
        System.out.println("返回条目数："+service.updatemCId(bRId,mCId));
        return service.updatemCId(bRId,mCId);
    }


    //疾病类型
    @RequestMapping("disease/hypertension")
    public TableData<BasicRecord> selectHypertension(BasicRecord basicRecord){

        System.out.println("rtid:"+basicRecord.getrTId());

        List<BasicRecord> result = service.selectHypertension(basicRecord);

        TableData<BasicRecord> tableData = new TableData<>();

        tableData.setCode(0);
        tableData.setCount(10);
        tableData.setData(result);

        return tableData;
    }


}
