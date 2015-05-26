/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Districtagents;

/**
 *
 * @author wild
 */
@Local
public interface DistrictagentsFacadeLocal {

  void create(Districtagents districtagents);

  void edit(Districtagents districtagents);

  void remove(Districtagents districtagents);

  Districtagents find(Object id);

  List<Districtagents> findAll();

  List<Districtagents> findRange(int[] range);

  int count();
  
}
