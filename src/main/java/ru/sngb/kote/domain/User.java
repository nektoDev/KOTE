package ru.sngb.kote.domain;

import ru.sngb.kote.util.Security;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

/**
 * Users ORM Class
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */

@Entity
@Table(name = "k10_user")
public class User {
    @Id
    @Column(name = "k10_login", nullable = false, insertable = true, updatable = false, length = 16)
    private String Login;

    @Basic
    @Column(name = "k10_password", nullable = false, insertable = true, updatable = true, length = 32)
    private String Password;

    @Basic
    @Column(name = "k10_department", nullable = false, insertable = true, updatable = true)
    private String Department;

    @Basic
    @Column(name = "k10_post", nullable = false, insertable = true, updatable = true)
    private String Post;

    @Basic
    @Column(name = "k10_enabled", nullable = false, insertable = true, updatable = true)
    private boolean Enabled;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k02_user_person_id", referencedColumnName = "k02_person_id", nullable = false, insertable = true, updatable = true)
    private Person UserPerson;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k00_filial_id", referencedColumnName = "k00_filial_id", nullable = false, insertable = true, updatable = true)
    private Filial Filial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k11_rights_id", referencedColumnName = "k11_rights_id", nullable = false, insertable = true, updatable = true)
    private Rights Rights;

    @OneToMany(mappedBy = "User")
    private Collection<Comment> Comments;

    @OneToMany(mappedBy = "User")
    private Collection<IssueChangeStatus> IssueChangeStatus;

    //Constructors
    public User() {
        this.Enabled = true;
    }

    public User(String Login, String Password, String Department, String Post, Person UserPerson, Filial Filial, Rights Rights) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.Login = Login;
        this.Password = Security.takeMd5(Password);
        this.Department = Department;
        this.Post = Post;
        this.UserPerson = UserPerson;
        this.Filial = Filial;
        this.Rights = Rights;
        this.Enabled = true;
    }

//Getters and Setters

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.Password = Security.takeMd5(Password);
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String Post) {
        this.Post = Post;
    }

    public Person getUserPerson() {
        return UserPerson;
    }

    public void setUserPerson(Person UserPerson) {
        this.UserPerson = UserPerson;
    }

    public Filial getFilial() {
        return Filial;
    }

    public void setFilial(Filial Filial) {
        this.Filial = Filial;
    }

    public Rights getRights() {
        return Rights;
    }

    public void setRights(Rights Rights) {
        this.Rights = Rights;
    }

    public Collection<Comment> getComments() {
        return Comments;
    }

    public void setComments(Collection<Comment> Comments) {
        this.Comments = Comments;
    }

    public Collection<IssueChangeStatus> getIssueChangeStatus() {
        return IssueChangeStatus;
    }

    public void setIssueChangeStatus(Collection<IssueChangeStatus> IssueChangeStatus) {
        this.IssueChangeStatus = IssueChangeStatus;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean Enabled) {
        this.Enabled = Enabled;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User User = (User) o;

        if (Enabled != User.Enabled) return false;
        if (!Filial.equals(User.Filial)) return false;
        if (!UserPerson.equals(User.UserPerson)) return false;
        if (Comments != null ? !Comments.equals(User.Comments) : User.Comments != null) return false;
        if (!Department.equals(User.Department)) return false;
        if (!Login.equals(User.Login)) return false;
        if (!Password.equals(User.Password)) return false;
        if (!Post.equals(User.Post)) return false;
        if (!Rights.equals(User.Rights)) return false;
        if (IssueChangeStatus != null ? !IssueChangeStatus.equals(User.IssueChangeStatus) : User.IssueChangeStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = Login.hashCode();
        result = 31 * result + Password.hashCode();
        result = 31 * result + Department.hashCode();
        result = 31 * result + Post.hashCode();
        result = 31 * result + (Enabled ? 1 : 0);
        result = 31 * result + UserPerson.hashCode();
        result = 31 * result + Filial.hashCode();
        result = 31 * result + Rights.hashCode();
        result = 31 * result + (Comments != null ? Comments.hashCode() : 0);
        result = 31 * result + (IssueChangeStatus != null ? IssueChangeStatus.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "User{" +
                "Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Department='" + Department + '\'' +
                ", Post='" + Post + '\'' +
                ", Enabled=" + Enabled +
                ", UserPerson=" + UserPerson +
                ", Filial=" + Filial +
                ", Rights=" + Rights +
                '}';
    }
}
