/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Arwa Mohamed
 */
public class Plates extends ImageObject {
    //    private int dx;
//    private int dy;
    private int color;

    private int plateOrGold; //0 for plate , 1 for gold


    public Plates(int x, int y, String path ,int plateOrGold,int color) {
        super(x, y, path);
        this.plateOrGold=plateOrGold;
        this.color=color;

    }


    public int getPlateOrGold() {
        return plateOrGold;
    }

    public void setPlateOrGold(int plateOrGold) {
        this.plateOrGold = plateOrGold;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }



}