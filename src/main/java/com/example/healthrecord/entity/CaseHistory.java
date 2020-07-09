package com.example.healthrecord.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

/**
 * case_history
 * @author 
 */
@JsonIgnoreProperties(value = {"handler"})
public class CaseHistory implements Serializable {
    private String cHId;

    /**
     * 档案编号
     */
    private String bRId;

    /**
     * '科室'
     */
    private String administrative;

    /**
     * 就诊时间

     */
    private String historyDate;

    /**
     * 主诉
     */
    private String cc;

    /**
     * 现病史
     */
    private String hpi;

    /**
     * 既往史
     */
    private String pmh;

    /**
     * 过敏史
     */
    private String allergy;

    /**
     * 体格检查
     */
    private String physicalCheck;

    /**
     * 辅助检查
     */
    private String auxiliaryExamination;

    /**
     * 初步诊断
     */
    private String primaryDiagnosis;

    /**
     * 处理意见
     */
    private String processingOpinion;

    /**
     * 医师
     */
    private String doctor;

    private BasicRecord basicRecord;

    private static final long serialVersionUID = 1L;

    public String getcHId() {
        return cHId;
    }

    public void setcHId(String cHId) {
        this.cHId = cHId;
    }

    public String getbRId() {
        return bRId;
    }

    public void setbRId(String bRId) {
        this.bRId = bRId;
    }

    public String getAdministrative() {
        return administrative;
    }

    public void setAdministrative(String administrative) {
        this.administrative = administrative;
    }

    public String getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(String historyDate) {
        this.historyDate = historyDate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getHpi() {
        return hpi;
    }

    public void setHpi(String hpi) {
        this.hpi = hpi;
    }

    public String getPmh() {
        return pmh;
    }

    public void setPmh(String pmh) {
        this.pmh = pmh;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getPhysicalCheck() {
        return physicalCheck;
    }

    public void setPhysicalCheck(String physicalCheck) {
        this.physicalCheck = physicalCheck;
    }

    public String getAuxiliaryExamination() {
        return auxiliaryExamination;
    }

    public void setAuxiliaryExamination(String auxiliaryExamination) {
        this.auxiliaryExamination = auxiliaryExamination;
    }

    public String getPrimaryDiagnosis() {
        return primaryDiagnosis;
    }

    public void setPrimaryDiagnosis(String primaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
    }

    public String getProcessingOpinion() {
        return processingOpinion;
    }

    public void setProcessingOpinion(String processingOpinion) {
        this.processingOpinion = processingOpinion;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public BasicRecord getBasicRecord() {
        return basicRecord;
    }

    public void setBasicRecord(BasicRecord basicRecord) {
        this.basicRecord = basicRecord;
    }
}