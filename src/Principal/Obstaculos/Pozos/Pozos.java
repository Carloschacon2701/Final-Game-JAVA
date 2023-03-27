
package Principal.Obstaculos.Pozos;

import Principal.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Pozos {
    static int WIDTH = 80;
    static int HEIGHT = 25;
    int X=0;
    int Y=0;
    Juego j;
    
    public Pozos( int x, int y){
        this.X=x;
        this.Y=y;
    }
    public abstract void paint(Graphics g);
    
    public Rectangle getBounds(){
        return new Rectangle(X,Y,WIDTH, HEIGHT);
    }
}
