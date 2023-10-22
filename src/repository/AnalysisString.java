/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dao.InputDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nguyen Quang Hau
 */
public class AnalysisString implements IAnalisisString {

    @Override
    public HashMap<String, List<Integer>> getNumber(String input) {
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> squareNumbers = new ArrayList<>();
        HashMap<String, List<Integer>> hm = new HashMap<>();

        for (String string : input.split("[^\\d]{1,}")) {
            try {
                allNumbers.add(Integer.valueOf(string));
            } catch (Exception e) {
            }
        }
        
        // Square number;
        allNumbers.stream().forEach( number ->{
             // whether is a square number
             int temp = (int)Math.sqrt(number);
             if(temp*temp == number  && number != 0) squareNumbers.add(number);
             
             // whether is a evenNumber. If not is oddNumber.
             if(number % 2 == 0) evenNumbers.add(number);
             else  oddNumbers.add(number);
        });
        
        // add all result into hashmap
        hm.put("all", allNumbers);
        hm.put("even", evenNumbers);
        hm.put("odd", oddNumbers);
        hm.put("square", squareNumbers);

        return hm;
    }

    @Override
    public HashMap<String, StringBuilder> getCharacter(String input) {
        StringBuilder allChar = new StringBuilder();
        StringBuilder upperChar = new StringBuilder();
        StringBuilder lowerChar = new StringBuilder();
        StringBuilder specialChar = new StringBuilder();
        HashMap<String, StringBuilder> hm = new  HashMap<>();
        
        String str = "";
        
        // separate character to input String
        for (String string : input.split("[\\d]+")) {
            str+=string;
        }
        
        allChar.append(str);
        
        str.chars().forEach( c -> {
            // whether c is special character
           if(!Character.isAlphabetic(c))
               specialChar.append((char)c);
           
           // whether c is uppercase character. If not  c is lowercase character
           if(Character.isAlphabetic(c)){
               if(Character.isUpperCase(c)) upperChar.append((char)c);
               else lowerChar.append((char)c);
           }
        });
        
        // add all result into hashmap
        hm.put("all", allChar);
        hm.put("special", specialChar);
        hm.put("upper", upperChar);
        hm.put("lower", lowerChar);
        
        return hm;
    }

    @Override
    public void show(HashMap<String, List<Integer>> numberHM,HashMap<String, StringBuilder> characterHM ) {
        System.out.println("-----Result Analysis------");        
        System.out.print("All Number: ");
        System.out.println( numberHM.get("all"));
        System.out.print("Even Number: ");
        System.out.println( numberHM.get("even"));
        System.out.print("Odd Number: ");
        System.out.println( numberHM.get("odd"));
        System.out.print("Square Number: ");
        System.out.println( numberHM.get("square"));
        
        System.out.print("All Character: ");
        System.out.println( characterHM.get("all"));
        System.out.print("Uppercase Character: ");
        System.out.println( characterHM.get("upper").toString());
        System.out.print("Lowercase Character: ");
        System.out.println( characterHM.get("lower").toString());
        System.out.print("Special Character: ");
        System.out.println( characterHM.get("special").toString());
    }
    
    
    
    public void operate(){
        String input = InputDao.getInstance().getInputStrData();
        HashMap<String, List<Integer>> numberHM = getNumber(input);
        HashMap<String, StringBuilder> characterHM = getCharacter(input);
        show(numberHM, characterHM);
    }

    public static void main(String[] args) {
        AnalysisString as = new AnalysisString();
    }

}
