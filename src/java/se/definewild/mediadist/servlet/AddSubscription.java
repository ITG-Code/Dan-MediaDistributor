/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.servlet;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.definewild.mediadist.db.Addresses;
import se.definewild.mediadist.db.Media;
import se.definewild.mediadist.db.Subscribers;
import se.definewild.mediadist.db.Subscriptions;
import se.definewild.mediadist.db.facade.AddressesFacadeLocal;
import se.definewild.mediadist.db.facade.MediaFacadeLocal;
import se.definewild.mediadist.db.facade.SubscriptionsFacadeLocal;

/**
 *
 * @author wild
 */
@WebServlet(name = "addSubscription", urlPatterns = {"/addsubscription"})
public class AddSubscription extends HttpServlet {
  @EJB
  private SubscriptionsFacadeLocal subscriptionsFacade;
  @EJB
  private MediaFacadeLocal mediaFacade;
  @EJB
  private AddressesFacadeLocal addressesFacade;

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    HttpSession session = request.getSession();
    GenericResponce status = new GenericResponce();
    ServletOutputStream out = response.getOutputStream();
    JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
    
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
  
    Integer media = Integer.valueOf(request.getParameter("media").trim());
    String address = request.getParameter("address").trim().replaceAll("((\\d+)\\s*(\\w+))", "$2$3");
    String zipcode = request.getParameter("zipcode").trim().replaceAll(" +", "");
    String city = request.getParameter("city").trim();
    
    Addresses addr = null;
    List<Addresses> addrs = addressesFacade.findAll();
    if (addrs != null && addrs.size() > 0)
      for (Addresses a : addrs) {
        if (a.getAddress().equals(address) && a.getZipcode().equals(zipcode)) {
          addr = a;
          break;
        }
      }
    if (addr == null)
      addressesFacade.create(addr = new Addresses(null, address, zipcode, city));
    
    Media me = mediaFacade.find(media);
    if (me == null) {
      status.error = "Invalid media. Could not be found";
      done(writer, status);
      return;
    }
    
    Subscriptions subscription = new Subscriptions(null);
    subscription.setMedia(me);
    subscription.setAddress(addr);
    subscription.setSubscriber((Subscribers)session.getAttribute("subscriber"));
    subscriptionsFacade.create(subscription);
    
    status.redirect = "?p=subscriber/manage";
    done(writer, status);
  }

  void done(JsonWriter writer, GenericResponce status) throws IOException {
    writer.setIndent("  ");
    new Gson().toJson(status.done(), GenericResponce.class, writer);
    writer.flush();
    writer.close();
  }
  
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.sendError(418, "I am a teapot");
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
