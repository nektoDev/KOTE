package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Jurface and Organization requisites ORM class
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */
@Entity
@Table(name = "k25_requisites")
public class Requisites {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k25_requisites_id", insertable = true, updatable = false, nullable = false)
    private int RequisitesId;

    @Basic
    @Column(name = "k25_rs", insertable = true, updatable = false, nullable = false, length = 20)
    private String rs;

    @Basic
    @Column(name = "k25_ks", insertable = true, updatable = false, nullable = false, length = 19)
    private String ks;

    @Basic
    @Column(name = "k25_bik", insertable = true, updatable = false, nullable = false, length = 9)
    private String bik;

    @Basic
    @Column(name = "k25_bank", insertable = true, updatable = false, nullable = false, length = 32)
    private String Bank;

    @OneToMany(mappedBy = "Requisites", cascade = CascadeType.ALL)
    private Collection<Organization> Organizations;

    //Constructors
    public Requisites() {
    }

    public Requisites(String rs, String ks, String bik, String Bank) {
        this.rs = rs;
        this.ks = ks;
        this.bik = bik;
        this.Bank = Bank;
    }

    //Getters and Setters
    public int getRequisitesId() {
        return RequisitesId;
    }

    public String getrs() {
        return rs;
    }

    public void setrs(String rs) {
        this.rs = rs;
    }

    public String getks() {
        return ks;
    }

    public void setks(String ks) {
        this.ks = ks;
    }

    public String getbik() {
        return bik;
    }

    public void setbik(String bik) {
        this.bik = bik;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String Bank) {
        this.Bank = Bank;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Requisites that = (Requisites) o;

        if (RequisitesId != that.RequisitesId) return false;
        if (Organizations != null ? !Organizations.equals(that.Organizations) : that.Organizations != null)
            return false;
        if (!Bank.equals(that.Bank)) return false;
        if (!bik.equals(that.bik)) return false;
        if (!ks.equals(that.ks)) return false;
        if (!rs.equals(that.rs)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = RequisitesId;
        result = 31 * result + rs.hashCode();
        result = 31 * result + ks.hashCode();
        result = 31 * result + bik.hashCode();
        result = 31 * result + Bank.hashCode();
        result = 31 * result + (Organizations != null ? Organizations.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Requisites{" +
                "RequisitesId=" + RequisitesId +
                ", rs='" + rs + '\'' +
                ", ks='" + ks + '\'' +
                ", bik='" + bik + '\'' +
                ", Bank='" + Bank + '\'' +
                '}';
    }
}
