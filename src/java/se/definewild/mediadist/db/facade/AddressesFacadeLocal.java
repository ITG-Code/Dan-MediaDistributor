/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Addresses;

/**
 *
 * @author wild
 */
@Local
public interface AddressesFacadeLocal {

  void create(Addresses addresses);

  void edit(Addresses addresses);

  void remove(Addresses addresses);

  Addresses find(Object id);

  List<Addresses> findAll();

  List<Addresses> findRange(int[] range);

  int count();
  
}
