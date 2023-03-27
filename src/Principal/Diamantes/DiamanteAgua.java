package Principal.Diamantes;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Carlos Daniel
 */
public class DiamanteAgua extends Diamantes{

    public DiamanteAgua(int x, int y) {
        super(x, y);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon image = new ImageIcon(getClass().getResource("../../imagenes/diamante-azul.png"));
        g.drawImage(image.getImage(), X, Y, WIDTH, HEIGHT, null);
    }
    
    
}
