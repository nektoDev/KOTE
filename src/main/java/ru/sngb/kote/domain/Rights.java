package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Users rights ORM class. (read, write, create)
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */
//TODO add new type (boolean[3])
@Entity
@Table(name = "k11_rights")
public class Rights {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k11_rights_id", updatable = true, insertable = true, nullable = false)
    private int RightsId;

    @Basic
    @Column(name = "k11_user", updatable = true, insertable = true, nullable = false, length = 3)
    private String User;

    @Basic
    @Column(name = "k11_device", updatable = true, insertable = true, nullable = false, length = 3)
    private String Device;

    @Basic
    @Column(name = "k11_organization", updatable = true, insertable = true, nullable = false, length = 3)
    private String Organization;

    @Basic
    @Column(name = "k11_issue", updatable = true, insertable = true, nullable = false, length = 3)
    private String Issue;

    @OneToMany(mappedBy = "Rights", cascade = CascadeType.ALL)
    private Collection<User> Users;

    // Constructors
    public Rights() {
    }

    public Rights(String User, String Device, String Organization, String Issue) {
        this.User = User;
        this.Device = Device;
        this.Organization = Organization;
        this.Issue = Issue;
    }

    //Getters and Setters
    public int getRightsId() {
        return RightsId;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getDevice() {
        return Device;
    }

    public void setDevice(String Device) {
        this.Device = Device;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

    public String getIssue() {
        return Issue;
    }

    public void setIssue(String Issue) {
        this.Issue = Issue;
    }

    public Collection<User> getUsers() {
        return Users;
    }

    public void setUsers(Collection<User> Users) {
        this.Users = Users;
    }

    //equals and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rights Rights = (Rights) o;

        if (RightsId != Rights.RightsId) return false;
        if (Users != null ? !Users.equals(Rights.Users) : Rights.Users != null) return false;
        if (!Device.equals(Rights.Device)) return false;
        if (!Issue.equals(Rights.Issue)) return false;
        if (!Organization.equals(Rights.Organization)) return false;
        if (!User.equals(Rights.User)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = RightsId;
        result = 31 * result + User.hashCode();
        result = 31 * result + Device.hashCode();
        result = 31 * result + Organization.hashCode();
        result = 31 * result + Issue.hashCode();
        result = 31 * result + (Users != null ? Users.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Rights{" +
                "RightsId=" + RightsId +
                ", User='" + User + '\'' +
                ", Device='" + Device + '\'' +
                ", Organization='" + Organization + '\'' +
                ", Issue='" + Issue + '\'' +
                '}';
    }
}
