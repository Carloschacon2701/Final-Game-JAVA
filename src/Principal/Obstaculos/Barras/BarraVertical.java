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
public class BarraVertical  {
    int X=0;
    int Y=0;
    int WIDTH=14;
    int HEIGHT=75;
    public boolean activeBoton= false;
    
    public BarraVertical(int x, int y) {
        this.X=x;
        this.Y=y;
    }

    
    public void paint(Graphics g) {
        ImageIcon image = new ImageIcon(getClass().getResource("../../../imagenes/barraV.png"));
        g.drawImage(image.getImage(), X, Y, WIDTH, HEIGHT, null);
        moverse();
    }
    
    public void moverse(){
        if(activeBoton && Y>205){
            Y-=2;
        }
        else{
            activeBoton=false;
        }            
    }
    
}
