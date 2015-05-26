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
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import se.definewild.mediadist.db.Districts;
import se.definewild.mediadist.db.Employees;
import se.definewild.mediadist.db.facade.DistrictsFacadeLocal;
import se.definewild.mediadist.db.facade.EmployeesFacadeLocal;
import se.definewild.mediadist.utils.PasswordUtils;

/**
 *
 * @author wild
 */
@WebServlet(name = "registerstaff", urlPatterns = {"/registerstaff"})
public class RegisterStaff extends HttpServlet {
  @EJB
  private DistrictsFacadeLocal districtsFacade;
  @EJB
  private EmployeesFacadeLocal employeesFacade;

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
    
    String firstname = request.getParameter("firstname").trim();
    String lastname = request.getParameter("lastname").trim();
    Integer district_f = Integer.valueOf(request.getParameter("district").trim());
    String email = request.getParameter("email").trim();
    String password = null;
    try {
      password = PasswordUtils.Hash(request.getParameter("password").trim());
    } catch (NoSuchAlgorithmException ex) {
      status.error = "Encryption is mean!";
      done(writer, status);
    }
    
    Districts districts = districtsFacade.find(district_f.intValue());
    if (districts == null) {
      status.error = "Invalid district. Could not be found";
      done(writer, status);
      return;
    }
    
    System.out.println("firstname: " + firstname + ", lastname: "+ lastname + ", email: " + email + ", password: " + password + ", districts: " + districts);
    Employees employee = new Employees(null, firstname, lastname, email, password);
    employee.setDistrict(districts);
    try {
      employeesFacade.create(employee);
    } catch (EJBException e_) {
      ConstraintViolationException e = (ConstraintViolationException) e_.getCause();
      System.out.println("Error: ");
      System.out.println(e.getMessage());
      System.out.println("##############");
      Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
      
      for(ConstraintViolation<?> constraint : constraintViolations) {
        System.out.println(constraint.getMessage());  
      }
      
      System.out.println("##############");
      System.out.println();
      throw e;
    }
      
    session.setAttribute("employee", employee);
    status.redirect = "?p=staff/manage";
    
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
