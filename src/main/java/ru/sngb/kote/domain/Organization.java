package ru.sngb.kote.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Organizations ORM class.
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */
//TODO проверить уники и нули
@Entity
@Table(name = "k20_organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k20_organization_id", insertable = true, updatable = false, nullable = false)
    private int OrganizationId;

    @Basic
    @Column(name = "k20_organization", insertable = true, updatable = true, nullable = false, length = 32)
    private String Organization;

    @Basic
    @Column(name = "k20_merchant_id", insertable = true, updatable = true, nullable = false, length = 16)
    private String MerchantId;

    @Basic
    @Column(name = "k20_forpost", insertable = true, updatable = true, nullable = false, length = 32)
    private String Forpost;

    @Basic
    @Column(name = "k20_work_days", insertable = true, updatable = true, nullable = false, length = 7)
    private String WorkDays;

    @Basic
    @Column(name = "k20_work_time", insertable = true, updatable = true, nullable = false, length = 32)
    private String WorkTime;

    @Basic
    @Column(name = "k20_tarif", insertable = true, updatable = true, nullable = false)
    private double Tarif;

    @Basic
    @Column(name = "k20_vip", insertable = true, updatable = true, nullable = false)
    private boolean vip;

    @Basic
    @Column(name = "k20_address", insertable = true, updatable = true, nullable = false, length = 100)
    private String Address;

    @Basic
    @Column(name = "k20_dogovor_num", nullable = false, insertable = true, updatable = true, length = 16)
    private String DogovorNum;

    @Basic
    @Column(name = "k20_dogovor_date", nullable = false, insertable = true, updatable = true)
    private Date DogovorDate;

    @Basic
    @Column(name = "k20_enabled", nullable = false, insertable = true, updatable = true)
    private boolean Enabled;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k00_filial_id", referencedColumnName = "k00_filial_id", insertable = true, updatable = true, nullable = false)
    private Filial Filial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k22_mcc", referencedColumnName = "k22_mcc", insertable = true, updatable = true, nullable = false)
    private Mcc mcc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k02_contact_person_id", referencedColumnName = "k02_person_id", insertable = true, updatable = true, nullable = false)
    private Person ContactPerson;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k21_jurface_id", referencedColumnName = "k21_jurface_id", nullable = false, insertable = true, updatable = true)
    private Jurface Jurface;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "k25_requisites_id", referencedColumnName = "k25_requisites_id", nullable = false, insertable = true, updatable = true)
    private Requisites Requisites;

    @OneToMany(mappedBy = "Organization")
    private Collection<Pos> Pos;

    //Constructors
    public Organization() {
        this.Enabled = true;
    }

    public Organization(String Organization, String MerchantId, String Forpost, String WorkDays, String WorkTime, double Tarif, boolean vip, String Address, String DogovorNum, Date DogovorDate, Filial Filial, Mcc mcc, Person ContactPerson, Jurface Jurface, Requisites Requisites) {
        this.Organization = Organization;
        this.MerchantId = MerchantId;
        this.Forpost = Forpost;
        this.WorkDays = WorkDays;
        this.WorkTime = WorkTime;
        this.Tarif = Tarif;
        this.vip = vip;
        this.Address = Address;
        this.DogovorNum = DogovorNum;
        this.DogovorDate = DogovorDate;
        this.Filial = Filial;
        this.mcc = mcc;
        this.ContactPerson = ContactPerson;
        this.Jurface = Jurface;
        this.Requisites = Requisites;
        this.Enabled = true;
    }

