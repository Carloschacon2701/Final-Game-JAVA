
package Principal.Obstaculos.Pozos;

import Principal.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Pozos {
    int WIDTH;
    static int HEIGHT = 25;
    int X=0;
    int Y=0;
    Juego j;
    
    public Pozos( int x, int y, int WIDTH){
        this.X=x;
        this.Y=y;
        this.WIDTH=WIDTH;
    }
    public abstract void paint(Graphics g);
    
    public Rectangle getBounds(){
        return new Rectangle(X,Y,WIDTH, HEIGHT);
    }
}
