package se.definewild.mediadist.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.definewild.mediadist.db.Media;
import se.definewild.mediadist.db.Missingmedia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-18T15:05:05")
@StaticMetamodel(Mediaitems.class)
public class Mediaitems_ { 

    public static volatile SingularAttribute<Mediaitems, Short> delivered;
    public static volatile ListAttribute<Mediaitems, Missingmedia> missingmediaList;
    public static volatile SingularAttribute<Mediaitems, Integer> id;
    public static volatile SingularAttribute<Mediaitems, Media> media;
    public static volatile SingularAttribute<Mediaitems, String> title;

}