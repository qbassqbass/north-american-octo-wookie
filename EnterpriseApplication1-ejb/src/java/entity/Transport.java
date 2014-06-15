/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jakub
 */
@Entity
@Table(name = "transport")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transport.findAll", query = "SELECT t FROM Transport t"),
    @NamedQuery(name = "Transport.findById", query = "SELECT t FROM Transport t WHERE t.id = :id"),
    @NamedQuery(name = "Transport.findByStartDate", query = "SELECT t FROM Transport t WHERE t.startDate = :startDate"),
    @NamedQuery(name = "Transport.findByEndDate", query = "SELECT t FROM Transport t WHERE t.endDate = :endDate")})
public class Transport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportId")
    private Collection<FinalCommission> finalCommissionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportId")
    private Collection<UserCommission> userCommissionCollection;
    @JoinColumn(name = "toStation", referencedColumnName = "id")
    @ManyToOne
    private Station toStation;
    @JoinColumn(name = "fromStation", referencedColumnName = "id")
    @ManyToOne
    private Station fromStation;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public Transport() {
    }

    public Transport(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlTransient
    public Collection<FinalCommission> getFinalCommissionCollection() {
        return finalCommissionCollection;
    }

    public void setFinalCommissionCollection(Collection<FinalCommission> finalCommissionCollection) {
        this.finalCommissionCollection = finalCommissionCollection;
    }

    @XmlTransient
    public Collection<UserCommission> getUserCommissionCollection() {
        return userCommissionCollection;
    }

    public void setUserCommissionCollection(Collection<UserCommission> userCommissionCollection) {
        this.userCommissionCollection = userCommissionCollection;
    }

    public Station getToStation() {
        return toStation;
    }

    public void setToStation(Station toStation) {
        this.toStation = toStation;
    }

    public Station getFromStation() {
        return fromStation;
    }

    public void setFromStation(Station fromStation) {
        this.fromStation = fromStation;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof Transport)) {
            return false;
        }
        Transport other = (Transport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Transport[ from: " + fromStation + " to: " + toStation + " at " + startDate + " ]";
    }
    
}
