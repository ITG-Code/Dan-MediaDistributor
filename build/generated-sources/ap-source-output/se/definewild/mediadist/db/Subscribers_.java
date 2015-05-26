package se.definewild.mediadist.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.definewild.mediadist.db.Addresses;
import se.definewild.mediadist.db.Subscriptions;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-18T15:05:05")
@StaticMetamodel(Subscribers.class)
public class Subscribers_ { 

    public static volatile SingularAttribute<Subscribers, String> fname;
    public static volatile SingularAttribute<Subscribers, String> lname;
    public static volatile SingularAttribute<Subscribers, String> password;
    public static volatile SingularAttribute<Subscribers, Addresses> address;
    public static volatile SingularAttribute<Subscribers, String> phone;
    public static volatile ListAttribute<Subscribers, Subscriptions> subscriptionsList;
    public static volatile SingularAttribute<Subscribers, Integer> id;
    public static volatile SingularAttribute<Subscribers, String> socialnumber;
    public static volatile SingularAttribute<Subscribers, String> email;

}