//Getters and Setters

    public int getOrganizationId() {
        return OrganizationId;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String Organization) {
        this.Organization = Organization;
    }

    public String getMerchantId() {
        return MerchantId;
    }

    public void setMerchantId(String MerchantId) {
        this.MerchantId = MerchantId;
    }

    public String getForpost() {
        return Forpost;
    }

    public void setForpost(String Forpost) {
        this.Forpost = Forpost;
    }

    public String getWorkDays() {
        return WorkDays;
    }

    public void setWorkDays(String WorkDays) {
        this.WorkDays = WorkDays;
    }

    public String getWorkTime() {
        return WorkTime;
    }

    public void setWorkTime(String WorkTime) {
        this.WorkTime = WorkTime;
    }

    public double getTarif() {
        return Tarif;
    }

    public void setTarif(double Tarif) {
        this.Tarif = Tarif;
    }

    public boolean isvip() {
        return vip;
    }

    public void setvip(boolean vip) {
        this.vip = vip;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDogovorNum() {
        return DogovorNum;
    }

    public void setDogovorNum(String DogovorNum) {
        this.DogovorNum = DogovorNum;
    }

    public Date getDogovorDate() {
        return DogovorDate;
    }

    public void setDogovorDate(Date DogovorDate) {
        this.DogovorDate = DogovorDate;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setEnabled(boolean Enabled) {
        this.Enabled = Enabled;
    }

    public Filial getFilial() {
        return Filial;
    }

    public void setFilial(Filial Filial) {
        this.Filial = Filial;
    }

    public Mcc getmcc() {
        return mcc;
    }

    public void setmcc(Mcc mcc) {
        this.mcc = mcc;
    }

    public Person getContactPerson() {
        return ContactPerson;
    }

    public void setContactPerson(Person ContactPerson) {
        this.ContactPerson = ContactPerson;
    }

    public Jurface getJurface() {
        return Jurface;
    }

    public void setJurface(Jurface Jurface) {
        this.Jurface = Jurface;
    }

    public Requisites getRequisites() {
        return Requisites;
    }

    public void setRequisites(Requisites Requisites) {
        this.Requisites = Requisites;
    }

    public Collection<Pos> getpos() {
        return Pos;
    }

    public void setpos(Collection<Pos> Pos) {
        this.Pos = Pos;
    }

//equals() and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (Enabled != that.Enabled) return false;
        if (OrganizationId != that.OrganizationId) return false;
        if (Double.compare(that.Tarif, Tarif) != 0) return false;
        if (vip != that.vip) return false;
        if (!Filial.equals(that.Filial)) return false;
        if (ContactPerson != null ? !ContactPerson.equals(that.ContactPerson) : that.ContactPerson != null)
            return false;
        if (Address != null ? !Address.equals(that.Address) : that.Address != null) return false;
        if (DogovorDate != null ? !DogovorDate.equals(that.DogovorDate) : that.DogovorDate != null)
            return false;
        if (DogovorNum != null ? !DogovorNum.equals(that.DogovorNum) : that.DogovorNum != null)
            return false;
        if (Forpost != null ? !Forpost.equals(that.Forpost) : that.Forpost != null) return false;
        if (MerchantId != null ? !MerchantId.equals(that.MerchantId) : that.MerchantId != null)
            return false;
        if (!Organization.equals(that.Organization)) return false;
        if (WorkDays != null ? !WorkDays.equals(that.WorkDays) : that.WorkDays != null) return false;
        if (WorkTime != null ? !WorkTime.equals(that.WorkTime) : that.WorkTime != null) return false;
        if (!Jurface.equals(that.Jurface)) return false;
        if (mcc != null ? !mcc.equals(that.mcc) : that.mcc != null) return false;
        if (!Requisites.equals(that.Requisites)) return false;
        if (Pos != null ? !Pos.equals(that.Pos) : that.Pos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = OrganizationId;
        result = 31 * result + Organization.hashCode();
        result = 31 * result + (MerchantId != null ? MerchantId.hashCode() : 0);
        result = 31 * result + (Forpost != null ? Forpost.hashCode() : 0);
        result = 31 * result + (WorkDays != null ? WorkDays.hashCode() : 0);
        result = 31 * result + (WorkTime != null ? WorkTime.hashCode() : 0);
        temp = Tarif != +0.0d ? Double.doubleToLongBits(Tarif) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (vip ? 1 : 0);
        result = 31 * result + (Address != null ? Address.hashCode() : 0);
        result = 31 * result + (DogovorNum != null ? DogovorNum.hashCode() : 0);
        result = 31 * result + (DogovorDate != null ? DogovorDate.hashCode() : 0);
        result = 31 * result + (Enabled ? 1 : 0);
        result = 31 * result + Filial.hashCode();
        result = 31 * result + (mcc != null ? mcc.hashCode() : 0);
        result = 31 * result + (ContactPerson != null ? ContactPerson.hashCode() : 0);
        result = 31 * result + Jurface.hashCode();
        result = 31 * result + Requisites.hashCode();
        result = 31 * result + (Pos != null ? Pos.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Organization{" +
                "OrganizationId=" + OrganizationId +
                ", Organization='" + Organization + '\'' +
                ", MerchantId='" + MerchantId + '\'' +
                ", Forpost='" + Forpost + '\'' +
                ", WorkDays='" + WorkDays + '\'' +
                ", WorkTime='" + WorkTime + '\'' +
                ", Tarif=" + Tarif +
                ", vip=" + vip +
                ", Address='" + Address + '\'' +
                ", DogovorNum='" + DogovorNum + '\'' +
                ", DogovorDate=" + DogovorDate +
                ", Enabled=" + Enabled +
                ", Filial=" + Filial +
                ", Mcc=" + mcc +
                ", ContactPerson=" + ContactPerson +
                ", Jurface=" + Jurface +
                ", Requisites=" + Requisites +
                '}';
    }
}
