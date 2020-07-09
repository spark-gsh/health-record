package com.example.healthrecord.controller;


import com.example.healthrecord.Utils.MyMessage;
import com.example.healthrecord.Utils.TableData;
import com.example.healthrecord.Utils.UUIDTools;
import com.example.healthrecord.entity.SysManage;
import com.example.healthrecord.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("user/save")
    public Boolean save(SysManage sysManage) {

        UUIDTools uid = new UUIDTools();
        String smid = uid.uuid();
        sysManage.setsMId(smid);

        sysManage.setCreatTime(new Date());

        return service.save(sysManage);
    }

    @RequestMapping("login/searchByName")
    public MyMessage loginByName(SysManage sysManage) {

        System.out.println(sysManage.getsDId());

        boolean falg = service.loginByName(sysManage.getUsername(), sysManage.getPassword(), sysManage.getsDId());

        MyMessage msg = new MyMessage();

        if (falg) {
            msg.setError_code(1);
            msg.setStatus("success");
            msg.setMsg("登录成功");
        } else {
            msg.setError_code(0);
            msg.setStatus("fail");
            msg.setMsg("登录失败啊啊");
        }
        System.out.println("返回信息：" + msg.getError_code());
        return msg;
    }

    @RequestMapping("user/search")
    public TableData<SysManage> searchAll(SysManage sysManage, int page, int limit) {

        System.out.println(sysManage.getsMId());

        TableData<SysManage> tableData = new TableData<>();

        int count = service.searchByExampleCount(sysManage);
        List<SysManage> result = service.searchByExampleWithPage(sysManage, page, limit);

        tableData.setCode(0);
        tableData.setCount(count);
        tableData.setData(result);

        return tableData;
    }

    @RequestMapping("user/searchNum")
    public int searchNum(){
        System.out.println(service.searchNum());
        return service.searchNum();

    }

    @RequestMapping("user/update")
    public int updateUser(SysManage sysManage){

        sysManage.setCreatTime(new Date());

        System.out.println("sysManage："+sysManage);

        int result = service.updateUser(sysManage);

        System.out.println("result:"+result);
        return result;
    }

    @RequestMapping("user/delete")
    public int deleteAll(String[] sMIds){
        int num = 0;

        for (int i=0;i<sMIds.length;i++){
            service.deleteAll(sMIds[i]);
            num++;
        }
        System.out.println("num:"+num);
        return num-1;
    }


}
