package com.example.healthrecord.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * return_visit
 * @author 
 */
@JsonIgnoreProperties(value = {"handler"})
public class ReturnVisit implements Serializable {
    private String rVId;

    private String bRId;

    private String administrative;

    private String disease;

    private String recovery;

    private String returnDate;

    private String evaluation;

    private String advice;

    private String rEId;

    private BasicRecord basicRecord;

    private ReturnEvaluation returnEvaluation;

    private static final long serialVersionUID = 1L;

    public String getrVId() {
        return rVId;
    }

    public void setrVId(String rVId) {
        this.rVId = rVId;
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

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getrEId() {
        return rEId;
    }

    public void setrEId(String rEId) {
        this.rEId = rEId;
    }

    public BasicRecord getBasicRecord() {
        return basicRecord;
    }

    public void setBasicRecord(BasicRecord basicRecord) {
        this.basicRecord = basicRecord;
    }

    public ReturnEvaluation getReturnEvaluation() {
        return returnEvaluation;
    }

    public void setReturnEvaluation(ReturnEvaluation returnEvaluation) {
        this.returnEvaluation = returnEvaluation;
    }
}