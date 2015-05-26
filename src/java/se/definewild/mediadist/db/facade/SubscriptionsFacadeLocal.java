/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Subscriptions;

/**
 *
 * @author wild
 */
@Local
public interface SubscriptionsFacadeLocal {

  void create(Subscriptions subscriptions);

  void edit(Subscriptions subscriptions);

  void remove(Subscriptions subscriptions);

  Subscriptions find(Object id);

  List<Subscriptions> findAll();

  List<Subscriptions> findRange(int[] range);

  int count();
  
}
