package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Filial ORM class
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */
@Entity
@Table(name = "k00_filial")
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k00_filial_id", updatable = true, insertable = true, nullable = false)
    private int FilialId;

    @Basic
    @Column(name = "k00_filial", updatable = true, insertable = true, nullable = false, unique = true, length = 32)
    private String Filial;

    @OneToMany(mappedBy = "FilialId", cascade = CascadeType.ALL)
    private Collection<Device> Devices;

    @OneToMany(mappedBy = "Filial", cascade = CascadeType.ALL)
    private Collection<Organization> Organizations;

    @OneToMany(mappedBy = "Filial", cascade = CascadeType.ALL)
    private Collection<User> Users;

    //Constructors
    public Filial() {
    }

    public Filial(String Filial) {
        this.Filial = Filial;
    }

//Getters and setters

    public int getFilialId() {
        return FilialId;
    }

    public void setFilialId(int FilialId) {
        this.FilialId = FilialId;
    }

    public String getFilial() {
        return Filial;
    }

    public void setFilial(String Filial) {
        this.Filial = Filial;
    }

    public Collection<Device> getDevices() {
        return Devices;
    }

    public void setDevices(Collection<Device> Devices) {
        this.Devices = Devices;
    }

    public Collection<Organization> getOrganizations() {
        return Organizations;
    }

    public void setOrganizations(Collection<Organization> Organizations) {
        this.Organizations = Organizations;
    }

    public Collection<User> getUsers() {
        return Users;
    }

    public void setUsers(Collection<User> Users) {
        this.Users = Users;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filial Filial1 = (Filial) o;

        if (!Filial.equals(Filial1.Filial)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Filial.hashCode();
    }

    //toString()
    @Override
    public String toString() {
        return "Filial{" +
                "FilialId=" + FilialId +
                ", Filial='" + Filial + '\'' +
                '}';
    }

}
