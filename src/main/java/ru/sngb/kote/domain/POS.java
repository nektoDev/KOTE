package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Pos ORM Class. This class makes connection between device and organization.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */

@Entity
@Table(name = "k38_pos")
public class Pos {
    @Id
    @Column(name = "k38_terminal_id", nullable = false, insertable = true, updatable = true, length = 8)
    private String terminalId;

    @Basic
    @Column(name = "k38_address", nullable = false, insertable = true, updatable = true, length = 127)
    private String Address;

    //TODO multiterminalid only with verifone
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k30_device_id", referencedColumnName = "k30_device_id", nullable = false, insertable = true, updatable = true)
    private Device Device;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k20_organization_id", referencedColumnName = "k20_organization_id", nullable = false, insertable = true, updatable = true)
    private Organization Organization;

    @OneToMany(mappedBy = "pos", cascade = CascadeType.ALL)
    private Collection<Issue> Issue;

//Constructor
    public Pos() {
    }

    public Pos(String terminalId, String Address, Device Device, Organization Organization) {
        this.terminalId = terminalId;
        this.Address = Address;
        this.Device = Device;
        this.Organization = Organization;
    }

//Getters and Setters
    public String getterminalId() {
        return terminalId;
    }

    public void setterminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Collection<Issue> getIssue() {
        return Issue;
    }

    public void setIssue(Collection<Issue> Issue) {
        this.Issue = Issue;
    }

    public Device getDevice() {
        return Device;
    }

    public void setDevice(Device Device) {
        this.Device = Device;
    }

    public Organization getOrganization() {
        return Organization;
    }

    public void setOrganization(Organization Organization) {
        this.Organization = Organization;
    }

//equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pos pos = (Pos) o;

        if (Organization != null ? !Organization.equals(pos.Organization) : pos.Organization != null)
            return false;
        if (Device != null ? !Device.equals(pos.Device) : pos.Device != null) return false;
        if (Address != null ? !Address.equals(pos.Address) : pos.Address != null) return false;
        if (!terminalId.equals(pos.terminalId)) return false;
        if (Issue != null ? !Issue.equals(pos.Issue) : pos.Issue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = terminalId.hashCode();
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (Issue != null ? Issue.hashCode() : 0);
        result = 31 * result + (Device != null ? Device.hashCode() : 0);
        result = 31 * result + (Organization != null ? Organization.hashCode() : 0);
        return result;
    }

//toString()

    @Override
    public String toString() {
        return "Pos{" +
                "terminalId='" + terminalId + '\'' +
                ", Address='" + Address + '\'' +
                ", Organization=" + Organization +
                ", Device=" + Device +
                '}';
    }
}
