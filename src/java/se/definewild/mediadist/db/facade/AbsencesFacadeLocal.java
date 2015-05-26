/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Absences;

/**
 *
 * @author wild
 */
@Local
public interface AbsencesFacadeLocal {

  void create(Absences absences);

  void edit(Absences absences);

  void remove(Absences absences);

  Absences find(Object id);

  List<Absences> findAll();

  List<Absences> findRange(int[] range);

  int count();
  
}
