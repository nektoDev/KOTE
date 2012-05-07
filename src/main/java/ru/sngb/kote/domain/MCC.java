package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * MCCode ORM class.
 * @version 0.1
 * @author Tsykin V.A. ts.slawa@gmail.com
 */

@Entity
@Table (name = "k22_mcc")
public class Mcc {
    @Id
    @Column(name = "k22_mcc", nullable = false, insertable = true, updatable = true)
    private int mcc;
    
    @Basic
    @Column(name = "k22_description", nullable = false, insertable = true, updatable = true, length = 64)
    private String Description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mcc")
    private Collection<Organization> Organizations;

//Constructors
    public Mcc() {
    }

    public Mcc(int mcc, String Description) {
        this.mcc = mcc;
        this.Description = Description;
    }

//Getters and Setters
    public int getmcc() {
        return mcc;
    }

    public void setmcc(int mcc) {
        this.mcc = mcc;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Collection<Organization> getOrganizations() {
        return Organizations;
    }

    public void setOrganizations(Collection<Organization> Organizations) {
        this.Organizations = Organizations;
    }

//equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mcc MCC1 = (Mcc) o;

        if (mcc != MCC1.mcc) return false;
        if (Organizations != null ? !Organizations.equals(MCC1.Organizations) : MCC1.Organizations != null)
            return false;
        if (!Description.equals(MCC1.Description)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mcc;
        result = 31 * result + Description.hashCode();
        result = 31 * result + (Organizations != null ? Organizations.hashCode() : 0);
        return result;
    }

//toString()

    @Override
    public String toString() {
        return "Mcc{" +
                "Mcc=" + mcc +
                ", Description='" + Description + '\'' +
                '}';
    }
}
