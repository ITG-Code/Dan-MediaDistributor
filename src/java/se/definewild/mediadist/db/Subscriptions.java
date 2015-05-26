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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import se.definewild.mediadist.bean.ToStringPretty;

/**
 *
 * @author wild
 */
@Entity
@Table(name = "subscriptions")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Subscriptions.findAll", query = "SELECT s FROM Subscriptions s"),
  @NamedQuery(name = "Subscriptions.findById", query = "SELECT s FROM Subscriptions s WHERE s.id = :id")})
public class Subscriptions extends ToStringPretty<Subscriptions> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @JoinColumn(name = "address", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Addresses address;
  @JoinColumn(name = "media", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Media media;
  @JoinColumn(name = "subscriber", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Subscribers subscriber;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscription")
  private List<Missingmedia> missingmediaList;

  public Subscriptions() {
    super.Set(this);
  }

  public Subscriptions(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Addresses getAddress() {
    return address;
  }

  public void setAddress(Addresses address) {
    this.address = address;
  }

  public Media getMedia() {
    return media;
  }

  public void setMedia(Media media) {
    this.media = media;
  }

  public Subscribers getSubscriber() {
    return subscriber;
  }

  public void setSubscriber(Subscribers subscriber) {
    this.subscriber = subscriber;
  }

  @XmlTransient
  public List<Missingmedia> getMissingmediaList() {
    return missingmediaList;
  }

  public void setMissingmediaList(List<Missingmedia> missingmediaList) {
    this.missingmediaList = missingmediaList;
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
    if (!(object instanceof Subscriptions))
      return false;
    Subscriptions other = (Subscriptions) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Subscriptions[ id=" + id + " ]";
  }
  
}
