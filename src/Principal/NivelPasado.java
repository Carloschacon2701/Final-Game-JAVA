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
public class NivelPasado {
    
    Juego j;
    
    public void paint(Graphics g){
        Font fuente = new Font("ROBOTO", Font.BOLD, 40 );
        Font fuente2 = new Font("ROBOTO", Font.BOLD, 20 );
 
        ImageIcon imagen = new ImageIcon(getClass().getResource("../imagenes/menu.jpg"));
        g.drawImage(imagen.getImage(), 0, 0, 600, 600, null);
        
        g.setColor(Color.WHITE);
        g.setFont(fuente);
        g.drawString("Pasaste de Nivel", 80, 250);
        g.drawString("Presiona Enter para seguir", 80, 300); 
    }
    
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            j.nivel+=1;
            j.estado=1;
        }
        

    }
    
}
