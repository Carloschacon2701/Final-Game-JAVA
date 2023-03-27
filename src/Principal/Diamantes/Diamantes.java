package Principal.Diamantes;


import Principal.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public abstract class Diamantes {
    int Y=0;
    int X= 0;
    int WIDTH=30;
    int HEIGHT= 30;
    Juego j;
    
    public Diamantes(int x, int y){
        this.Y= y;
        this.X=x;
    }
   
    public abstract void paint(Graphics g);
        
    public Rectangle getBounds(){
        return new Rectangle(X,Y, WIDTH, HEIGHT);
    }
    
    
    

    
    
}
