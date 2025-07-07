/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CircusWorld;
import Controller.EasyLevel;
import Controller.Strategy;
import eg.edu.alexu.csd.oop.game.GameEngine;

import javax.swing.*;

/**
 *
 * @author Arwa Mohamed
 */
public class Circus extends JFrame {
   
 public static void run(Strategy s)
 {
      GameEngine.start("Circus World",new CircusWorld(1250,750,s ));
        JMenuBar menuTab = new JMenuBar() ;
        JMenu menu = new JMenu(  "Game Settings");
        JMenuItem newGame = new JMenuItem(  "New Game");
        JMenuItem pause= new JMenuItem( "Pause Game") ;
        JMenuItem resume = new JMenuItem(  "Resume");
        menu.add ( newGame);
        menu.addSeparator();
        menu.add ( pause);
        menu.add ( resume);
        menuTab.add(menu);
        

 }
    
}
