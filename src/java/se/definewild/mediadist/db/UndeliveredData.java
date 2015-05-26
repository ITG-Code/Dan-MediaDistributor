/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import se.definewild.mediadist.bean.ToStringPretty;
import se.definewild.mediadist.db.facade.AddressesFacadeLocal;
import se.definewild.mediadist.db.facade.DistrictsFacadeLocal;
import se.definewild.mediadist.db.facade.MediaitemsFacadeLocal;
import se.definewild.mediadist.db.facade.SubscribersFacadeLocal;
import se.definewild.mediadist.db.facade.SubscriptionsFacadeLocal;

/**
 *
 * @author wild
 */
public class UndeliveredData extends ToStringPretty<UndeliveredData> {
  DistrictsFacadeLocal districtsFacade = lookupDistrictsFacadeLocal();
  AddressesFacadeLocal addressesFacade = lookupAddressesFacadeLocal();
  MediaitemsFacadeLocal mediaitemsFacade = lookupMediaitemsFacadeLocal();
  SubscribersFacadeLocal subscribersFacade = lookupSubscribersFacadeLocal();
  SubscriptionsFacadeLocal subscriptionsFacade = lookupSubscriptionsFacadeLocal();
  private Undelivered undelivered;
  private Subscriptions subscription; //id
  private Subscribers subscriber;
  private Mediaitems mediaitem;
  private Addresses address;
  private Districts district;
  
  public UndeliveredData(Undelivered undelivered) {
    super.Set(this);
    this.undelivered = undelivered;
    subscription = subscriptionsFacade.find(undelivered.getId());
    subscriber = subscribersFacade.find(undelivered.getSubscriber());
    mediaitem = mediaitemsFacade.find(undelivered.getMediaitem());
    address = addressesFacade.find(subscription.getAddress().getId());
    district = districtsFacade.find(undelivered.getDistrict());
  }

  public DistrictsFacadeLocal getDistrictsFacade() {
    return districtsFacade;
  }

  public void setDistrictsFacade(DistrictsFacadeLocal districtsFacade) {
    this.districtsFacade = districtsFacade;
  }

  public AddressesFacadeLocal getAddressesFacade() {
    return addressesFacade;
  }

  public void setAddressesFacade(AddressesFacadeLocal addressesFacade) {
    this.addressesFacade = addressesFacade;
  }

  public MediaitemsFacadeLocal getMediaitemsFacade() {
    return mediaitemsFacade;
  }

  public void setMediaitemsFacade(MediaitemsFacadeLocal mediaitemsFacade) {
    this.mediaitemsFacade = mediaitemsFacade;
  }

  public SubscribersFacadeLocal getSubscribersFacade() {
    return subscribersFacade;
  }

  public void setSubscribersFacade(SubscribersFacadeLocal subscribersFacade) {
    this.subscribersFacade = subscribersFacade;
  }

  public SubscriptionsFacadeLocal getSubscriptionsFacade() {
    return subscriptionsFacade;
  }

  public void setSubscriptionsFacade(SubscriptionsFacadeLocal subscriptionsFacade) {
    this.subscriptionsFacade = subscriptionsFacade;
  }

  public Undelivered getUndelivered() {
    return undelivered;
  }

  public void setUndelivered(Undelivered undelivered) {
    this.undelivered = undelivered;
  }

  public Subscriptions getSubscription() {
    return subscription;
  }

  public void setSubscription(Subscriptions subscription) {
    this.subscription = subscription;
  }

  public Subscribers getSubscriber() {
    return subscriber;
  }

  public void setSubscriber(Subscribers subscriber) {
    this.subscriber = subscriber;
  }

  public Mediaitems getMediaitem() {
    return mediaitem;
  }

  public void setMediaitem(Mediaitems mediaitem) {
    this.mediaitem = mediaitem;
  }

  public Addresses getAddress() {
    return address;
  }

  public void setAddress(Addresses address) {
    this.address = address;
  }

  public Districts getDistrict() {
    return district;
  }

  public void setDistrict(Districts district) {
    this.district = district;
  }

  private SubscriptionsFacadeLocal lookupSubscriptionsFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (SubscriptionsFacadeLocal) c.lookup("java:global/MediaDistributor/SubscriptionsFacade!se.definewild.mediadist.db.facade.SubscriptionsFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private SubscribersFacadeLocal lookupSubscribersFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (SubscribersFacadeLocal) c.lookup("java:global/MediaDistributor/SubscribersFacade!se.definewild.mediadist.db.facade.SubscribersFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private MediaitemsFacadeLocal lookupMediaitemsFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (MediaitemsFacadeLocal) c.lookup("java:global/MediaDistributor/MediaitemsFacade!se.definewild.mediadist.db.facade.MediaitemsFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private AddressesFacadeLocal lookupAddressesFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (AddressesFacadeLocal) c.lookup("java:global/MediaDistributor/AddressesFacade!se.definewild.mediadist.db.facade.AddressesFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private DistrictsFacadeLocal lookupDistrictsFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (DistrictsFacadeLocal) c.lookup("java:global/MediaDistributor/DistrictsFacade!se.definewild.mediadist.db.facade.DistrictsFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }
}
