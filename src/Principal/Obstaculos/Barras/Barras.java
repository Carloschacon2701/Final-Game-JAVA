/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Obstaculos.Barras;

import Principal.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Carlos Daniel
 */
public abstract class Barras {
    static int WIDTH = 75;
    static int HEIGHT = 30;
    public boolean active= false;
    int X=0;
    int Y=0;
    Juego j;
    
    public Barras( int x, int y){
        this.X=x;
        this.Y=y;
    }
    public abstract void paint(Graphics g);
    
    public Rectangle getBounds(){
        return new Rectangle(X,Y,WIDTH, HEIGHT);
    }
}
