/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Obstaculos.Cubo;

import Principal.Bloques;
import Principal.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;



public class Cubo {
    Bloques bloque;
    public final int WIDTH = 30;
    public final int HEIGHT = 30;
    public int X=390;
    public int Y=120;
    Juego j;
    boolean cayendo= false;
    
    public Cubo( Juego j){
        this.j=j;
    }


    public void paint(Graphics g){
        ImageIcon imagen = new ImageIcon(getClass().getResource("../../../imagenes/cubo.jpg"));
        g.drawImage(imagen.getImage(), X, Y, WIDTH, HEIGHT, null);
        chequearCaida();
        desplazarCubo();
    }
    
    public Rectangle getBounds(){
        return new Rectangle(X,Y,WIDTH, HEIGHT);
    }
    
    public  boolean bottomBounds(){
        Rectangle rec= new Rectangle(X+10,Y+HEIGHT-5,WIDTH-20,5);
        
        for(int i=0; i<j.ListaBloques.size(); i++){
           if(rec.intersects(j.ListaBloques.get(i).getBounds())){
               return true;
           }
        }
        return false;

    }
    
    public boolean leftBounds(){
        Rectangle recLeft = new Rectangle(X,Y+10,5,HEIGHT-20);
  
        for(int i=0; i<j.ListaBloques.size(); i++){
           if(recLeft.intersects(j.ListaBloques.get(i).getBounds())){
               return true;
           }

        }
        return false;
    }
    
    public boolean rightBounds(){
        Rectangle recRight= new Rectangle(X+WIDTH-5,Y+10,5, WIDTH-20);
         for(int i=0; i<j.ListaBloques.size(); i++){

           if(recRight.intersects(j.ListaBloques.get(i).getBounds())){
               return true;
           }
        }
        return false;
    }
    
    
    public boolean choque(){
        for(int i=0; i<j.ListaBloques.size(); i++){
           if(getBounds().intersects(j.ListaBloques.get(i).getBounds())){
               return true;
           }
        }
        return false;
    }
    
    public void chequearCaida(){
        if(cayendo){
            Y+=1;
        }
        
        if(bottomBounds()){
            Y=Y;
            cayendo = false;
        }
        else{ 
            if(!cayendo){
               cayendo = true;
            }
            
        }
    }
    
    public void desplazarCubo(){
        if(j.niño.getBoundsLeft().intersects(getBounds())){
            
           if(leftBounds()){
                X=X;
               
            }
           else if(!leftBounds()){
                X-=5; 
            } 

        }  
        
        if(j.niño.getBoundsRight().intersects(getBounds())){
            if(!rightBounds()){
                X+=5; 
            } 
            else if(rightBounds()){
                X=X;
               
            }
        }
    }
    
}
