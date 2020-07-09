package com.example.healthrecord.service;

import com.example.healthrecord.entity.AreaDivide;
import com.example.healthrecord.mapper.AreaDivideMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaService {

    @Autowired
    private AreaDivideMapper mapper;

    public Map<String,Object> searchAll(){

        //创建一个集合接收数据库数据
        List<AreaDivide> alist = new ArrayList<>();

        //创建一个map集合来存放decs
        Map<String,Object> amap = new HashMap<String, Object>();

        alist = mapper.searchAll();

        //创建装载desc的数组
        String[] desc = new String[alist.size()];

        int i=0;
        //遍历数据库数据
        for (AreaDivide areaDivide:alist){
            desc[i] = areaDivide.getDesc();
            i++;
        }
        //存入集合中
        amap.put("desc",desc);

        return amap;

    }


}
