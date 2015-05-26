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
@Table(name = "subscribers")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Subscribers.findAll", query = "SELECT s FROM Subscribers s"),
  @NamedQuery(name = "Subscribers.findById", query = "SELECT s FROM Subscribers s WHERE s.id = :id"),
  @NamedQuery(name = "Subscribers.findByFname", query = "SELECT s FROM Subscribers s WHERE s.fname = :fname"),
  @NamedQuery(name = "Subscribers.findByLname", query = "SELECT s FROM Subscribers s WHERE s.lname = :lname"),
  @NamedQuery(name = "Subscribers.findBySocialnumber", query = "SELECT s FROM Subscribers s WHERE s.socialnumber = :socialnumber"),
  @NamedQuery(name = "Subscribers.findByEmail", query = "SELECT s FROM Subscribers s WHERE s.email = :email"),
  @NamedQuery(name = "Subscribers.findByPhone", query = "SELECT s FROM Subscribers s WHERE s.phone = :phone"),
  @NamedQuery(name = "Subscribers.findByPassword", query = "SELECT s FROM Subscribers s WHERE s.password = :password")})
public class Subscribers extends ToStringPretty<Subscribers> implements Serializable {
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
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 13)
  @Column(name = "socialnumber")
  private String socialnumber;
  // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "email")
  private String email;
  // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "phone")
  private String phone;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "password")
  private String password;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscriber")
  private List<Subscriptions> subscriptionsList;
  @JoinColumn(name = "address", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Addresses address;

  public Subscribers() {
    super.Set(this);
  }

  public Subscribers(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Subscribers(Integer id, String fname, String lname, String socialnumber, String email, String phone, String password) {
    super.Set(this);
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.socialnumber = socialnumber;
    this.email = email;
    this.phone = phone;
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

  public String getSocialnumber() {
    return socialnumber;
  }

  public void setSocialnumber(String socialnumber) {
    this.socialnumber = socialnumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @XmlTransient
  public List<Subscriptions> getSubscriptionsList() {
    return subscriptionsList;
  }

  public void setSubscriptionsList(List<Subscriptions> subscriptionsList) {
    this.subscriptionsList = subscriptionsList;
  }

  public Addresses getAddress() {
    return address;
  }

  public void setAddress(Addresses address) {
    this.address = address;
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
    if (!(object instanceof Subscribers))
      return false;
    Subscribers other = (Subscribers) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Subscribers[ id=" + id + " ]";
  }
  
}
