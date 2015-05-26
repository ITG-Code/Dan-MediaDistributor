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
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.definewild.mediadist.bean.Helper;
import se.definewild.mediadist.db.Media;
import se.definewild.mediadist.db.Subscribers;
import se.definewild.mediadist.db.Subscriptions;
import se.definewild.mediadist.db.facade.MediaFacadeLocal;
import se.definewild.mediadist.db.facade.SubscriptionsFacadeLocal;

/**
 *
 * @author wild
 */
@WebServlet(name = "removesubscription", urlPatterns = {"/removesubscription"})
public class RemoveSubscription extends HttpServlet {

  @EJB
  private SubscriptionsFacadeLocal subscriptionsFacade;
  @EJB
  private MediaFacadeLocal mediaFacade;

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
    GenericResponce status = new GenericResponce("", "?p=subscriber/manage");
    ServletOutputStream out = response.getOutputStream();
    JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    Integer subscriptionID = null;
    try {
      subscriptionID = Integer.valueOf(request.getParameter("subscription").trim());
    } catch (Exception e) {
      status.error = "Unvalid number: " + request.getParameter("subscription");
      done(writer, status);
    }
    
    Subscriptions subscription = subscriptionsFacade.find(subscriptionID);

    if (subscription == null ||
            //This will only be checked if it's not null
            subscription.getSubscriber() == (Subscribers) session.getAttribute("subscriber"))
      status.error = "Invalid subscription. Could not be found input: " + request.getParameter("subscription");
    else
      subscriptionsFacade.remove(subscription);

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
    processRequest(request, response);
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
