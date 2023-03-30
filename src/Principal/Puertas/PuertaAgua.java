/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Puertas;

import static Principal.Puertas.Puertas.HEIGHT;
import static Principal.Puertas.Puertas.WIDTH;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Daniel
 */
public class PuertaAgua extends Puertas{
    
    public PuertaAgua( int x, int y) {
        super( x, y);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("../../imagenes/puertaAgua.png"));
        g.drawImage(imagen.getImage(), X, Y, WIDTH, HEIGHT, null);
    }
}
