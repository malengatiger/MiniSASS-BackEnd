/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.dto;

import com.boha.minisass.data.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aubreyM
 */
public class EvaluationImageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer evaluationImageID;
    private Date dateTaken;
    private String fileName;
    private Integer evaluationID;

    public EvaluationImageDTO() {
    }

    public EvaluationImageDTO(EvaluationImage a) {
        this.evaluationImageID = a.getEvaluationImageID();
        this.dateTaken = a.getDateTaken();
        this.fileName = a.getFileName();
        this.evaluationID = a.getEvaluation().getEvaluationID();
    }

    public Integer getEvaluationID() {
        return evaluationID;
    }

    public void setEvaluationID(Integer evaluationID) {
        this.evaluationID = evaluationID;
    }

    
    public Integer getEvaluationImageID() {
        return evaluationImageID;
    }

    public void setEvaluationImageID(Integer evaluationImageID) {
        this.evaluationImageID = evaluationImageID;
    }

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

  


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationImageID != null ? evaluationImageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EvaluationImageDTO)) {
            return false;
        }
        EvaluationImageDTO other = (EvaluationImageDTO) object;
        if ((this.evaluationImageID == null && other.evaluationImageID != null) || (this.evaluationImageID != null && !this.evaluationImageID.equals(other.evaluationImageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.EvaluationImage[ evaluationImageID=" + evaluationImageID + " ]";
    }
    
}
