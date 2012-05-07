package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Device Status class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */

@javax.persistence.Table(name = "k32_device_status")
@Entity
public class DeviceStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k32_device_status_id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int DeviceStatusId;

    @Basic
    @Column(name = "k32_device_status", nullable = false, insertable = true, updatable = true, length = 32, precision = 0)
    private String DeviceStatus;

    @OneToMany(mappedBy = "DeviceStatus")
    private Collection<Device> Devices;

    //Constructors
    public DeviceStatus() {
    }

    public DeviceStatus(String DeviceStatus) {
        this.DeviceStatus = DeviceStatus;
    }

    //Getters and Setters
    public int getDeviceStatusId() {
        return DeviceStatusId;
    }

    public String getDeviceStatus() {
        return DeviceStatus;
    }

    public void setDeviceStatus(String DeviceStatus) {
        this.DeviceStatus = DeviceStatus;
    }

    public Collection<Device> getDevices() {
        return Devices;
    }

    public void setDevices(Collection<Device> Devices) {
        this.Devices = Devices;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceStatus that = (DeviceStatus) o;

        if (DeviceStatusId != that.DeviceStatusId) return false;
        if (Devices != null ? !Devices.equals(that.Devices) : that.Devices != null) return false;
        if (!DeviceStatus.equals(that.DeviceStatus)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = DeviceStatusId;
        result = 31 * result + DeviceStatus.hashCode();
        result = 31 * result + (Devices != null ? Devices.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "DeviceStatus{" +
                "DeviceStatusId=" + DeviceStatusId +
                ", DeviceStatus='" + DeviceStatus + '\'' +
                '}';
    }
}
