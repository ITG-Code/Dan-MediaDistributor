/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Substitutes;

/**
 *
 * @author wild
 */
@Local
public interface SubstitutesFacadeLocal {

  void create(Substitutes substitutes);

  void edit(Substitutes substitutes);

  void remove(Substitutes substitutes);

  Substitutes find(Object id);

  List<Substitutes> findAll();

  List<Substitutes> findRange(int[] range);

  int count();
  
}
