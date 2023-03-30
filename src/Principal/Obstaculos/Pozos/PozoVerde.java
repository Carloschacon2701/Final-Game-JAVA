/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Obstaculos.Pozos;

import static Principal.Obstaculos.Pozos.Pozos.HEIGHT;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Daniel
 */
public class PozoVerde extends Pozos {

    public PozoVerde(int x, int y, int WIDTH) {
        super(x, y, WIDTH);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("../../../Imagenes/pozoVerde.png"));
        g.drawImage(imagen.getImage(), X, Y, WIDTH, HEIGHT, null);
    }
    
}
