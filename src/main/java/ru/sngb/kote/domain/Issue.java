package ru.sngb.kote.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Issues ORM class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com.
 * @version 0.1
 */

@Entity
@Table(name = "k40_issue")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k40_issue_id", updatable = true, insertable = true, nullable = false)
    private int IssueId;

    @Basic
    @Column(name = "k40_issue_name", updatable = true, insertable = true, nullable = false, length = 32)
    private String IssueName;

    @Basic
    @Column(name = "k40_issue_summary", updatable = true, insertable = true, nullable = false, length = 255)
    private String IssueSummary;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k38_terminal_id", referencedColumnName = "k38_terminal_id", updatable = true, insertable = true, nullable = true)
    private Pos pos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k41_issue_type_id", referencedColumnName = "k41_issue_type_id", updatable = true, insertable = true, nullable = true)
    private IssueType IssueType;
    @OneToMany(mappedBy = "Issue")
    private Collection<IssueChangeStatus> IssueChangeStatus;

    //Constructors
    public Issue() {
    }

    //TODO Add default change status
    public Issue(String IssueName, String IssueSummary, Pos pos, IssueType IssueType) {
        this.IssueName = IssueName;
        this.IssueSummary = IssueSummary;
        this.pos = pos;
        this.IssueType = IssueType;
    }

    //Getters and Setters
    public int getIssueId() {
        return IssueId;
    }

    public String getIssueName() {
        return IssueName;
    }

    public void setIssueName(String IssueName) {
        this.IssueName = IssueName;
    }

    public String getIssueSummary() {
        return IssueSummary;
    }

    public void setIssueSummary(String IssueSummary) {
        this.IssueSummary = IssueSummary;
    }

    public Pos getpos() {
        return pos;
    }

    public void setpos(Pos pos) {
        this.pos = pos;
    }

    public IssueType getIssueType() {
        return IssueType;
    }

    public void setIssueType(IssueType IssueType) {
        this.IssueType = IssueType;
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

        Issue Issue = (Issue) o;

        if (IssueId != Issue.IssueId) return false;
        if (pos != null ? !pos.equals(Issue.pos) : Issue.pos != null) return false;
        if (!IssueName.equals(Issue.IssueName)) return false;
        if (!IssueSummary.equals(Issue.IssueSummary)) return false;
        if (!IssueType.equals(Issue.IssueType)) return false;
        if (IssueChangeStatus != null ? !IssueChangeStatus.equals(Issue.IssueChangeStatus) : Issue.IssueChangeStatus != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = IssueId;
        result = 31 * result + IssueName.hashCode();
        result = 31 * result + IssueSummary.hashCode();
        result = 31 * result + (pos != null ? pos.hashCode() : 0);
        result = 31 * result + IssueType.hashCode();
        result = 31 * result + (IssueChangeStatus != null ? IssueChangeStatus.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Issue{" +
                "IssueId=" + IssueId +
                ", IssueName='" + IssueName + '\'' +
                ", IssueSummary='" + IssueSummary + '\'' +
                ", IssueType=" + IssueType +
                ", Pos=" + pos +
                '}';
    }
}
