package com.traffic.police.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "offences", schema = "traffic_offence", catalog = "")
public class OffencesEntity {
    private int offenceid;
    private String offencedescription;
    private String offenceamount;

    @Id
    @Column(name = "offenceid")
    public int getOffenceid() {
        return offenceid;
    }

    public void setOffenceid(int offenceid) {
        this.offenceid = offenceid;
    }

    @Basic
    @Column(name = "offencedescription")
    public String getOffencedescription() {
        return offencedescription;
    }

    public void setOffencedescription(String offencedescription) {
        this.offencedescription = offencedescription;
    }

    @Basic
    @Column(name = "offenceamount")
    public String getOffenceamount() {
        return offenceamount;
    }

    public void setOffenceamount(String offenceamount) {
        this.offenceamount = offenceamount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffencesEntity that = (OffencesEntity) o;
        return offenceid == that.offenceid &&
                Objects.equals(offencedescription, that.offencedescription) &&
                Objects.equals(offenceamount, that.offenceamount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offenceid, offencedescription, offenceamount);
    }
}
