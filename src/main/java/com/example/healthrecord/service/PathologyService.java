package com.example.healthrecord.service;

import com.example.healthrecord.entity.Pathology;
import com.example.healthrecord.mapper.PathologyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: 类名称
 *
 * @Description: 描述
 * @Author 类创建者
 * @CreatDate 创建日期
 */

@Service
public class PathologyService {

    @Autowired
    private PathologyMapper mapper;

    public List<Pathology> selectBypathology(Pathology pathology){
        return mapper.selectBypathology(pathology);
    }


}
