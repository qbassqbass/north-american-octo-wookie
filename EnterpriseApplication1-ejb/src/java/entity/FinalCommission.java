/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jakub
 */
@Entity
@Table(name = "finalCommission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalCommission.findAll", query = "SELECT f FROM FinalCommission f"),
    @NamedQuery(name = "FinalCommission.findById", query = "SELECT f FROM FinalCommission f WHERE f.id = :id")})
public class FinalCommission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "shipId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ship shipId;
    @JoinColumn(name = "transportId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transport transportId;
    @JoinColumn(name = "adminId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User adminId;
    @JoinColumn(name = "dockId", referencedColumnName = "id")
    @ManyToOne
    private Dock dockId;

    public FinalCommission() {
    }

    public FinalCommission(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ship getShipId() {
        return shipId;
    }

    public void setShipId(Ship shipId) {
        this.shipId = shipId;
    }

    public Transport getTransportId() {
        return transportId;
    }

    public void setTransportId(Transport transportId) {
        this.transportId = transportId;
    }

    public User getAdminId() {
        return adminId;
    }

    public void setAdminId(User adminId) {
        this.adminId = adminId;
    }

    public Dock getDockId() {
        return dockId;
    }

    public void setDockId(Dock dockId) {
        this.dockId = dockId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FinalCommission)) {
            return false;
        }
        FinalCommission other = (FinalCommission) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FinalCommission[ id=" + id + " ]";
    }
    
}
