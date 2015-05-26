/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Undelivered;

/**
 *
 * @author wild
 */
@Local
public interface UndeliveredFacadeLocal {

  void create(Undelivered undelivered);

  void edit(Undelivered undelivered);

  void remove(Undelivered undelivered);

  Undelivered find(Object id);

  List<Undelivered> findAll();

  List<Undelivered> findRange(int[] range);

  int count();
  
}
