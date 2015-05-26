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
import javax.xml.bind.annotation.XmlRootElement;
import se.definewild.mediadist.bean.ToStringPretty;

/**
 *
 * @author wild
 */
@Entity
@Table(name = "missingmedia")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Missingmedia.findAll", query = "SELECT m FROM Missingmedia m"),
  @NamedQuery(name = "Missingmedia.findById", query = "SELECT m FROM Missingmedia m WHERE m.id = :id")})
public class Missingmedia extends ToStringPretty<Missingmedia> implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @JoinColumn(name = "mediaitem", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Mediaitems mediaitem;
  @JoinColumn(name = "subscription", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Subscriptions subscription;

  public Missingmedia() {
    super.Set(this);
  }

  public Missingmedia(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Mediaitems getMediaitem() {
    return mediaitem;
  }

  public void setMediaitem(Mediaitems mediaitem) {
    this.mediaitem = mediaitem;
  }

  public Subscriptions getSubscription() {
    return subscription;
  }

  public void setSubscription(Subscriptions subscription) {
    this.subscription = subscription;
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
    if (!(object instanceof Missingmedia))
      return false;
    Missingmedia other = (Missingmedia) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Missingmedia[ id=" + id + " ]";
  }
  
}
