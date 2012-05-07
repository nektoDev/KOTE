package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Vendor ORM
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */

@Entity
@Table(name = "k34_vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k34_vendor_id", updatable = true, insertable = true, nullable = false)
    private int vendorId;

    @Basic
    @Column(name = "k34_vendor", insertable = true, updatable = true, nullable = false, unique = true, length = 32)
    private String Vendor;

    @OneToMany(mappedBy = "VendorId", cascade = CascadeType.ALL)
    private Collection<Model> Models;

    //Constructor
    public Vendor() {
    }

    public Vendor(String Vendor) {
        this.Vendor = Vendor;
    }

    //Getters and setters
    public int getvendorId() {
        return vendorId;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }

    public Collection<Model> getModelsByVendor() {
        return Models;
    }

    public void setModelsByVendor(Collection<Model> ModelsByVendor) {
        this.Models = ModelsByVendor;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vendor Vendor1 = (Vendor) o;

        if (vendorId != Vendor1.vendorId) return false;
        if (Models != null ? !Models.equals(Vendor1.Models) : Vendor1.Models != null)
            return false;
        if (!Vendor.equals(Vendor1.Vendor)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vendorId;
        result = 31 * result + (Models != null ? Models.hashCode() : 0);
        result = 31 * result + Vendor.hashCode();
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Vendor{" +
                "vendorId=" + vendorId +
                ", Vendor='" + Vendor + '\'' +
                '}';
    }
}
