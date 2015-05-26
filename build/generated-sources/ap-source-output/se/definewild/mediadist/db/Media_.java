package se.definewild.mediadist.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.definewild.mediadist.db.Mediaitems;
import se.definewild.mediadist.db.Subscriptions;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-18T15:05:05")
@StaticMetamodel(Media.class)
public class Media_ { 

    public static volatile ListAttribute<Media, Mediaitems> mediaitemsList;
    public static volatile SingularAttribute<Media, String> name;
    public static volatile ListAttribute<Media, Subscriptions> subscriptionsList;
    public static volatile SingularAttribute<Media, Integer> id;

}