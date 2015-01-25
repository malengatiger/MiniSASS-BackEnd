/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.boha.minisass.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aubreyM
 */
@Entity
@Table(name = "evaluation")
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findByEvaluationID", query = "SELECT e FROM Evaluation e WHERE e.evaluationID = :evaluationID"),
    @NamedQuery(name = "Evaluation.findByEvaluationDate", query = "SELECT e FROM Evaluation e WHERE e.evaluationDate = :evaluationDate"),
    @NamedQuery(name = "Evaluation.findByScore", query = "SELECT e FROM Evaluation e WHERE e.score = :score"),
    @NamedQuery(name = "Evaluation.findByPH", query = "SELECT e FROM Evaluation e WHERE e.pH = :pH"),
    @NamedQuery(name = "Evaluation.findByWaterTemperature", query = "SELECT e FROM Evaluation e WHERE e.waterTemperature = :waterTemperature"),
    @NamedQuery(name = "Evaluation.findByOxygen", query = "SELECT e FROM Evaluation e WHERE e.oxygen = :oxygen"),
    @NamedQuery(name = "Evaluation.findByWaterClarity", query = "SELECT e FROM Evaluation e WHERE e.waterClarity = :waterClarity"),
    @NamedQuery(name = "Evaluation.findByLatitude", query = "SELECT e FROM Evaluation e WHERE e.latitude = :latitude"),
    @NamedQuery(name = "Evaluation.findByLongitude", query = "SELECT e FROM Evaluation e WHERE e.longitude = :longitude")})
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "evaluationID")
    private Integer evaluationID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "evaluationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date evaluationDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "comment")
    private String comment;
    @Column(name = "score")
    private Double score;
    @Column(name = "pH")
    private Double pH;
    @Column(name = "waterTemperature")
    private Double waterTemperature;
    @Column(name = "oxygen")
    private Double oxygen;
    @Column(name = "waterClarity")
    private Double waterClarity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private Double latitude;
    @Basic(optional = false)
    @NotNull
    
    private Double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluation")
    private List<EvaluationImage> evaluationImageList;
    @JoinColumn(name = "teamMemberID", referencedColumnName = "teamMemberID")
    @ManyToOne(optional = false)
    private TeamMember teamMember;
    @JoinColumn(name = "evaluationSiteID", referencedColumnName = "evaluationSiteID")
    @ManyToOne(optional = false)
    private EvaluationSite evaluationSite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluation")
    private List<EvaluationInsect> evaluationInsectList;

    public Evaluation() {
    }

    public Evaluation(Integer evaluationID) {
        this.evaluationID = evaluationID;
    }

    public Evaluation(Integer evaluationID, Date evaluationDate, Double latitude, Double longitude) {
        this.evaluationID = evaluationID;
        this.evaluationDate = evaluationDate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getEvaluationID() {
        return evaluationID;
    }

    public void setEvaluationID(Integer evaluationID) {
        this.evaluationID = evaluationID;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getPH() {
        return pH;
    }

    public void setPH(Double pH) {
        this.pH = pH;
    }

    public Double getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(Double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public Double getOxygen() {
        return oxygen;
    }

    public void setOxygen(Double oxygen) {
        this.oxygen = oxygen;
    }

    public Double getWaterClarity() {
        return waterClarity;
    }

    public void setWaterClarity(Double waterClarity) {
        this.waterClarity = waterClarity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    
    public List<EvaluationImage> getEvaluationImageList() {
        return evaluationImageList;
    }

    public void setEvaluationImageList(List<EvaluationImage> evaluationImageList) {
        this.evaluationImageList = evaluationImageList;
    }

    public Double getpH() {
        return pH;
    }

    public void setpH(Double pH) {
        this.pH = pH;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }

    public EvaluationSite getEvaluationSite() {
        return evaluationSite;
    }

    public void setEvaluationSite(EvaluationSite evaluationSite) {
        this.evaluationSite = evaluationSite;
    }

    public List<EvaluationInsect> getEvaluationInsectList() {
        return evaluationInsectList;
    }

    public void setEvaluationInsectList(List<EvaluationInsect> evaluationInsectList) {
        this.evaluationInsectList = evaluationInsectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evaluationID != null ? evaluationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.evaluationID == null && other.evaluationID != null) || (this.evaluationID != null && !this.evaluationID.equals(other.evaluationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.boha.minisass.data.Evaluation[ evaluationID=" + evaluationID + " ]";
    }
    
}
