/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import repository.AnalysisString;
import view.Menu;

/**
 *
 * @author Nguyen Quang Hau
 */
public class AnalyzingTextProgramming extends Menu<String>{
    AnalysisString as;

    public AnalyzingTextProgramming() {
        super("Analysis String program ", new String[]{"Input String.","Exit"});
        as = new AnalysisString();
    }
    
    

    @Override
    public void excute(int n) {
        switch (n) {
            case 1 -> as.operate();
        }
    }
    
}
