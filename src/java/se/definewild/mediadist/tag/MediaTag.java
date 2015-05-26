/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.tag;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import se.definewild.mediadist.db.Media;
import se.definewild.mediadist.db.facade.MediaFacadeLocal;

/**
 *
 * @author wild
 */
public class MediaTag extends SimpleTagSupport {
  MediaFacadeLocal mediaFacade = lookupMediaFacadeLocal();
  private int value = -1;
  private String name;
  private String title;

  @Override
  public void doTag() throws JspException {
    int i = 0;
    int value = this.value+1;
    JspWriter out = getJspContext().getOut();
    
    try {
      out.println("<select name=\"" + name + "\">");
      out.println("<option disabled=\"disable\""+(value == i++ ? " selected":"")+">"+title+"</option>");
      
      for (Media media : mediaFacade.findAll()) {
        out.println("<option value=\"" + media.getId() + "\""+(value == i++ ? " selected":"")+">" + media.getName() + "</option>");
      }
      
      out.println("</select>");
    } catch (java.io.IOException ex) {
      throw new JspException("Error in MediaTag tag", ex);
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setValue(int value) {
    this.value = value;
  }

  private MediaFacadeLocal lookupMediaFacadeLocal() {
    try {
      Context c = new InitialContext();
      return (MediaFacadeLocal) c.lookup("java:global/MediaDistributor/MediaFacade!se.definewild.mediadist.db.facade.MediaFacadeLocal");
    } catch (NamingException ne) {
      Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
      throw new RuntimeException(ne);
    }
  }
  
}
