/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Mediaitems;

/**
 *
 * @author wild
 */
@Local
public interface MediaitemsFacadeLocal {

  void create(Mediaitems mediaitems);

  void edit(Mediaitems mediaitems);

  void remove(Mediaitems mediaitems);

  Mediaitems find(Object id);

  List<Mediaitems> findAll();

  List<Mediaitems> findRange(int[] range);

  int count();
  
}
