/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import se.definewild.mediadist.bean.ToStringPretty;

/**
 *
 * @author wild
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
  @NamedQuery(name = "Employees.findById", query = "SELECT e FROM Employees e WHERE e.id = :id"),
  @NamedQuery(name = "Employees.findByFname", query = "SELECT e FROM Employees e WHERE e.fname = :fname"),
  @NamedQuery(name = "Employees.findByLname", query = "SELECT e FROM Employees e WHERE e.lname = :lname"),
  @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email"),
  @NamedQuery(name = "Employees.findByPassword", query = "SELECT e FROM Employees e WHERE e.password = :password")})
public class Employees extends ToStringPretty<Employees> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "fname")
  private String fname;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "lname")
  private String lname;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "email")
  private String email;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "password")
  private String password;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
  private Districtagents districtagents;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
  private List<Reports> reportsList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
  private List<Absences> absencesList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "employees")
  private Substitutes substitutes;
  @JoinColumn(name = "district", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Districts district;

  public Employees() {
    super.Set(this);
  }

  public Employees(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Employees(Integer id, String fname, String lname, String email, String password) {
    super.Set(this);
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Districtagents getDistrictagents() {
    return districtagents;
  }

  public void setDistrictagents(Districtagents districtagents) {
    this.districtagents = districtagents;
  }

  @XmlTransient
  public List<Reports> getReportsList() {
    return reportsList;
  }

  public void setReportsList(List<Reports> reportsList) {
    this.reportsList = reportsList;
  }

  @XmlTransient
  public List<Absences> getAbsencesList() {
    return absencesList;
  }

  public void setAbsencesList(List<Absences> absencesList) {
    this.absencesList = absencesList;
  }

  public Substitutes getSubstitutes() {
    return substitutes;
  }

  public void setSubstitutes(Substitutes substitutes) {
    this.substitutes = substitutes;
  }

  public Districts getDistrict() {
    return district;
  }

  public void setDistrict(Districts district) {
    this.district = district;
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
    if (!(object instanceof Employees))
      return false;
    Employees other = (Employees) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Employees[ id=" + id + " ]";
  }
  
}
