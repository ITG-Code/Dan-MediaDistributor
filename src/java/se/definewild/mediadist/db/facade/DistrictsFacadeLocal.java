/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Districts;

/**
 *
 * @author wild
 */
@Local
public interface DistrictsFacadeLocal {

  void create(Districts districts);

  void edit(Districts districts);

  void remove(Districts districts);

  Districts find(Object id);

  List<Districts> findAll();

  List<Districts> findRange(int[] range);

  int count();
  
}
