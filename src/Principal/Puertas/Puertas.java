/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Puertas;

import Principal.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Carlos Daniel
 */
public abstract class Puertas {
    static int WIDTH = 60;
    static int HEIGHT = 50;
    int X=0;
    int Y=0;
    Juego j;
    
    public Puertas( int x, int y){
        this.X=x;
        this.Y=y;
    }
    public abstract void paint(Graphics g);
    
    public Rectangle getBounds(){
        return new Rectangle(X,Y,WIDTH, HEIGHT);
    }
}
