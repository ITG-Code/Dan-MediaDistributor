/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.definewild.mediadist.db.Subscriptions;

/**
 *
 * @author wild
 */
@Stateless
public class SubscriptionsFacade extends AbstractFacade<Subscriptions> implements SubscriptionsFacadeLocal {
  @PersistenceContext(unitName = "MediaDistributorPU")
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public SubscriptionsFacade() {
    super(Subscriptions.class);
  }
  
}
