/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import se.definewild.mediadist.bean.ToStringPretty;

/**
 *
 * @author wild
 */
@Entity
@Table(name = "absences")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Absences.findAll", query = "SELECT a FROM Absences a"),
  @NamedQuery(name = "Absences.findById", query = "SELECT a FROM Absences a WHERE a.id = :id"),
  @NamedQuery(name = "Absences.findByDate", query = "SELECT a FROM Absences a WHERE a.date = :date")})
public class Absences extends ToStringPretty<Absences> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "date")
  @Temporal(TemporalType.DATE)
  private Date date;
  @JoinColumn(name = "employee", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Employees employee;

  public Absences() {
    super.Set(this);
  }

  public Absences(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Absences(Integer id, Date date) {
    super.Set(this);
    this.id = id;
    this.date = date;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Employees getEmployee() {
    return employee;
  }

  public void setEmployee(Employees employee) {
    this.employee = employee;
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
    if (!(object instanceof Absences))
      return false;
    Absences other = (Absences) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Absences[ id=" + id + " ]";
  }
  
}
