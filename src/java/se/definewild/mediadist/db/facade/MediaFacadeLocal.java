/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.db.facade;

import java.util.List;
import javax.ejb.Local;
import se.definewild.mediadist.db.Media;

/**
 *
 * @author wild
 */
@Local
public interface MediaFacadeLocal {

  void create(Media media);

  void edit(Media media);

  void remove(Media media);

  Media find(Object id);

  List<Media> findAll();

  List<Media> findRange(int[] range);

  int count();
  
}
