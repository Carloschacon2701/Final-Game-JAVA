/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


/**
 *
 * @author Carlos Daniel
 */
public class Menu {
    public int direccion = 0;
    int estadoMenu =0;

    
    public void paint(Graphics g){
        Font fuente = new Font("ROBOTO", Font.BOLD, 40 );
        Font fuente2 = new Font("ROBOTO", Font.BOLD, 30 );
        Font fuente3 = new Font("ROBOTO", Font.BOLD, 17 );
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("../imagenes/menu.jpg"));
        g.drawImage(imagen.getImage(), 0, 0, 600, 600, null);
        
        if(estadoMenu==0){
           opciones(g, fuente, fuente2);
        }
        if(estadoMenu == 1){
            instrucciones(g, fuente, fuente3);
        }
        if(estadoMenu == 2){
            creditos(g, fuente, fuente3);
        }
       
    }
    
    public void opciones(Graphics g, Font fuente, Font fuente2){
        g.setColor(Color.WHITE);

        g.setFont(fuente);
        g.drawString("Multiverso de Clasicos", 80, 150);
        
        g.setFont(fuente2);
        g.drawRoundRect(150, 265, 280, 200, 20, 20);
        
        g.drawString("JUGAR", 230, 300);
        if(direccion == 0){
            g.drawString(">", 210, 300);
        }
        
        g.drawString("INTRUCCIONES", 180, 350);
            if(direccion == 1){
              g.drawString(">", 160, 350);
            }
            
        g.drawString("CREDITOS", 210, 400);
            if(direccion == 2){
              g.drawString(">", 190, 400);
            }
            
        g.drawString("SALIR", 240, 450);
            if(direccion == 3){
              g.drawString(">", 220, 450);
        }
    }
    
    public void instrucciones(Graphics g, Font fuente, Font fuente2){
        g.setColor(Color.WHITE);
        
        g.setFont(fuente);
        g.drawString("Instrucciones", 160, 80);
        
        g.setFont(fuente2);
        g.drawString("1- Ingresar tu nombre y selecciona a chica fuego o agua", 40, 120);
        g.drawString("2- Chica juego se mueve con A,W,S,D", 40, 170);
        g.drawString("3- Chico agua se mueve con las teclas direccionales", 40, 220);
        g.drawString("4- Si eres de agua no puedes caer en lava, y viceversa", 40, 270);
        
    }
    
    public void creditos(Graphics g, Font fuente, Font fuente2){
        g.setColor(Color.WHITE);
        
        g.setFont(fuente);
        g.drawString("Creditos", 230, 80);
        
        g.setFont(fuente2);
        g.drawString("Creador: Carlos Daniel Chacon Mendez", 40, 120);
        g.drawString("Cedula: 30.201.599", 40, 170);
        g.drawString("Seccion: 1", 40, 220);
        g.drawString("Unidad Curricular: Programacion 1", 40, 270);
        
    }
    

    
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            direccion ++;
            if(direccion > 3){
                direccion=0;
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_UP){
            direccion --;
            
            if(direccion < 0){
                direccion=3;
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if(direccion == 1){
                
                estadoMenu=1;
            }
            else if(direccion ==2){
                estadoMenu=2;
            }
            else if(direccion == 3){
                System.exit(0);
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
            estadoMenu=0;
        }

    }

}
