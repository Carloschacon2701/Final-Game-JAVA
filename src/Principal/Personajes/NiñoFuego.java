package Principal.Personajes;


import Principal.Obstaculos.Pozos.PozoVerde;
import Principal.Obstaculos.Pozos.PozoAgua;
import Principal.Diamantes.DiamanteFuego;
import Principal.Juego;
import Principal.Obstaculos.Cubo.Cubo;
import Principal.Puertas.PuertaFuego;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class NiñoFuego extends Personaje{
    
    public NiñoFuego(Juego j) {
        super(j);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon image = new ImageIcon(getClass().getResource("../../Imagenes/boy.png"));
        g.drawImage(image.getImage(), x, y, WIDTH, HEIGHT, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()== KeyEvent.VK_UP){
            if(!saltando && !cayendo) {
                saltando=true;
                gravedad= 4.0;
            }

        }
        
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            if(x<=0 || choqueIzquierda() || choqueCubo()){
                x=x;
            }
            else if(choqueIzquierda()){
                x=b.WIDTH + b.X;
            }

            else if(x>0 && !choqueIzquierda()){
                x-=velocidad+5;
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            if(x>=600 || choqueDerecha() || choqueCubo()){
                x=x;
            }
            else if(choqueDerecha()){
                x= b.WIDTH + b.Y;
            }
            else if(x<600 && !choqueDerecha() || saltando ){
                x+=velocidad+5;
            }
        }
        
        detectarDiamantes();
        botonPressed();
        j.perdidaNivel();
    }

    @Override
    public boolean detectarPozo() {
        for(int i=0; i< j.ListaPozos.size(); i++){
            if(getBoundsBottom().intersects(j.ListaPozos.get(i).getBounds())){
                if(j.ListaPozos.get(i) instanceof PozoAgua){
                    return true;
                }
                else if(j.ListaPozos.get(i) instanceof PozoVerde){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }


    @Override
    public void detectarDiamantes() {
        for(int i=0; i< j.ListaDiamantes.size(); i++){
            if(getBoundsBottom().intersects(j.ListaDiamantes.get(i).getBounds())){
                if(j.ListaDiamantes.get(i) instanceof DiamanteFuego){
                    j.diamantesObtenidos+=1;
                    j.ListaDiamantes.remove(i);
                }
            }
        }
    }

    @Override
    public boolean detectarPuerta() {
        for(int i=0; i< j.ListaPuertas.size(); i++){
            if(getBoundsBottom().intersects(j.ListaPuertas.get(i).getBounds())){
                if(j.ListaPuertas.get(i) instanceof PuertaFuego){
                   return true;
                }
            }
        }
        return false;
    }
    
    
}
