package Principal;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Carlos Daniel
 */
public class Frame extends JPanel{
    
    private static final int WIDTH = 610;
    private static final int HEIGHT= 590;

    public static void main(String[] args) {
        JFrame ventana= new JFrame();
        Juego juego = new Juego();
        
        ventana.add(juego);
        ventana.setBounds(0, 0, WIDTH, HEIGHT);
        ventana.setTitle("FUEGO Y AGUA");
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        
        while(true){
            try{
                Thread.sleep(10);
            }catch(InterruptedException ex){
                System.out.println(ex.toString());
            }
            juego.repaint();
        }
        

    }

    
}
