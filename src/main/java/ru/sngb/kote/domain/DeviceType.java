package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Device type ORM
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */
@Entity
@Table(name = "k35_device_type")
public class DeviceType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k35_device_type_id", insertable = true, updatable = true, nullable = false)
    private int DeviceTypeId;

    @Basic
    @Column(name = "k35_device_type", insertable = true, updatable = true, nullable = false, unique = true, length = 64)
    private String DeviceType;

    @OneToMany(mappedBy = "DeviceTypeId", cascade = CascadeType.ALL)
    private Collection<Model> Models;

    //Constructors
    public DeviceType() {
    }

    public DeviceType(String DeviceType) {
        this.DeviceType = DeviceType;
    }

    //Getters and setters
    public int getDeviceTypeId() {
        return DeviceTypeId;
    }

    public String getDeviceType() {
        return DeviceType;
    }

    public void setDeviceType(String DeviceType) {
        this.DeviceType = DeviceType;
    }

    public Collection<Model> getmodelsByDeviceTypeId() {
        return Models;
    }

    public void setmodelsByDeviceTypeId(Collection<Model> modelsByDeviceTypeId) {
        this.Models = modelsByDeviceTypeId;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceType that = (DeviceType) o;

        if (DeviceTypeId != that.DeviceTypeId) return false;
        if (Models != null ? !Models.equals(that.Models) : that.Models != null)
            return false;
        if (!DeviceType.equals(that.DeviceType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = DeviceTypeId;
        result = 31 * result + (Models != null ? Models.hashCode() : 0);
        result = 31 * result + DeviceType.hashCode();
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "DeviceType{" +
                "DeviceTypeId=" + DeviceTypeId +
                ", DeviceType='" + DeviceType + '\'' +
                '}';
    }
}
