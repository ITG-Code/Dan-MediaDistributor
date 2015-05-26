package se.definewild.mediadist.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.definewild.mediadist.db.Addresses;
import se.definewild.mediadist.db.Media;
import se.definewild.mediadist.db.Missingmedia;
import se.definewild.mediadist.db.Subscribers;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-18T15:05:05")
@StaticMetamodel(Subscriptions.class)
public class Subscriptions_ { 

    public static volatile SingularAttribute<Subscriptions, Addresses> address;
    public static volatile SingularAttribute<Subscriptions, Subscribers> subscriber;
    public static volatile ListAttribute<Subscriptions, Missingmedia> missingmediaList;
    public static volatile SingularAttribute<Subscriptions, Integer> id;
    public static volatile SingularAttribute<Subscriptions, Media> media;

}