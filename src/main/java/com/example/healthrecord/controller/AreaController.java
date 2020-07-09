package com.example.healthrecord.controller;

import com.example.healthrecord.entity.AreaDivide;
import com.example.healthrecord.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AreaController {

    @Autowired
    private AreaService service;

    @RequestMapping("area/searchAll")
    public Map<String, Object> searchAll(){
        return service.searchAll();
    }
}
