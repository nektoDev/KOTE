package ru.sngb.kote.domain;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Devices models description class
 * User: m247
 * Date: 06.03.12
 * Time: 15:57
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "k31_model")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k31_model_id", insertable = true, updatable = true, nullable = false)
    private int ModelId;

    @Basic
    @Column(name = "k31_model", insertable = true, updatable = true, nullable = false)
    private String Model;

    @Basic
    @Column(name = "k31_enabled", insertable = true, updatable = true, nullable = false)
    private boolean Enabled = true;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k34_vendor_id", referencedColumnName = "k34_vendor_id", nullable = false)
    private Vendor VendorId;

    @ManyToOne(cascade = CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "k35_device_type_id", referencedColumnName = "k35_device_type_id", nullable = false)
    private DeviceType DeviceTypeId;

    @OneToMany(mappedBy = "ModelId")
    private Collection<Device> DevicesByModelId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "k36_model_relation",
            joinColumns = {@JoinColumn(name = "k36_parent_id")},
            inverseJoinColumns = {@JoinColumn(name = "k36_daughter_id")})
    private Set<Model> ModelDaughters = new HashSet<Model>();

    @ManyToMany(mappedBy = "ModelDaughters", cascade = CascadeType.ALL)
    private Set<Model> ModelParents = new HashSet<Model>();

//Constructor

    public Model() {
    }

    public Model(String Model, boolean Enabled, Vendor VendorId, DeviceType DeviceTypeId) {
        this.Model = Model;
        this.Enabled = Enabled;
        this.VendorId = VendorId;
        this.DeviceTypeId = DeviceTypeId;
    }

    //getters and setters

    public int getModelId() {
        return ModelId;
    }

    public void setModelId(int ModelId) {
        this.ModelId = ModelId;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean Enabled) {
        this.Enabled = Enabled;
    }

    public Vendor getVendorId() {
        return VendorId;
    }

    public void setVendorId(Vendor VendorId) {
        this.VendorId = VendorId;
    }

    public DeviceType getDeviceTypeId() {
        return DeviceTypeId;
    }

    public void setDeviceTypeId(DeviceType DeviceTypeId) {
        this.DeviceTypeId = DeviceTypeId;
    }

    public Collection<Device> getDevicesByModelId() {
        return DevicesByModelId;
    }

    public void setDevicesByModelId(Collection<Device> DevicesByModelId) {
        this.DevicesByModelId = DevicesByModelId;
    }

    public Collection<Model> getModelDaughters() {
        return ModelDaughters;
    }

    public void setModelDaughters(Set<Model> ModelDaughters) {
        this.ModelDaughters = ModelDaughters;
    }

    public Collection<Model> getModelParents() {
        return ModelParents;
    }

    public void setModelParents(Set<Model> ModelParents) {
        this.ModelParents = ModelParents;
    }

//equals() and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model Model1 = (Model) o;

        if (Enabled != Model1.Enabled) return false;
        if (ModelId != Model1.ModelId) return false;
        if (Model != null ? !Model.equals(Model1.Model) : Model1.Model != null) return false;
        if (VendorId != null ? !VendorId.equals(Model1.VendorId) : Model1.VendorId != null)
            return false;
        if (DeviceTypeId != null ? !DeviceTypeId.equals(Model1.DeviceTypeId) : Model1.DeviceTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ModelId;
        result = 31 * result + (Model != null ? Model.hashCode() : 0);
        result = 31 * result + (Enabled ? 1 : 0);
        result = 31 * result + (VendorId != null ? VendorId.hashCode() : 0);
        result = 31 * result + (DeviceTypeId != null ? DeviceTypeId.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Model{" +
                "ModelId=" + ModelId +
                ", Model='" + Model + '\'' +
                ", Enabled=" + Enabled +
                ", VendorId=" + VendorId +
                ", DeviceTypeId=" + DeviceTypeId +
                ", ModelParents=" + ModelParents +
                '}';
    }
}
