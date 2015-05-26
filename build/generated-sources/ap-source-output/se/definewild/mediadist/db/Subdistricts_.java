package se.definewild.mediadist.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.definewild.mediadist.db.Districts;
import se.definewild.mediadist.db.Reports;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-18T15:05:05")
@StaticMetamodel(Subdistricts.class)
public class Subdistricts_ { 

    public static volatile SingularAttribute<Subdistricts, String> zipcodes;
    public static volatile SingularAttribute<Subdistricts, Districts> district;
    public static volatile SingularAttribute<Subdistricts, String> name;
    public static volatile ListAttribute<Subdistricts, Reports> reportsList;
    public static volatile SingularAttribute<Subdistricts, Integer> id;

}