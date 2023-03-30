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

    public BarraBoton(int x, int y, int nivel) {
        super(x, y, nivel);
    }

    @Override
    public void paint(Graphics g) {
       ImageIcon image = new ImageIcon(getClass().getResource("../../../imagenes/barra.png"));
       g.drawImage(image.getImage(), X, Y, WIDTH, HEIGHT, null);
       moverse();
    }
    
    public void moverse(){  
        
        if(nivel==1){
           if(Y<265){
                if(activeBoton ){
                    Y+=2;
                }   
            }
            else if(Y>266){
                if(Y<350 && activeBoton){
                    Y+=2;
                }
             }
            else{
                activeBoton=false;
            }
        }
        if(nivel==2){
            if(Y==91 && X>242){
                if(activeBoton){
                    X-=2;
                }
            }
            else{
                activeBoton=false;
            }
        }

        
    }
    

}
