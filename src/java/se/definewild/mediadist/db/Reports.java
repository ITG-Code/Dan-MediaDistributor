/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import se.definewild.mediadist.bean.ToStringPretty;

/**
 *
 * @author wild
 */
@Entity
@Table(name = "reports")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Reports.findAll", query = "SELECT r FROM Reports r"),
  @NamedQuery(name = "Reports.findById", query = "SELECT r FROM Reports r WHERE r.id = :id")})
public class Reports extends ToStringPretty<Reports> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "subscriptions")
  private String subscriptions;
  @JoinColumn(name = "employee", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Employees employee;
  @JoinColumn(name = "subdistrict", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Subdistricts subdistrict;

  public Reports() {
    super.Set(this);
  }

  public Reports(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Reports(Integer id, String subscriptions) {
    super.Set(this);
    this.id = id;
    this.subscriptions = subscriptions;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSubscriptions() {
    return subscriptions;
  }

  public void setSubscriptions(String subscriptions) {
    this.subscriptions = subscriptions;
  }

  public Employees getEmployee() {
    return employee;
  }

  public void setEmployee(Employees employee) {
    this.employee = employee;
  }

  public Subdistricts getSubdistrict() {
    return subdistrict;
  }

  public void setSubdistrict(Subdistricts subdistrict) {
    this.subdistrict = subdistrict;
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
    if (!(object instanceof Reports))
      return false;
    Reports other = (Reports) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Reports[ id=" + id + " ]";
  }
  
}
