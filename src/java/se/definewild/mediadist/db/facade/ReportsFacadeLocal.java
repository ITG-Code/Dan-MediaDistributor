/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Reports;

/**
 *
 * @author wild
 */
@Local
public interface ReportsFacadeLocal {

  void create(Reports reports);

  void edit(Reports reports);

  void remove(Reports reports);

  Reports find(Object id);

  List<Reports> findAll();

  List<Reports> findRange(int[] range);

  int count();
  
}
