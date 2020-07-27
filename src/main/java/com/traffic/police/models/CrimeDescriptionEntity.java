package com.traffic.police.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "crime_description", schema = "traffic_offence", catalog = "")
public class CrimeDescriptionEntity {
    private int caseid;
    private String casenumber;
    private String crime;
    private Date offencedate;
    private String offernderidnumber;
    private String offenceamount;
    private String offencestatus;
    private Date expirydate;
    private String vehiclenumber;
    private String licensenumber;
    private String issuerofficer;
    private String offencelocation;
    private Integer offence;
    private String mobilenumber;

    @Id
    @Column(name = "caseid")
    public int getCaseid() {
        return caseid;
    }

    public void setCaseid(int caseid) {
        this.caseid = caseid;
    }

    @Basic
    @Column(name = "casenumber")
    public String getCasenumber() {
        return casenumber;
    }

    public void setCasenumber(String casenumber) {
        this.casenumber = casenumber;
    }

    @Basic
    @Column(name = "crime")
    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    @Basic
    @Column(name = "offencedate")
    public Date getOffencedate() {
        return offencedate;
    }

    public void setOffencedate(Date offencedate) {
        this.offencedate = offencedate;
    }

    @Basic
    @Column(name = "offernderidnumber")
    public String getOffernderidnumber() {
        return offernderidnumber;
    }

    public void setOffernderidnumber(String offernderidnumber) {
        this.offernderidnumber = offernderidnumber;
    }

    @Basic
    @Column(name = "offenceamount")
    public String getOffenceamount() {
        return offenceamount;
    }

    public void setOffenceamount(String offenceamount) {
        this.offenceamount = offenceamount;
    }

    @Basic
    @Column(name = "offencestatus")
    public String getOffencestatus() {
        return offencestatus;
    }

    public void setOffencestatus(String offencestatus) {
        this.offencestatus = offencestatus;
    }

    @Basic
    @Column(name = "expirydate")
    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
    }

    @Basic
    @Column(name = "vehiclenumber")
    public String getVehiclenumber() {
        return vehiclenumber;
    }

    public void setVehiclenumber(String vehiclenumber) {
        this.vehiclenumber = vehiclenumber;
    }

    @Basic
    @Column(name = "licensenumber")
    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    @Basic
    @Column(name = "issuerofficer")
    public String getIssuerofficer() {
        return issuerofficer;
    }

    public void setIssuerofficer(String issuerofficer) {
        this.issuerofficer = issuerofficer;
    }

    @Basic
    @Column(name = "offencelocation")
    public String getOffencelocation() {
        return offencelocation;
    }

    public void setOffencelocation(String offencelocation) {
        this.offencelocation = offencelocation;
    }

    @Basic
    @Column(name = "offence")
    public Integer getOffence() {
        return offence;
    }

    public void setOffence(Integer offence) {
        this.offence = offence;
    }

    @Basic
    @Column(name = "mobilenumber")
    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrimeDescriptionEntity that = (CrimeDescriptionEntity) o;
        return caseid == that.caseid &&
                Objects.equals(casenumber, that.casenumber) &&
                Objects.equals(crime, that.crime) &&
                Objects.equals(offencedate, that.offencedate) &&
                Objects.equals(offernderidnumber, that.offernderidnumber) &&
                Objects.equals(offenceamount, that.offenceamount) &&
                Objects.equals(offencestatus, that.offencestatus) &&
                Objects.equals(expirydate, that.expirydate) &&
                Objects.equals(vehiclenumber, that.vehiclenumber) &&
                Objects.equals(licensenumber, that.licensenumber) &&
                Objects.equals(issuerofficer, that.issuerofficer) &&
                Objects.equals(offencelocation, that.offencelocation) &&
                Objects.equals(offence, that.offence) &&
                Objects.equals(mobilenumber, that.mobilenumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseid, casenumber, crime, offencedate, offernderidnumber, offenceamount, offencestatus, expirydate, vehiclenumber, licensenumber, issuerofficer, offencelocation, offence, mobilenumber);
    }
}
