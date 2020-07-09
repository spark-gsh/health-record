package com.example.healthrecord.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * record_type
 * @author 
 */
@JsonIgnoreProperties(value = {"handler"})

public class RecordType implements Serializable {
    /**
     * 传染及慢性病档案类别
     */
    private String rTId;

    private String desc;

    private static final long serialVersionUID = 1L;

    public String getrTId() {
        return rTId;
    }

    public void setrTId(String rTId) {
        this.rTId = rTId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}