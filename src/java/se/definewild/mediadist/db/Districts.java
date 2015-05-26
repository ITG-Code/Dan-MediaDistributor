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
@Table(name = "districts")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Districts.findAll", query = "SELECT d FROM Districts d"),
  @NamedQuery(name = "Districts.findById", query = "SELECT d FROM Districts d WHERE d.id = :id"),
  @NamedQuery(name = "Districts.findByName", query = "SELECT d FROM Districts d WHERE d.name = :name")})
public class Districts extends ToStringPretty<Districts> implements Serializable {
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
  @JoinColumn(name = "headquarters", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Addresses headquarters;

  public Districts() {
    super.Set(this);
  }

  public Districts(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Districts(Integer id, String name) {
    super.Set(this);
    this.id = id;
    this.name = name;
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

  public Addresses getHeadquarters() {
    return headquarters;
  }

  public void setHeadquarters(Addresses headquarters) {
    this.headquarters = headquarters;
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
    if (!(object instanceof Districts))
      return false;
    Districts other = (Districts) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Districts[ id=" + id + " ]";
  }
  
}
