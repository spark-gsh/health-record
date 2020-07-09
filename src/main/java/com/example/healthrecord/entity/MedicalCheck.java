package com.example.healthrecord.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * medical_check
 * @author 
 */
@JsonIgnoreProperties(value = {"handler"})
public class MedicalCheck implements Serializable {
    private String mCId;

    private String bRId;

    /**
     * 'cm'
     */
    private String internal;

    /**
     * 'kg'
     */
    private String surgery;

    private String eye;

    /**
     * '裸眼视力'
     */
    private String fiveSense;

    /**
     * '眼疾'
     */
    private String neurology;

    private String blood;

    private String bloodBiochemistry;

    private String urine;

    private String radiate;

    private String ecg;

    private String physicalResult;

    private String physicalAdvice;

    private String physicalTime;

    private String physicalDoctor;

    private BasicRecord basicRecord;

    private static final long serialVersionUID = 1L;

    public String getmCId() {
        return mCId;
    }

    public void setmCId(String mCId) {
        this.mCId = mCId;
    }

    public String getbRId() {
        return bRId;
    }

    public void setbRId(String bRId) {
        this.bRId = bRId;
    }

    public String getInternal() {
        return internal;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public String getSurgery() {
        return surgery;
    }

    public void setSurgery(String surgery) {
        this.surgery = surgery;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public String getFiveSense() {
        return fiveSense;
    }

    public void setFiveSense(String fiveSense) {
        this.fiveSense = fiveSense;
    }

    public String getNeurology() {
        return neurology;
    }

    public void setNeurology(String neurology) {
        this.neurology = neurology;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getBloodBiochemistry() {
        return bloodBiochemistry;
    }

    public void setBloodBiochemistry(String bloodBiochemistry) {
        this.bloodBiochemistry = bloodBiochemistry;
    }

    public String getUrine() {
        return urine;
    }

    public void setUrine(String urine) {
        this.urine = urine;
    }

    public String getRadiate() {
        return radiate;
    }

    public void setRadiate(String radiate) {
        this.radiate = radiate;
    }

    public String getEcg() {
        return ecg;
    }

    public void setEcg(String ecg) {
        this.ecg = ecg;
    }

    public String getPhysicalResult() {
        return physicalResult;
    }

    public void setPhysicalResult(String physicalResult) {
        this.physicalResult = physicalResult;
    }

    public String getPhysicalAdvice() {
        return physicalAdvice;
    }

    public void setPhysicalAdvice(String physicalAdvice) {
        this.physicalAdvice = physicalAdvice;
    }

    public String getPhysicalTime() {
        return physicalTime;
    }

    public void setPhysicalTime(String physicalTime) {
        this.physicalTime = physicalTime;
    }

    public String getPhysicalDoctor() {
        return physicalDoctor;
    }

    public void setPhysicalDoctor(String physicalDoctor) {
        this.physicalDoctor = physicalDoctor;
    }

    public BasicRecord getBasicRecord() {
        return basicRecord;
    }

    public void setBasicRecord(BasicRecord basicRecord) {
        this.basicRecord = basicRecord;
    }
}