/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Obstaculos.Pozos;

import Principal.Juego;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Daniel
 */
public class PozoAgua extends Pozos{

    public PozoAgua(int x, int y, int WIDTH) {
        super( x, y, WIDTH);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("../../../Imagenes/pozoAgua.png"));
        g.drawImage(imagen.getImage(), X, Y, WIDTH, HEIGHT, null);
    }
    
}
