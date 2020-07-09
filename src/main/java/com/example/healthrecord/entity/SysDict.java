package com.example.healthrecord.entity;

import java.io.Serializable;

/**
 * sys_dict
 * @author 
 */
public class SysDict implements Serializable {
    private String sDId;

    private String vartityId;

    private String desc;

    private static final long serialVersionUID = 1L;

    public String getsDId() {
        return sDId;
    }

    public void setsDId(String sDId) {
        this.sDId = sDId;
    }

    public String getVartityId() {
        return vartityId;
    }

    public void setVartityId(String vartityId) {
        this.vartityId = vartityId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}