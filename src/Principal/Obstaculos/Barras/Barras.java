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
    int WIDTH = 75;
    int HEIGHT = 14;
    int velocidad = 0;
    public boolean activeBoton= false;
    int X=0;
    int Y=0;
    int nivel=0;

    
    public Barras( int x, int y, int nivel){
        this.X=x;
        this.Y=y;
        this.nivel=nivel;
    }
    public abstract void paint(Graphics g);
    
    public Rectangle getBounds(){
        return new Rectangle(X,Y,WIDTH, HEIGHT);
    }
}
