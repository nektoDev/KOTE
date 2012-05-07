package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Issues statuses ORM class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */
@Entity
@Table(name = "k43_issue_status")
public class IssueStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k43_issue_status_id", updatable = true, insertable = true, nullable = false)
    private int IssueStatusId;

    @Basic
    @Column(name = "k43_issue_status", updatable = true, insertable = true, nullable = false, length = 32)
    private String IssueStatus;

    @OneToMany(mappedBy = "IssueStatus")
    private Collection<IssueChangeStatus> IssueChangeStatus;

    //Constructors
    public IssueStatus() {
    }

    public IssueStatus(String IssueStatus) {
        this.IssueStatus = IssueStatus;
    }

    //Getters and Setters
    public int getIssueStatusId() {
        return IssueStatusId;
    }

    public String getIssueStatus() {
        return IssueStatus;
    }

    public void setIssueStatus(String IssueStatus) {
        this.IssueStatus = IssueStatus;
    }

    public Collection<IssueChangeStatus> getIssueChangeStatus() {
        return IssueChangeStatus;
    }

    public void setIssueChangeStatus(Collection<IssueChangeStatus> IssueChangeStatus) {
        this.IssueChangeStatus = IssueChangeStatus;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssueStatus that = (IssueStatus) o;

        if (IssueStatusId != that.IssueStatusId) return false;
        if (IssueChangeStatus != null ? !IssueChangeStatus.equals(that.IssueChangeStatus) : that.IssueChangeStatus != null)
            return false;
        if (!IssueStatus.equals(that.IssueStatus)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = IssueStatusId;
        result = 31 * result + IssueStatus.hashCode();
        result = 31 * result + (IssueChangeStatus != null ? IssueChangeStatus.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "IssueStatus{" +
                "IssueStatusId=" + IssueStatusId +
                ", IssueStatus='" + IssueStatus + '\'' +
                '}';
    }
}
