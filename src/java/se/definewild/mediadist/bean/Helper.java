package se.definewild.mediadist.bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspWriter;
import se.definewild.mediadist.db.Districts;
import se.definewild.mediadist.db.Mediaitems;
import se.definewild.mediadist.db.Subscribers;
import se.definewild.mediadist.db.Subscriptions;
import se.definewild.mediadist.db.Undelivered;
import se.definewild.mediadist.db.UndeliveredData;
import se.definewild.mediadist.db.facade.AddressesFacadeLocal;
import se.definewild.mediadist.db.facade.MediaitemsFacadeLocal;
import se.definewild.mediadist.db.facade.MissingmediaFacadeLocal;
import se.definewild.mediadist.db.facade.SubdistrictsFacadeLocal;
import se.definewild.mediadist.db.facade.SubscribersFacadeLocal;
import se.definewild.mediadist.db.facade.SubscriptionsFacadeLocal;
import se.definewild.mediadist.db.facade.UndeliveredFacadeLocal;

public class Helper {
  static UndeliveredFacadeLocal undeliveredFacade = lookupUndeliveredFacadeLocal();
  static AddressesFacadeLocal adressesFacade = lookupAddressesFacadeLocal();
  static MissingmediaFacadeLocal missingmediaFacade = lookupMissingmediaFacadeLocal();
  static MediaitemsFacadeLocal mediaitemsFacade = lookupMediaitemsFacadeLocal();
  static SubscriptionsFacadeLocal subscriptionsFacade = lookupSubscriptionsFacadeLocal();
  static SubscribersFacadeLocal subscribersFacade = lookupSubscribersFacadeLocal();
  static SubdistrictsFacadeLocal subdistrictsFacade = lookupSubdistrictsFacadeLocal();

  public static String GetWebRootPath() {
    return Helper.class.getProtectionDomain().getCodeSource().getLocation().getPath().split("WEB-INF/")[0];
  }

  public static boolean FileExists(String fileName) {
    File f = new File(GetWebRootPath() + fileName);
    return f.exists();
  }

  public static String[] BaseSplitter(String base) {
    if (base.isEmpty())
      return new String[0];
    ArrayList<String> ret = new ArrayList<>();
    String[] parts = base.split("/");
    for (int i = 0; i < parts.length; i++) {
      String part = "";
      for (int j = 0; j <= i; j++)
        part += "/" + parts[j];
      ret.add(part);
    }

    return ret.toArray(new String[ret.size()]);
  }

  public static Subscribers RefreshObject(Subscribers subscriber) {
    return subscribersFacade.find(subscriber.getId());
  }

  public static List<Subscriptions> GetSubscriptions(Subscribers subscriber) {
    ArrayList<Subscriptions> ret = new ArrayList<>();
    for (Subscriptions sub : subscriptionsFacade.findAll())
      if (subscriber.getId() == sub.getSubscriber().getId())
        ret.add(sub);
    return ret;
  }

  public static List<UndeliveredData> GetNewMediaItems(Districts district) throws IOException {
  /*  List<Subdistricts> subdistricts = subdistrictsFacade.findAll();
    List<Addresses> addresses = adressesFacade.findAll();
    List<Subscriptions> subscriptions = subscriptionsFacade.findAll();
    List<Mediaitems> mediaitems = mediaitemsFacade.findAll();

    out.println("<pre>");
    out.println("subdistricts: " + subdistricts.size());
    out.println("addresses: " + addresses.size());
    out.println("subscriptions: " + subscriptions.size());
    out.println("mediaitems: " + mediaitems.size());
    
    ArrayList<Mediaitems> ret = new ArrayList<>();
    //Get all addresses for district
    for (Subdistricts s : subdistricts)
      if (s.getDistrict().equals(district))
        for (String zipcode : Arrays.asList(s.getZipcodes().split(",")))
          for (Addresses addr : addresses)
            if (addr.getZipcode().equals(zipcode))
              for (Subscriptions subscription : subscriptions)
                if (subscription.getAddress().equals(addr))
                  for (Mediaitems item : mediaitems)
                    if (item.getDelivered() == 0 && item.getMedia().equals(subscription.getMedia())) {
                      out.println("S: " + s.getId() + " zip: " + zipcode +
                              " addr: " + addr.getId() + " sub: " + subscription.getId() +
                              " media: " + item.getId());
                      ret.add(item);
                    }
    out.println("</pre>");
    return ret;*/
    List<Undelivered> db = undeliveredFacade.findAll();
    List<UndeliveredData> undelivered = new ArrayList<>();
    
    for (Undelivered ud : db)
      if (district.getId().equals(ud.getDistrict()))
        undelivered.add(new UndeliveredData(ud));
    
    return undelivered;
  }

  private static AddressesFacadeLocal lookupAddressesFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (AddressesFacadeLocal) c.lookup("java:global/MediaDistributor/AddressesFacade!se.definewild.mediadist.db.facade.AddressesFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private static SubscribersFacadeLocal lookupSubscribersFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (SubscribersFacadeLocal) c.lookup("java:global/MediaDistributor/SubscribersFacade!se.definewild.mediadist.db.facade.SubscribersFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private static SubscriptionsFacadeLocal lookupSubscriptionsFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (SubscriptionsFacadeLocal) c.lookup("java:global/MediaDistributor/SubscriptionsFacade!se.definewild.mediadist.db.facade.SubscriptionsFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private static MediaitemsFacadeLocal lookupMediaitemsFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (MediaitemsFacadeLocal) c.lookup("java:global/MediaDistributor/MediaitemsFacade!se.definewild.mediadist.db.facade.MediaitemsFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private static MissingmediaFacadeLocal lookupMissingmediaFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (MissingmediaFacadeLocal) c.lookup("java:global/MediaDistributor/MissingmediaFacade!se.definewild.mediadist.db.facade.MissingmediaFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private static SubdistrictsFacadeLocal lookupSubdistrictsFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (SubdistrictsFacadeLocal) c.lookup("java:global/MediaDistributor/SubdistrictsFacade!se.definewild.mediadist.db.facade.SubdistrictsFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }

  private static UndeliveredFacadeLocal lookupUndeliveredFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (UndeliveredFacadeLocal) c.lookup("java:global/MediaDistributor/UndeliveredFacade!se.definewild.mediadist.db.facade.UndeliveredFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }
}
