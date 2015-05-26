/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.servlet;

/**
 *
 * @author wild
 */
public class GenericResponce {

  boolean success;
  String error;
  String redirect;

  public GenericResponce() {
    this.success = true;
    this.error = "";
    this.redirect = "";
  }

  public GenericResponce(String error) {
    this.success = true;
    this.error = "";
    this.redirect = "";
  }
  
  public GenericResponce(String error, String redirect) {
    this.success = true;
    this.error = "";
    this.redirect = redirect;
  }

  public GenericResponce done() {
    this.success = this.error.isEmpty();

    return this;
  }

}
