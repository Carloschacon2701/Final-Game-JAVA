/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal.Obstaculos.Barras;

import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Daniel
 */
public class BarraBoton extends Barras {

    public BarraBoton(int x, int y) {
        super(x, y);
    }

    @Override
    public void paint(Graphics g) {
       ImageIcon image = new ImageIcon(getClass().getResource("../../../imagenes/ladrillo.png"));
       g.drawImage(image.getImage(), X, Y, WIDTH, HEIGHT, null);
       moverse();
    }
    
    public void moverse(){    
        if(Y!=230){
            if(active){
              Y+=2;
            }   
        }else{
            active=false;
        }
        

    }
}
