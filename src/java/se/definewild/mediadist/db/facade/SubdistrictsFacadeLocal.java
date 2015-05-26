/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Subdistricts;

/**
 *
 * @author wild
 */
@Local
public interface SubdistrictsFacadeLocal {

  void create(Subdistricts subdistricts);

  void edit(Subdistricts subdistricts);

  void remove(Subdistricts subdistricts);

  Subdistricts find(Object id);

  List<Subdistricts> findAll();

  List<Subdistricts> findRange(int[] range);

  int count();
  
}
