package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Issue type ORM class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */
@Entity
@Table(name = "k41_issue_type")
public class IssueType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k41_issue_type_id", updatable = true, insertable = true, nullable = false)
    private int IssueTypeId;

    @Basic
    @Column(name = "k41_issue_type", updatable = true, insertable = true, nullable = false, length = 32)
    private String IssueType;

    @OneToMany(mappedBy = "IssueType")
    private Collection<Issue> Issue;

    //Constructor
    public IssueType() {
    }

    public IssueType(int IssueTypeId, String IssueType) {
        this.IssueTypeId = IssueTypeId;
        this.IssueType = IssueType;
    }

    //Getters and Setters
    public void setIssueTypeId(int IssueTypeId) {
        this.IssueTypeId = IssueTypeId;
    }

    public String getIssueType() {
        return IssueType;
    }

    public void setIssueType(String IssueType) {
        this.IssueType = IssueType;
    }

    public Collection<Issue> getIssue() {
        return Issue;
    }

    public void setIssue(Collection<Issue> Issue) {
        this.Issue = Issue;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssueType that = (IssueType) o;

        if (IssueTypeId != that.IssueTypeId) return false;
        if (Issue != null ? !Issue.equals(that.Issue) : that.Issue != null) return false;
        if (!IssueType.equals(that.IssueType)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = IssueTypeId;
        result = 31 * result + IssueType.hashCode();
        result = 31 * result + (Issue != null ? Issue.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "IssueType{" +
                "IssueTypeId=" + IssueTypeId +
                ", IssueType='" + IssueType + '\'' +
                '}';
    }
}
