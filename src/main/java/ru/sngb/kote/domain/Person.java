package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Person full name ORM class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */
@Entity
@Table(name = "k02_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k02_person_id", nullable = false, insertable = true, updatable = true)
    private int PersonId;

    @Basic
    @Column(name = "k02_first_name", nullable = false, insertable = true, updatable = true, length = 32)
    private String FirstName;

    @Basic
    @Column(name = "k02_middle_name", nullable = false, insertable = true, updatable = true, length = 32)
    private String MiddleName;

    @Basic
    @Column(name = "k02_last_name", nullable = false, insertable = true, updatable = true, length = 32)
    private String LastName;

    @Basic
    @Column(name = "k02_phone", nullable = true, insertable = true, updatable = true, length = 32)
    private String Phone;

    @OneToMany(mappedBy = "ContactPerson", cascade = CascadeType.ALL)
    private Collection<Organization> Organizations;

    @OneToMany(mappedBy = "DirectorPerson", cascade = CascadeType.ALL)
    private Collection<Jurface> Jurfaces;

    @OneToMany(mappedBy = "UserPerson", cascade = CascadeType.ALL)
    private Collection<User> Users;

    //Constructors
    public Person() {
    }

    public Person(String FirstName, String MiddleName, String LastName) {
        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
    }

    //Getters and Setters
    public int getPersonId() {
        return PersonId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Collection<Organization> getOrganizations() {
        return Organizations;
    }

    public void setOrganizations(Collection<Organization> Organizations) {
        this.Organizations = Organizations;
    }

    public Collection<Jurface> getJurfaces() {
        return Jurfaces;
    }

    public void setJurfaces(Collection<Jurface> Jurfaces) {
        this.Jurfaces = Jurfaces;
    }

    public Collection<User> getUsers() {
        return Users;
    }

    public void setUsers(Collection<User> Users) {
        this.Users = Users;
    }

//equals() and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person Person = (Person) o;

        if (PersonId != Person.PersonId) return false;
        if (!FirstName.equals(Person.FirstName)) return false;
        if (!LastName.equals(Person.LastName)) return false;
        if (!MiddleName.equals(Person.MiddleName)) return false;
        if (Phone != null ? !Phone.equals(Person.Phone) : Person.Phone != null) return false;
        if (Users != null ? !Users.equals(Person.Users) : Person.Users != null) return false;
        if (Organizations != null ? !Organizations.equals(Person.Organizations) : Person.Organizations != null)
            return false;
        if (Jurfaces != null ? !Jurfaces.equals(Person.Jurfaces) : Person.Jurfaces != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = PersonId;
        result = 31 * result + FirstName.hashCode();
        result = 31 * result + MiddleName.hashCode();
        result = 31 * result + LastName.hashCode();
        result = 31 * result + (Phone != null ? Phone.hashCode() : 0);
        result = 31 * result + (Organizations != null ? Organizations.hashCode() : 0);
        result = 31 * result + (Jurfaces != null ? Jurfaces.hashCode() : 0);
        result = 31 * result + (Users != null ? Users.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Person{" +
                "PersonId=" + PersonId +
                ", FirstName='" + FirstName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
