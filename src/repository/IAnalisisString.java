/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IAnalisisString {
    HashMap<String, List<Integer>> getNumber(String input);
    HashMap<String, StringBuilder> getCharacter(String input);
    void show(HashMap<String, List<Integer>> numbers, HashMap<String, StringBuilder> characters);
}
