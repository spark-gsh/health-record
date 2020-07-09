package com.example.healthrecord.entity;

import java.io.Serializable;

/**
 * return_evaluation
 * @author 
 */
public class ReturnEvaluation implements Serializable {
    private String rEId;

    private String desc;

    private static final long serialVersionUID = 1L;

    public String getrEId() {
        return rEId;
    }

    public void setrEId(String rEId) {
        this.rEId = rEId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}