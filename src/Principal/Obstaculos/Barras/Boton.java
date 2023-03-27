/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Obstaculos.Barras;

import Principal.Juego;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Boton {
    
    static int WIDTH = 80;
    static int HEIGHT = 80;
    public  boolean active= false;
    int X=0;
    int Y=0;
    Juego j;
    
    public Boton( int x, int y){
        this.X=x;
        this.Y=y;
    }
    
    public  void paint(Graphics g){
        ImageIcon image = new ImageIcon(getClass().getResource("../../../imagenes/boton.png"));
        g.drawImage(image.getImage(), X, Y, WIDTH, HEIGHT, null);
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(X,Y,WIDTH, HEIGHT);
    }
    
    
}
