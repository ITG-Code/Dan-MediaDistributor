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
@Table(name = "addresses")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a"),
  @NamedQuery(name = "Addresses.findById", query = "SELECT a FROM Addresses a WHERE a.id = :id"),
  @NamedQuery(name = "Addresses.findByAddress", query = "SELECT a FROM Addresses a WHERE a.address = :address"),
  @NamedQuery(name = "Addresses.findByZipcode", query = "SELECT a FROM Addresses a WHERE a.zipcode = :zipcode"),
  @NamedQuery(name = "Addresses.findByCity", query = "SELECT a FROM Addresses a WHERE a.city = :city")})
public class Addresses extends ToStringPretty<Addresses> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "address")
  private String address;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "zipcode")
  private String zipcode;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "city")
  private String city;

  public Addresses() {
    super.Set(this);
  }

  public Addresses(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Addresses(Integer id, String address, String zipcode, String city) {
    super.Set(this);
    this.id = id;
    this.address = address;
    this.zipcode = zipcode;
    this.city = city;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
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
    if (!(object instanceof Addresses))
      return false;
    Addresses other = (Addresses) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Addresses[ id=" + id + " ]";
  }
  
}
