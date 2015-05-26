/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Missingmedia;

/**
 *
 * @author wild
 */
@Local
public interface MissingmediaFacadeLocal {

  void create(Missingmedia missingmedia);

  void edit(Missingmedia missingmedia);

  void remove(Missingmedia missingmedia);

  Missingmedia find(Object id);

  List<Missingmedia> findAll();

  List<Missingmedia> findRange(int[] range);

  int count();
  
}
