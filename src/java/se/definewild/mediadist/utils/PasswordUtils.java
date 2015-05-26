/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.definewild.mediadist.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author wild
 */
public class PasswordUtils {

  static public String Hash(String password) throws NoSuchAlgorithmException {
    byte[] plainText = password.getBytes();

    MessageDigest md = MessageDigest.getInstance("SHA");

    md.reset();
    md.update(plainText);
    byte[] encodedPassword = md.digest();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < encodedPassword.length; i++) {
      if ((encodedPassword[i] & 0xff) < 0x10) {
        sb.append("0");
      }

      sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
    }
    return sb.toString();
  }
}