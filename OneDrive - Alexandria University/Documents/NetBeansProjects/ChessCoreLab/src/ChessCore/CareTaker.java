/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChessCore;

import java.util.Stack;

/**
 *
 * @author ADMIN
 */
public class CareTaker {
     private Stack<Memento> history=new Stack<>();//+
     
     public void addState(Memento m){
         history.push(m);
     }
     public Memento getState(){
        return  history.pop();
     }
     public boolean  isEmpty(){
         return history.empty();
     }

}
