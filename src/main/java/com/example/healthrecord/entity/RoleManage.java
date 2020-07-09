package com.example.healthrecord.entity;

import java.io.Serializable;

/**
 * role_manage
 * @author 
 */
public class RoleManage implements Serializable {
    private String rMId;

    private String role;

    private static final long serialVersionUID = 1L;

    public String getrMId() {
        return rMId;
    }

    public void setrMId(String rMId) {
        this.rMId = rMId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}