package se.definewild.mediadist.db;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.definewild.mediadist.db.Absences;
import se.definewild.mediadist.db.Districtagents;
import se.definewild.mediadist.db.Districts;
import se.definewild.mediadist.db.Reports;
import se.definewild.mediadist.db.Substitutes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-18T15:05:05")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, Districtagents> districtagents;
    public static volatile SingularAttribute<Employees, String> fname;
    public static volatile SingularAttribute<Employees, String> lname;
    public static volatile SingularAttribute<Employees, String> password;
    public static volatile ListAttribute<Employees, Absences> absencesList;
    public static volatile SingularAttribute<Employees, Substitutes> substitutes;
    public static volatile SingularAttribute<Employees, Districts> district;
    public static volatile ListAttribute<Employees, Reports> reportsList;
    public static volatile SingularAttribute<Employees, Integer> id;
    public static volatile SingularAttribute<Employees, String> email;

}