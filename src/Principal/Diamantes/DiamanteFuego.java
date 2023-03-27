/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Diamantes;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Daniel
 */
public class DiamanteFuego  extends Diamantes{

    public DiamanteFuego(int x, int y) {
        super(x, y);
    }

    @Override
    public void paint(Graphics g) {
        
        ImageIcon image = new ImageIcon(getClass().getResource("../../imagenes/diamante-rojo.png"));
        g.drawImage(image.getImage(), X, Y, WIDTH, HEIGHT, null);
    }
    
}
