/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Subscribers;

/**
 *
 * @author wild
 */
@Local
public interface SubscribersFacadeLocal {

  void create(Subscribers subscribers);

  void edit(Subscribers subscribers);

  void remove(Subscribers subscribers);

  Subscribers find(Object id);

  List<Subscribers> findAll();

  List<Subscribers> findRange(int[] range);

  int count();
  
}
