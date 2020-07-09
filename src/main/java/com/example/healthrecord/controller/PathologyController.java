package com.example.healthrecord.controller;

import com.example.healthrecord.Utils.TableData;
import com.example.healthrecord.entity.Pathology;
import com.example.healthrecord.service.PathologyService;
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
public class PathologyController {

    @Autowired
    private PathologyService service;

    @RequestMapping("pathology/name")
    public TableData<Pathology> selectHypertension(Pathology pathology){

        System.out.println("name:"+pathology.getDiseaseName());
        System.out.println("administration:"+pathology.getAdministration());


        List<Pathology> result = service.selectBypathology(pathology);

        TableData<Pathology> tableData = new TableData<>();

        tableData.setCode(0);
        tableData.setCount(10);
        tableData.setData(result);

        return tableData;
    }
}
