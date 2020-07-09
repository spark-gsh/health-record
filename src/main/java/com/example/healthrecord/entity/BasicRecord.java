package com.example.healthrecord.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * basic_record
 * @author 
 */
@JsonIgnoreProperties(value = {"handler"})
public class BasicRecord implements Serializable {
    /**
     * 档案编号
     */
    private String bRId;

    /**
     * 社区划分及人群类型
     */
    private String vartityId;

    private String name;

    private Long idNumber;

    /**
     * 户口类型
     */
    private String rprType;

    private String gender;

    private String birth;

    private String nation;

    private String country;

    private String address;

    private String bloodType;

    private String culture;

    private String job;

    /**
     * 婚否
     */
    private String maritalStatus;

    /**
     * 病例编号
     */
    private String cHId;

    /**
     * 体检报告单编号
     */
    private String mCId;

    /**
     * 区域编号
     */
    private String areaId;

    /**
     * 联系方式
     */
    private Long tele;

    private String rTId;
    private String rVId;

    private Integer recordCount;

    private Integer diseaseCount;

    private SysDict sysDict;

    private AreaDivide areaDivide;

    private RecordType recordType;

    private static final long serialVersionUID = 1L;

    public String getbRId() {
        return bRId;
    }

    public void setbRId(String bRId) {
        this.bRId = bRId;
    }

    public String getVartityId() {
        return vartityId;
    }

    public void setVartityId(String vartityId) {
        this.vartityId = vartityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getRprType() {
        return rprType;
    }

    public void setRprType(String rprType) {
        this.rprType = rprType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getcHId() {
        return cHId;
    }

    public void setcHId(String cHId) {
        this.cHId = cHId;
    }

    public String getmFId() {
        return mCId;
    }

    public void setmFId(String mCId) {
        this.mCId = mCId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public SysDict getSysDict() {
        return sysDict;
    }

    public void setSysDict(SysDict sysDict) {
        this.sysDict = sysDict;
    }

    public AreaDivide getAreaDivide() {
        return areaDivide;
    }

    public void setAreaDivide(AreaDivide areaDivide) {
        this.areaDivide = areaDivide;
    }

    public Long getTele() {
        return tele;
    }

    public void setTele(Long tele) {
        this.tele = tele;
    }

    public String getrTId() {
        return rTId;
    }

    public void setrTId(String rTId) {
        this.rTId = rTId;
    }

    public Integer getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(Integer recordCount) {
        this.recordCount = recordCount;
    }

    public RecordType getRecordType() {
        return recordType;
    }

    public void setRecordType(RecordType recordType) {
        this.recordType = recordType;
    }

    public String getrVId() {
        return rVId;
    }

    public void setrVId(String rVId) {
        this.rVId = rVId;
    }

    public Integer getDiseaseCount() {
        return diseaseCount;
    }

    public void setDiseaseCount(Integer diseaseCount) {
        this.diseaseCount = diseaseCount;
    }
}