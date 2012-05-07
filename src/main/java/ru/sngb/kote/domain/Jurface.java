package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * JurFace ORM class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */

@Entity
@Table(name = "k21_jurface")
public class Jurface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k21_jurface_id", nullable = false, insertable = true, updatable = true)
    private int JurfaceId;

    @Basic
    @Column(name = "k21_jurface", nullable = false, insertable = true, updatable = true, length = 64)
    private String Jurface;

    @Basic
    @Column(name = "k21_INN", nullable = false, insertable = true, updatable = true, length = 10)
    private String inn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k02_director_person_id", referencedColumnName = "k02_person_id", nullable = false, insertable = true, updatable = true)
    private Person DirectorPerson;

    @OneToMany(mappedBy = "Jurface", cascade = CascadeType.ALL)
    private Collection<Organization> Organizations;

    //Constructors
    public Jurface() {
    }

    public Jurface(String Jurface, String inn, Person DirectorPerson) {
        this.Jurface = Jurface;
        this.inn = inn;
        this.DirectorPerson = DirectorPerson;
    }

//Getters and Setters

    public int getJurfaceId() {
        return JurfaceId;
    }

    public String getJurface() {
        return Jurface;
    }

    public void setJurface(String Jurface) {
        this.Jurface = Jurface;
    }

    public String getinn() {
        return inn;
    }

    public void setinn(String inn) {
        this.inn = inn;
    }

    public Person getDirectorPerson() {
        return DirectorPerson;
    }

    public void setDirectorPerson(Person DirectorPerson) {
        this.DirectorPerson = DirectorPerson;
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

        Jurface that = (Jurface) o;

        if (JurfaceId != that.JurfaceId) return false;
        if (!DirectorPerson.equals(that.DirectorPerson)) return false;
        if (Organizations != null ? !Organizations.equals(that.Organizations) : that.Organizations != null)
            return false;
        if (!Jurface.equals(that.Jurface)) return false;
        if (!inn.equals(that.inn)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = JurfaceId;
        result = 31 * result + Jurface.hashCode();
        result = 31 * result + inn.hashCode();
        result = 31 * result + DirectorPerson.hashCode();
        result = 31 * result + (Organizations != null ? Organizations.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Jurface{" +
                "JurfaceId=" + JurfaceId +
                ", Jurface='" + Jurface + '\'' +
                ", inn='" + inn + '\'' +
                ", DirectorPerson=" + DirectorPerson +
                '}';
    }
}
