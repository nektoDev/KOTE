package ru.sngb.kote.domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Device ORM class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */
//TODO look for nullable and unique
@javax.persistence.Table(name = "k30_device")
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k30_device_id", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    private int DeviceId;

    @Basic
    @javax.persistence.Column(name = "k30_sn", nullable = false, insertable = true, updatable = true, unique = true, length = 20, precision = 0)
    private String Sn;

    @Basic
    @javax.persistence.Column(name = "k30_inv", nullable = true, insertable = true, updatable = true, unique = true, length = 8, precision = 0)
    private String Inv;

    @Basic
    @javax.persistence.Column(name = "k30_guarantee", nullable = false, insertable = true, updatable = true, length = 13, precision = 0)
    private Date Guarantee;

    @Basic
    @javax.persistence.Column(name = "k30_book_cost", nullable = false, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger BookCost;

    @Basic
    @javax.persistence.Column(name = "k30_cost", nullable = false, insertable = true, updatable = true, length = 131089, precision = 0)
    private BigInteger Cost;

    @Basic
    @Column(name = "k30_enabled", insertable = true, updatable = true, nullable = false)
    private boolean Enabled = true;

    @ManyToOne(cascade = CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "k31_model_id", referencedColumnName = "k31_model_id", nullable = false)
    private Model ModelId;

    @ManyToOne(cascade = CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "k32_device_status_id", referencedColumnName = "k32_device_status_id", nullable = false)
    private DeviceStatus DeviceStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "k33_shipment_id", referencedColumnName = "k33_shipment_id", nullable = false)
    private Shipment ShipmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k00_filial_id", referencedColumnName = "k00_filial_id")
    private Filial FilialId;

    @OneToMany(mappedBy = "Device", cascade = CascadeType.ALL)
    private Collection<Pos> Pos;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "k37_device_relation",
            joinColumns = {@JoinColumn(name = "k37_parent_id")},
            inverseJoinColumns = {@JoinColumn(name = "k37_daughter_id")})
    private Set<Device> DeviceDaughters = new HashSet<Device>();

    @ManyToMany(mappedBy = "DeviceDaughters", cascade = CascadeType.ALL)
    private Set<Device> DeviceParents = new HashSet<Device>();

    //Constructors
    public Device() {
    }

    public Device(String Sn, String Inv, Date Guarantee, BigInteger BookCost, BigInteger Cost, boolean Enabled, Model ModelId, DeviceStatus DeviceStatus, Shipment ShipmentId, Filial FilialId) {
        this.Sn = Sn;
        this.Inv = Inv;
        this.Guarantee = Guarantee;
        this.BookCost = BookCost;
        this.Cost = Cost;
        this.Enabled = Enabled;
        this.ModelId = ModelId;
        this.DeviceStatus = DeviceStatus;
        this.ShipmentId = ShipmentId;
        this.FilialId = FilialId;
    }

    // Getters and setters
    public String getSn() {
        return Sn;
    }

    public void setSn(String Sn) {
        this.Sn = Sn;
    }

    public String getInv() {
        return Inv;
    }

    public void setInv(String Inv) {
        this.Inv = Inv;
    }

    public Date getGuarantee() {
        return Guarantee;
    }

    public void setGuarantee(Date Guarantee) {
        this.Guarantee = Guarantee;
    }

    public BigInteger getBookCost() {
        return BookCost;
    }

    public void setBookCost(BigInteger BookCost) {
        this.BookCost = BookCost;
    }

    public BigInteger getCost() {
        return Cost;
    }

    public void setCost(BigInteger Cost) {
        this.Cost = Cost;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean Enabled) {
        this.Enabled = Enabled;
    }

    public Model getModelId() {
        return ModelId;
    }

    public void setModelId(Model ModelId) {
        this.ModelId = ModelId;
    }

    public DeviceStatus getDeviceStatus() {
        return DeviceStatus;
    }

    public void setDeviceStatus(DeviceStatus DeviceStatus) {
        this.DeviceStatus = DeviceStatus;
    }

    public Shipment getShipmentId() {
        return ShipmentId;
    }

    public void setShipmentId(Shipment ShipmentId) {
        this.ShipmentId = ShipmentId;
    }

    public Filial getFilialId() {
        return FilialId;
    }

    public void setFilialId(Filial FilialId) {
        this.FilialId = FilialId;
    }

    public Collection<Pos> getpos() {
        return Pos;
    }

    public void setpos(Collection<Pos> Pos) {
        this.Pos = Pos;
    }

    public Set<Device> getDeviceDaughters() {
        return DeviceDaughters;
    }

    public void setDeviceDaughters(Set<Device> DeviceDaughters) {
        this.DeviceDaughters = DeviceDaughters;
    }

    public Set<Device> getDeviceParents() {
        return DeviceParents;
    }

    /**
     * @deprecated
     */
    public void setDeviceParents(Set<Device> DeviceParents) {
        this.DeviceParents = DeviceParents;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device Device = (Device) o;

        if (DeviceId != Device.DeviceId) return false;
        if (Enabled != Device.Enabled) return false;
        if (!FilialId.equals(Device.FilialId)) return false;
        if (BookCost != null ? !BookCost.equals(Device.BookCost) : Device.BookCost != null)
            return false;
        if (Cost != null ? !Cost.equals(Device.Cost) : Device.Cost != null) return false;
        if (DeviceDaughters != null ? !DeviceDaughters.equals(Device.DeviceDaughters) : Device.DeviceDaughters != null)
            return false;
        if (DeviceParents != null ? !DeviceParents.equals(Device.DeviceParents) : Device.DeviceParents != null)
            return false;
        if (Guarantee != null ? !Guarantee.equals(Device.Guarantee) : Device.Guarantee != null)
            return false;
        if (!Inv.equals(Device.Inv)) return false;
        if (!Sn.equals(Device.Sn)) return false;
        if (!ModelId.equals(Device.ModelId)) return false;
        if (!DeviceStatus.equals(Device.DeviceStatus)) return false;
        if (ShipmentId != null ? !ShipmentId.equals(Device.ShipmentId) : Device.ShipmentId != null)
            return false;
        if (Pos != null ? !Pos.equals(Device.Pos) : Device.Pos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = DeviceId;
        result = 31 * result + Sn.hashCode();
        result = 31 * result + Inv.hashCode();
        result = 31 * result + (Guarantee != null ? Guarantee.hashCode() : 0);
        result = 31 * result + (BookCost != null ? BookCost.hashCode() : 0);
        result = 31 * result + (Cost != null ? Cost.hashCode() : 0);
        result = 31 * result + (Enabled ? 1 : 0);
        result = 31 * result + ModelId.hashCode();
        result = 31 * result + DeviceStatus.hashCode();
        result = 31 * result + (ShipmentId != null ? ShipmentId.hashCode() : 0);
        result = 31 * result + FilialId.hashCode();
        result = 31 * result + (Pos != null ? Pos.hashCode() : 0);
        result = 31 * result + (DeviceDaughters != null ? DeviceDaughters.hashCode() : 0);
        result = 31 * result + (DeviceParents != null ? DeviceParents.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Device{" +
                "DeviceId=" + DeviceId +
                ", Sn='" + Sn + '\'' +
                ", Inv='" + Inv + '\'' +
                ", Guarantee=" + Guarantee +
                ", BookCost=" + BookCost +
                ", Cost=" + Cost +
                ", Enabled=" + Enabled +
                ", ModelId=" + ModelId +
                ", DeviceStatus=" + DeviceStatus +
                ", ShipmentId=" + ShipmentId +
                ", FilialId=" + FilialId +
                '}';
    }
}
