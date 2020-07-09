package com.example.healthrecord.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * sys_manage
 * @author 
 */
@JsonIgnoreProperties(value = {"handler"})
public class SysManage implements Serializable {
    private String sMId;

    private String username;

    private String password;

    private Date creatTime;

    private String sDId;

    private RoleManage roleManage;

    private static final long serialVersionUID = 1L;

    public String getsMId() {
        return sMId;
    }

    public void setsMId(String sMId) {
        this.sMId = sMId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getsDId() {
        return sDId;
    }

    public void setsDId(String sDId) {
        this.sDId = sDId;
    }

    public RoleManage getRoleManage() {
        return roleManage;
    }

    public void setRoleManage(RoleManage roleManage) {
        this.roleManage = roleManage;
    }
}