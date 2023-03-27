package Principal.Personajes;


import Principal.Bloques;
import Principal.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public abstract class Personaje {
    
    
    static final int WIDTH= 30;
    static final int HEIGHT= 40;
    static final  int velocidad=5;
    public Juego j;
    Bloques b;
    public int x=430;
    public int y=170;
    public double gravedad= 0.0;
    public boolean saltando= false;
    public boolean cayendo= false;
    
    
    public Personaje(Juego j){
        this.j= j;
    }
    
    public abstract void paint(Graphics g);
    
 
    public abstract void keyPressed(KeyEvent e);
    
    public boolean choqueArriba(){
        for(int i=0; i<j.ListaBloques.size();i++){
            if(j.ListaBloques.get(i).getBounds().intersects(getBoundsTop())){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean choqueAbajo(){
        for(int i=0; i<j.ListaBloques.size();i++){
            if(getBoundsBottom().intersects(j.ListaBloques.get(i).getBounds())){
               return true;
            }
        }
        if(getBoundsBottom().intersects(j.cubo.getBounds()) || getBoundsBottom().intersects(j.barra.getBounds())){
            return true;
        }

        return false;
        
    }
    
    public boolean choqueIzquierda(){
        for(int i=0; i<j.ListaBloques.size();i++){
            if(j.ListaBloques.get(i).getBounds().intersects(getBoundsLeft())){
                return true;
            }
        }
        return false ;
    }
    
    public boolean choqueDerecha(){
         for(int i=0; i<j.ListaBloques.size();i++){
            if(j.ListaBloques.get(i).getBounds().intersects(getBoundsRight())){
                return true;
            }
        }
        return false ;
    }
    
    public boolean choqueCubo(){
        if(j.cubo.getBounds().intersects(getBounds())){
            return true;
        }
        return false;
    }
    
   public void botonPressed(){
        if(j.boton.getBounds().intersects(getBounds())){
            j.barra.active=true;
        }
       
   }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y, WIDTH, HEIGHT);
    }
    
    public Rectangle getBoundsTop(){
        return new Rectangle(x+10,y,WIDTH-20,5);
    }
    
    public Rectangle getBoundsBottom(){
        return new Rectangle(x+10,y+HEIGHT-5,WIDTH-20,5);
    }
    
    public Rectangle getBoundsLeft(){
        return new Rectangle(x,y+10,5,HEIGHT-20);
    }
    
    public Rectangle getBoundsRight(){
        return new Rectangle(x+WIDTH-5,y+10,5, WIDTH-20);
    }
    
    public void accionSaltarCaer(){
        if(saltando){
            if(choqueArriba()){
                saltando=false;
                gravedad=0.0;
                cayendo=true;
            }
            else{
                
               gravedad-=0.1;
               y -= (int) gravedad;
               if(gravedad<=0.0){
                  saltando=false;
                  cayendo=true;
                }     
            }   
        }
        
        if(cayendo){
            gravedad+=0.1;
            y+= (int)gravedad;
        }
        
        if(choqueAbajo()){
            y=y;
            cayendo=false;
        }else{
            if(!cayendo && !saltando){
                gravedad=0.0;
                cayendo=true;
            }
        }
    }
    

    
   public abstract boolean detectarPozo();
   
   public abstract void detectarDiamantes();
   
   public abstract boolean detectarPuerta();
    
}
