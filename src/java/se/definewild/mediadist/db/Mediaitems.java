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
@Table(name = "mediaitems")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Mediaitems.findAll", query = "SELECT m FROM Mediaitems m"),
  @NamedQuery(name = "Mediaitems.findById", query = "SELECT m FROM Mediaitems m WHERE m.id = :id"),
  @NamedQuery(name = "Mediaitems.findByTitle", query = "SELECT m FROM Mediaitems m WHERE m.title = :title")})
public class Mediaitems extends ToStringPretty<Mediaitems> implements Serializable {
  @Basic(optional = false)
  @NotNull
  @Column(name = "delivered")
  private short delivered;
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "title")
  private String title;
  @JoinColumn(name = "media", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Media media;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "mediaitem")
  private List<Missingmedia> missingmediaList;

  public Mediaitems() {
    super.Set(this);
  }

  public Mediaitems(Integer id) {
    super.Set(this);
    this.id = id;
  }

  public Mediaitems(Integer id, String title) {
    super.Set(this);
    this.id = id;
    this.title = title;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Media getMedia() {
    return media;
  }

  public void setMedia(Media media) {
    this.media = media;
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
    if (!(object instanceof Mediaitems))
      return false;
    Mediaitems other = (Mediaitems) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "se.definewild.mediadist.db.Mediaitems[ id=" + id + " ]";
  }

  public short getDelivered() {
    return delivered;
  }

  public void setDelivered(short delivered) {
    this.delivered = delivered;
  }
  
}
