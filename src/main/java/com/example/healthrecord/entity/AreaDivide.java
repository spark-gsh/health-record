package com.example.healthrecord.entity;

import java.io.Serializable;

/**
 * area_divide
 * @author 
 */
public class AreaDivide implements Serializable {
    private String aDId;

    /**
     * 详细地址
     */
    private String desc;

    private static final long serialVersionUID = 1L;

    public String getaDId() {
        return aDId;
    }

    public void setaDId(String aDId) {
        this.aDId = aDId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}