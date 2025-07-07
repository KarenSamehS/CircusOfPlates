/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * @author Esraa
 */
public class Clown extends ImageObject{
        private static Clown clown;
    public static Clown getInstance(int x , int y ,String path)
    {
        if (clown==null)
        {
            clown=new Clown(x,y,path);
        }
        return clown;
    }

    private  Clown(int x, int y, String path) {
        super(x, y, path);
    }
    @Override
    public void setY(int y) {
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle(getX()+10, getY(),50, 30);

    }
    public Rectangle getBoundsRight() {
        return new Rectangle(getX()+149, getY(),50, 10);

    }


}