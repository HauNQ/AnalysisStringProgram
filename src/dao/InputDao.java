/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Scanner;

/**
 *
 * @author Nguyen Quang Hau
 */
public class InputDao {
   private static InputDao instance;
   
   public static InputDao getInstance(){
      if(instance == null)
         synchronized (InputDao.class) {
           if(instance == null) instance = new InputDao();
      }
      return instance;
   }

    public String getInputStrData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        return sc.nextLine();
    }
}
