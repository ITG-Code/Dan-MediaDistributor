package se.definewild.mediadist.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.definewild.mediadist.db.Employees;
import se.definewild.mediadist.db.Subdistricts;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-18T15:05:05")
@StaticMetamodel(Reports.class)
public class Reports_ { 

    public static volatile SingularAttribute<Reports, String> subscriptions;
    public static volatile SingularAttribute<Reports, Subdistricts> subdistrict;
    public static volatile SingularAttribute<Reports, Integer> id;
    public static volatile SingularAttribute<Reports, Employees> employee;

}