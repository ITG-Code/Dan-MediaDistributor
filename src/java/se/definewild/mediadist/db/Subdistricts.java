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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "subdistricts")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Subdistricts.findAll", query = "SELECT s FROM Subdistricts s"),
  @NamedQuery(name = "Subdistricts.findById", query = "SELECT s FROM Subdistricts s WHERE s.id = :id"),
  @NamedQuery(name = "Subdistricts.findByName", query = "SELECT s FROM Subdistricts s WHERE s.name = :name")})
public class Subdistricts extends ToStringPretty<Subdistricts> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "name")
  private String name;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 65535)
  @Column(name = "zipcodes")
  private String zipcodes;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "subdistrict")
  private List<Reports> reportsList;
  @JoinColumn(name = "district", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Districts district;

  public Subdistricts() {
    super.Set(this);
  }

  public Subdistricts(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Subdistricts(Integer id, String name, String zipcodes) {
    super.Set(this);
    this.id = id;
    this.name = name;
    this.zipcodes = zipcodes;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getZipcodes() {
    return zipcodes;
  }

  public void setZipcodes(String zipcodes) {
    this.zipcodes = zipcodes;
  }

  @XmlTransient
  public List<Reports> getReportsList() {
    return reportsList;
  }

  public void setReportsList(List<Reports> reportsList) {
    this.reportsList = reportsList;
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
    if (!(object instanceof Subdistricts))
      return false;
    Subdistricts other = (Subdistricts) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Subdistricts[ id=" + id + " ]";
  }
  
}
