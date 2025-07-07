/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author karen
 */
public class ListIterator2 implements IteratorK {
    int index;
    List<GameObject> list;
    
    public ListIterator2(List<GameObject> list) {
        this.list = list;
        this.index = 0;
    }

   
    @Override
    public boolean hasNext() {
return index < list.size();
//if true then there is still more
    }
    @Override
    public GameObject getNext() {
        if (hasNext()) {
            return list.get(index++);
        } else {
            System.out.println("end");
            throw new NoSuchElementException();
            
        }}

    
}
