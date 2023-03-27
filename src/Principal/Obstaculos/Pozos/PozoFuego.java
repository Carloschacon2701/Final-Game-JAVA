
package Principal.Obstaculos.Pozos;

import Principal.Juego;
import static Principal.Obstaculos.Pozos.Pozos.HEIGHT;
import static Principal.Obstaculos.Pozos.Pozos.WIDTH;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class PozoFuego extends Pozos{

    public PozoFuego( int x, int y) {
        super( x, y);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("../../../imagenes/pozoFuego.png"));
        g.drawImage(imagen.getImage(), X, Y, WIDTH, HEIGHT, null);
    }
    
}
