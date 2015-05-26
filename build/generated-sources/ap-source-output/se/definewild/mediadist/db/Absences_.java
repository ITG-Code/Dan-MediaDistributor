package se.definewild.mediadist.db;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import se.definewild.mediadist.db.Employees;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-05-18T15:05:05")
@StaticMetamodel(Absences.class)
public class Absences_ { 

    public static volatile SingularAttribute<Absences, Date> date;
    public static volatile SingularAttribute<Absences, Integer> id;
    public static volatile SingularAttribute<Absences, Employees> employee;

}