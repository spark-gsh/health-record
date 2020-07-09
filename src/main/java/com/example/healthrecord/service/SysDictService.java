package com.example.healthrecord.service;

import com.example.healthrecord.entity.SysDict;
import com.example.healthrecord.mapper.SysDictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: 类名称
 *
 * @Description: 描述
 * @Author 类创建者
 * @CreatDate 创建日期
 */

@Service
public class SysDictService {

    @Autowired
    private SysDictMapper mapper;

    public Map<String,Object> searchAll(){

        //创建一个集合接收数据库数据
        List<SysDict> alist = new ArrayList<>();

        //创建一个map集合来存放decs
        Map<String,Object> amap = new HashMap<String, Object>();

        alist = mapper.searchAll();

        //创建装载desc的数组
        String[] desc = new String[alist.size()];

        int i=0;
        //遍历数据库数据
        for (SysDict sysDict:alist){
            desc[i] = sysDict.getDesc();
            i++;
        }
        //存入集合中
        amap.put("desc",desc);

        return amap;

    }
}
