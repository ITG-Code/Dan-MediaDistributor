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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import se.definewild.mediadist.bean.ToStringPretty;

/**
 *
 * @author wild
 */
@Entity
@Table(name = "districtagents")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Districtagents.findAll", query = "SELECT d FROM Districtagents d"),
  @NamedQuery(name = "Districtagents.findById", query = "SELECT d FROM Districtagents d WHERE d.id = :id")})
public class Districtagents extends ToStringPretty<Districtagents> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
  @OneToOne(optional = false)
  private Employees employees;

  public Districtagents() {
    super.Set(this);
  }

  public Districtagents(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employees getEmployees() {
    return employees;
  }

  public void setEmployees(Employees employees) {
    this.employees = employees;
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
    if (!(object instanceof Districtagents))
      return false;
    Districtagents other = (Districtagents) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Districtagents[ id=" + id + " ]";
  }
  
}
