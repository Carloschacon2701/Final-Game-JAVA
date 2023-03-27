package Principal;

import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Bloques {
    
    public final int WIDTH =40;
    public final int HEIGHT =29;
    public int Y=0;
    public int X=0;
    public Juego j;


    
    public Bloques(Juego j, int x, int y){
        this.j = j;
        this.X=x;
        this.Y=y;
    }
    
    public void paint(Graphics g){
        ImageIcon image = new ImageIcon(getClass().getResource("../imagenes/ladrillo.png"));
        g.drawImage(image.getImage(), X, Y, WIDTH, HEIGHT, null);
    }
        
    public Rectangle getBounds(){
        return new Rectangle(X,Y, WIDTH, HEIGHT);
    }

    
     
    
}
   