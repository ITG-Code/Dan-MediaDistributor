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
@Table(name = "undelivered")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Undelivered.findAll", query = "SELECT u FROM Undelivered u"),
  @NamedQuery(name = "Undelivered.findById", query = "SELECT u FROM Undelivered u WHERE u.id = :id"),
  @NamedQuery(name = "Undelivered.findBySubscriber", query = "SELECT u FROM Undelivered u WHERE u.subscriber = :subscriber"),
  @NamedQuery(name = "Undelivered.findByMediaitem", query = "SELECT u FROM Undelivered u WHERE u.mediaitem = :mediaitem"),
  @NamedQuery(name = "Undelivered.findByFname", query = "SELECT u FROM Undelivered u WHERE u.fname = :fname"),
  @NamedQuery(name = "Undelivered.findByLname", query = "SELECT u FROM Undelivered u WHERE u.lname = :lname"),
  @NamedQuery(name = "Undelivered.findByAddress", query = "SELECT u FROM Undelivered u WHERE u.address = :address"),
  @NamedQuery(name = "Undelivered.findByZipcode", query = "SELECT u FROM Undelivered u WHERE u.zipcode = :zipcode"),
  @NamedQuery(name = "Undelivered.findByCity", query = "SELECT u FROM Undelivered u WHERE u.city = :city"),
  @NamedQuery(name = "Undelivered.findByDistrict", query = "SELECT u FROM Undelivered u WHERE u.district = :district")})
public class Undelivered extends ToStringPretty<Undelivered> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "id")
  private int id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "subscriber")
  private int subscriber;
  @Basic(optional = false)
  @NotNull
  @Column(name = "mediaitem")
  private int mediaitem;
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
  @Basic(optional = false)
  @NotNull
  @Column(name = "district")
  private int district;

  public Undelivered() {
    super.Set(this);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSubscriber() {
    return subscriber;
  }

  public void setSubscriber(int subscriber) {
    this.subscriber = subscriber;
  }

  public int getMediaitem() {
    return mediaitem;
  }

  public void setMediaitem(int mediaitem) {
    this.mediaitem = mediaitem;
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

  public int getDistrict() {
    return district;
  }

  public void setDistrict(int district) {
    this.district = district;
  }
  
}
