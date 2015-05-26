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
@Table(name = "media")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m"),
  @NamedQuery(name = "Media.findById", query = "SELECT m FROM Media m WHERE m.id = :id"),
  @NamedQuery(name = "Media.findByName", query = "SELECT m FROM Media m WHERE m.name = :name")})
public class Media extends ToStringPretty<Media> implements Serializable {
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
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "media")
  private List<Subscriptions> subscriptionsList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "media")
  private List<Mediaitems> mediaitemsList;

  public Media() {
    super.Set(this);
  }

  public Media(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Media(Integer id, String name) {
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

  @XmlTransient
  public List<Subscriptions> getSubscriptionsList() {
    return subscriptionsList;
  }

  public void setSubscriptionsList(List<Subscriptions> subscriptionsList) {
    this.subscriptionsList = subscriptionsList;
  }

  @XmlTransient
  public List<Mediaitems> getMediaitemsList() {
    return mediaitemsList;
  }

  public void setMediaitemsList(List<Mediaitems> mediaitemsList) {
    this.mediaitemsList = mediaitemsList;
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
    if (!(object instanceof Media))
      return false;
    Media other = (Media) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Media[ id=" + id + " ]";
  }
  
}
