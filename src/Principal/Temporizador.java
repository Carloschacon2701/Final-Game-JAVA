/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Carlos Daniel
 */
public class Temporizador {
    int milisegundos=0;
    int segundo=0;
    int minutos=0;
    Timer timer;
    
    
    
    public Temporizador(){
        timer = new Timer(1 ,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarTiempo();
            }
        }); 
        timer.start();
    }
    
    public void iniciarTiempo(){
        actualizarTiempo();
    }

    private void actualizarTiempo() {
       milisegundos ++;
       
       if(milisegundos ==100){
           milisegundos=0;
           segundo++;
       }
       
       if(segundo == 60){
           segundo=0;
           minutos++;
       }
       
    }
    
    public void reiniciarValores(){
        milisegundos=0;
        segundo=0;
        minutos=0;
        
    }
    
    public void paint(Graphics g) {
        Font score= new Font("ARIAL", Font.BOLD, 20);
        g.setFont(score);
        g.setColor(Color.YELLOW);
       if(minutos==0){
                g.drawString("00:" + (segundo<10 ? "0" + segundo : segundo) , 270, 50);
       }
            else if(minutos>0){
                g.drawString("0"+ minutos +":" + (segundo<10 ? "0" + segundo : segundo), 270, 50);
            }
    }
    
    
}
