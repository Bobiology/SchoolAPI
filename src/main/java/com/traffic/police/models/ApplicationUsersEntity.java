package com.traffic.police.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "application_users", schema = "traffic_offence", catalog = "")
public class ApplicationUsersEntity {
    private int userid;
    private String fullName;
    private String email;
    private int idNumber;
    private Date regDate;
    private String roleId;
    private String mobileNumber;
    private String password;
    private String userstatus;

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "id_number")
    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Basic
    @Column(name = "Reg_date")
    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Basic
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "mobile_number")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "userstatus")
    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplicationUsersEntity entity = (ApplicationUsersEntity) o;
        return userid == entity.userid &&
                idNumber == entity.idNumber &&
                Objects.equals(fullName, entity.fullName) &&
                Objects.equals(email, entity.email) &&
                Objects.equals(regDate, entity.regDate) &&
                Objects.equals(roleId, entity.roleId) &&
                Objects.equals(mobileNumber, entity.mobileNumber) &&
                Objects.equals(password, entity.password) &&
                Objects.equals(userstatus, entity.userstatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, fullName, email, idNumber, regDate, roleId, mobileNumber, password, userstatus);
    }
}
