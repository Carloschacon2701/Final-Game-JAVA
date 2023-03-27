/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Puertas;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Daniel
 */
public class PuertaFuego extends Puertas {
    
    public PuertaFuego( int x, int y) {
        super( x, y);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("../../imagenes/pozoFuego.png"));
        g.drawImage(imagen.getImage(), X, Y, WIDTH, HEIGHT, null);
    }
}
