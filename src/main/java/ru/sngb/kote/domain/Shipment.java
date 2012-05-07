package ru.sngb.kote.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Shipment ORM class
 *
 * @author Tsykin V.A. ts.slawa@gmail.com
 * @version 0.1
 */

@Entity
@Table(name = "k33_shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "k33_shipment_id", nullable = false, insertable = true, updatable = true)
    private int ShipmentId;

    @Basic
    @Column(name = "k33_date", nullable = false, insertable = true, updatable = true)
    private Date Date;

    @Basic
    @Column(name = "k33_comment", nullable = true, insertable = true, updatable = true)
    private String Comment;

    @Basic
    @Column(name = "k33_ship", nullable = false, insertable = true, updatable = true)
    private String Ship;

    @OneToMany(mappedBy = "ShipmentId")
    private Collection<Device> Devices;

    //Constructors
    public Shipment() {
    }

    public Shipment(Date Date, String Comment, String Ship) {
        this.Date = Date;
        this.Comment = Comment;
        this.Ship = Ship;
    }

    //Getters and Setters
    public int getShipmentId() {
        return ShipmentId;
    }

    public void setShipmentId(int ShipmentId) {
        this.ShipmentId = ShipmentId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getShip() {
        return Ship;
    }

    public void setShip(String Ship) {
        this.Ship = Ship;
    }

    public Collection<Device> getDevices() {
        return Devices;
    }

    public void setDevices(Collection<Device> Devices) {
        this.Devices = Devices;
    }

    //equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shipment that = (Shipment) o;

        if (ShipmentId != that.ShipmentId) return false;
        if (Devices != null ? !Devices.equals(that.Devices) : that.Devices != null) return false;
        if (Comment != null ? !Comment.equals(that.Comment) : that.Comment != null) return false;
        if (!Date.equals(that.Date)) return false;
        if (!Ship.equals(that.Ship)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ShipmentId;
        result = 31 * result + Date.hashCode();
        result = 31 * result + (Comment != null ? Comment.hashCode() : 0);
        result = 31 * result + Ship.hashCode();
        result = 31 * result + (Devices != null ? Devices.hashCode() : 0);
        return result;
    }

    //toString()
    @Override
    public String toString() {
        return "Shipment{" +
                "ShipmentId=" + ShipmentId +
                ", Ship='" + Ship + '\'' +
                ", Date=" + Date +
                ", Comment='" + Comment + '\'' +
                '}';
    }
}
