/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.tag;

import se.definewild.mediadist.db.Districts;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import se.definewild.mediadist.db.facade.DistrictsFacadeLocal;

/**
 *
 * @author wild
 */
public class DistrictsTag extends SimpleTagSupport {
  DistrictsFacadeLocal districtsFacade = lookupDistrictsFacadeLocal();
  private int value = -1;
  private String title;
  private String name;


  @Override
  public void doTag() throws JspException {
    int i = 0;
    int value = this.value+1;
    JspWriter out = getJspContext().getOut();
    
    try {
      out.println("<select name=\"" + name + "\">");
      
      out.println("<option disabled=\"disable\""+(value == i++ ? " selected":"")+">"+title+"</option>");
      
      for (Districts district : districtsFacade.findAll()) {
        out.println("<option value=\"" + district.getId() + "\""+(value == i++ ? " selected":"")+">" + district.getName() + "</option>");
      }
      
      out.println("</select>");
    } catch (java.io.IOException ex) {
      throw new JspException("Error in Districts tag", ex);
    }
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setTitle(String title) {
    this.title = title;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  private DistrictsFacadeLocal lookupDistrictsFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (DistrictsFacadeLocal) c.lookup("java:global/MediaDistributor/DistrictsFacade!se.definewild.mediadist.db.facade.DistrictsFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }
  
}
