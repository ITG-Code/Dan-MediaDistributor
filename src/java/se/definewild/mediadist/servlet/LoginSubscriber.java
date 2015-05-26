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
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import se.definewild.mediadist.utils.PasswordUtils;
import se.definewild.mediadist.db.Subscribers;
import se.definewild.mediadist.db.facade.SubscribersFacadeLocal;

/**
 *
 * @author wild
 */
@WebServlet(name = "loginsubscriber", urlPatterns = {"/loginsubscriber"})
public class LoginSubscriber extends HttpServlet {
  @EJB
  private SubscribersFacadeLocal subscribersFacade;

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
    GenericResponce status = new GenericResponce("Wrong username and/or password!");
    ServletOutputStream out = response.getOutputStream();
    JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    String username = request.getParameter("username").trim();
    String password = null;
    try {
      password = PasswordUtils.Hash(request.getParameter("password").trim());
    } catch (NoSuchAlgorithmException ex) {
      status.error = "Encryption is mean!";
      done(writer, status);
    }

    List<Subscribers> subscribers = subscribersFacade.findAll();
    for (Subscribers subscriber : subscribers) {
      if (!subscriber.getEmail().equals(username))
        continue;

      if (!subscriber.getPassword().equals(password))
        continue;

      session.setAttribute("subscriber", subscriber);
      status.error = "";
      status.redirect = "?p=subscriber/manage";
      break;
    }

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
