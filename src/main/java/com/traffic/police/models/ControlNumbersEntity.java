package com.traffic.police.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "control_numbers", schema = "traffic_offence", catalog = "")
public class ControlNumbersEntity {
    private int caseNumber;
    private String offencelocation;
    private String issuerofficer;
    private String amount;
    private String description;
    private Integer offendernationalid;


    @Id
    @Column(name="case_number",updatable=false,nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
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
    @Column(name = "issuerofficer")
    public String getIssuerofficer() {
        return issuerofficer;
    }

    public void setIssuerofficer(String issuerofficer) {
        this.issuerofficer = issuerofficer;
    }

    @Basic
    @Column(name = "Amount")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Offendernationalid")
    public Integer getOffendernationalid() {
        return offendernationalid;
    }

    public void setOffendernationalid(Integer offendernationalid) {
        this.offendernationalid = offendernationalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControlNumbersEntity that = (ControlNumbersEntity) o;
        return caseNumber == that.caseNumber &&
                Objects.equals(offencelocation, that.offencelocation) &&
                Objects.equals(issuerofficer, that.issuerofficer) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(description, that.description) &&
                Objects.equals(offendernationalid, that.offendernationalid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseNumber, offencelocation, issuerofficer, amount, description, offendernationalid);
    }
}
