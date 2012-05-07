package ru.sngb.kote.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Comments ORM Class
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */

@Entity
@Table(name = "k03_comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k03_comment_id", nullable = false, insertable = true, updatable = true)
    private int CommentId;

    @Basic
    @Column(name = "k03_table", nullable = false, insertable = true, updatable = true, length = 16)
    private String Table;

    @Basic
    @Column(name = "k03_pk_id", nullable = false, insertable = true, updatable = true)
    private int PkId;

    @Basic
    @Column(name = "k03_date", nullable = false, insertable = true, updatable = true)
    private Date Date;

    @Basic
    @Column(name = "k03_text", nullable = false, insertable = true, updatable = true, length = 255)
    private String Text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k10_login", referencedColumnName = "k10_login", nullable = false, insertable = true, updatable = true)
    private User User;

    //Constructors()
    public Comment() {
        this.Date = new Date(new java.util.Date().getTime());
    }

    public Comment(String Table, int PkId, String Text, User User) {
        this.Table = Table;
        this.PkId = PkId;
        this.Date = new Date(new java.util.Date().getTime());
        this.Text = Text;
        this.User = User;
    }

//Getters and Setters

    public int getCommentId() {
        return CommentId;
    }

    public String getTable() {
        return Table;
    }

    public void setTable(String Table) {
        this.Table = Table;
    }

    public int getPkId() {
        return PkId;
    }

    public void setPkId(int PkId) {
        this.PkId = PkId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

//equals() and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment that = (Comment) o;

        if (CommentId != that.CommentId) return false;
        if (PkId != that.PkId) return false;
        if (!Date.equals(that.Date)) return false;
        if (Table != null ? !Table.equals(that.Table) : that.Table != null) return false;
        if (Text != null ? !Text.equals(that.Text) : that.Text != null) return false;
        if (User != null ? !User.equals(that.User) : that.User != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = CommentId;
        result = 31 * result + (Table != null ? Table.hashCode() : 0);
        result = 31 * result + PkId;
        result = 31 * result + Date.hashCode();
        result = 31 * result + (Text != null ? Text.hashCode() : 0);
        result = 31 * result + (User != null ? User.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Comment{" +
                "CommentId=" + CommentId +
                ", Table='" + Table + '\'' +
                ", PkId=" + PkId +
                ", Date=" + Date +
                ", Text='" + Text + '\'' +
                ", User=" + User +
                '}';
    }
}
