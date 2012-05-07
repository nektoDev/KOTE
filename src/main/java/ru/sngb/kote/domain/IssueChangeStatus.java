package ru.sngb.kote.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * ORM class that contains all issues changes.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */
@Entity
@Table(name = "k42_issue_change_status")
public class IssueChangeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k42_issue_change_status_id", updatable = true, insertable = true, nullable = false)
    private int IssueChangeStatusId;

    @Basic
    @Column(name = "k42_issue_change_status_date", updatable = true, insertable = true, nullable = false)
    private Date IssueChangeStatusDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k10_login", referencedColumnName = "k10_login", insertable = true, nullable = false)
    private User User;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k43_issue_status_id", referencedColumnName = "k43_issue_status_id", updatable = true, insertable = true, nullable = false)
    private IssueStatus IssueStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k40_issue_id", referencedColumnName = "k40_issue_id", updatable = true, insertable = true, nullable = false)
    private Issue Issue;

    //Constructors
    public IssueChangeStatus() {
        this.IssueChangeStatusDate = new Date(new java.util.Date().getTime());
    }

    public IssueChangeStatus(User User, IssueStatus IssueStatus, Issue Issue) {
        this.User = User;
        this.IssueStatus = IssueStatus;
        this.Issue = Issue;
        this.IssueChangeStatusDate = new Date(new java.util.Date().getTime());
    }

    //Getters and Setters
    public int getIssueChangeStatusId() {
        return IssueChangeStatusId;
    }

    public Date getIssueChangeStatusDate() {
        return IssueChangeStatusDate;
    }

    public void setIssueChangeStatusDate(Date IssueChangeStatusDate) {
        this.IssueChangeStatusDate = IssueChangeStatusDate;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public IssueStatus getIssueStatus() {
        return IssueStatus;
    }

    public void setIssueStatus(IssueStatus IssueStatus) {
        this.IssueStatus = IssueStatus;
    }

    public Issue getIssue() {
        return Issue;
    }

    public void setIssue(Issue Issue) {
        this.Issue = Issue;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssueChangeStatus that = (IssueChangeStatus) o;

        if (IssueChangeStatusId != that.IssueChangeStatusId) return false;
        if (!User.equals(that.User)) return false;
        if (!Issue.equals(that.Issue)) return false;
        if (!IssueChangeStatusDate.equals(that.IssueChangeStatusDate)) return false;
        if (!IssueStatus.equals(that.IssueStatus)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = IssueChangeStatusId;
        result = 31 * result + IssueChangeStatusDate.hashCode();
        result = 31 * result + User.hashCode();
        result = 31 * result + IssueStatus.hashCode();
        result = 31 * result + Issue.hashCode();
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "IssueChangeStatus{" +
                "IssueChangeStatusId=" + IssueChangeStatusId +
                ", Issue=" + Issue +
                ", IssueStatus=" + IssueStatus +
                ", User=" + User +
                ", IssueChangeStatusDate=" + IssueChangeStatusDate +
                '}';
    }
}
