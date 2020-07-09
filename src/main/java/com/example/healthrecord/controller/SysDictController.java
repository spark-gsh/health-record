package com.example.healthrecord.controller;

import com.example.healthrecord.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ClassName: 类名称
 *
 * @Description: 描述
 * @Author 类创建者
 * @CreatDate 创建日期
 */

@RestController
public class SysDictController {
    @Autowired
    private SysDictService service;

    @RequestMapping("people/searchAll")
    public Map<String, Object> searchAll(){
        return service.searchAll();
    }
}
