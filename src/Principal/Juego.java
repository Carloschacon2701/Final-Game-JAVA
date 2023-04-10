package Principal;


import Principal.Obstaculos.Pozos.*;
import Principal.Diamantes.*;
import Principal.Obstaculos.Barras.*;
import Principal.Obstaculos.Cubo.*;
import Principal.Personajes.*;
import Principal.Puertas.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author Carlos Daniel
 */
public class Juego extends JPanel {
    
   
    public Personaje niño;
    public ArrayList<Diamantes> ListaDiamantes = new ArrayList<>();
    public ArrayList<Pozos> ListaPozos = new ArrayList<>();
    public ArrayList<Bloques> ListaBloques = new ArrayList<>();
    public ArrayList<Puertas> ListaPuertas = new ArrayList<>();
    public ArrayList<Barras> ListaBarras = new ArrayList<>();
    
    public Barras barra;
    public Barras barra2;
    public BarraVertical barraVertical;
    public Boton boton;
    public Boton boton2;
    
    Temporizador temp = new Temporizador();
    
    public Cubo cubo = new Cubo(this);
    
    
    public int diamantesObtenidos= 1;
    Menu menu = new Menu();

    Mapa mapa= new Mapa();
    public int estado = 0;
   
    int columnas=15;
    int filas=19;
    public int nivel=1;
    public String nombre= "";
    int opcion =0;
    //CONSTRUCTOIR
    
    public Juego(){
        
        if(nivel==1){
            ConstruirMapa(ListaBloques, mapa.nivel_1, ListaDiamantes, ListaPozos);
        }
        else if(nivel==2){
            ConstruirMapa(ListaBloques, mapa.nivel_2, ListaDiamantes, ListaPozos);
        }
        
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(estado == 0){ 
                    menu.keyPressed(e); 
                    
                    if(e.getKeyCode() == KeyEvent.VK_ENTER){
                        if(menu.direccion == 0 ){
                            nombre = JOptionPane.showInputDialog(null, "Ingresa Tu nombre");
                            opcion = JOptionPane.showOptionDialog(null, "Selecciona Tu personaje", "Seleccion...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null , new Object[]{"Nino agua", "Nino Fuego"}, "Opcion 1");
                            establecerPersonaje(opcion);
                            estado = 1;
                        }
                    }
                }
                else if(estado==1){
                   niño.keyPressed(e);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        setFocusable(true);
       

    }
    


    public void ConstruirMapa(ArrayList<Bloques> ListaBloques, int[][] mapa, 
                              ArrayList<Diamantes>ListaDiamantes, ArrayList<Pozos>ListaPozos){
        int col=0;
        int fil=0;
        int x =0;
        int y=0;

      
        while(col<columnas && fil<filas){
            
            int coordenada = mapa[fil][col];
            
            if(coordenada==0){
                Bloques bloqueP = new Bloques(this, x, y);
                ListaBloques.add(bloqueP);
            }
            
            col++;
            x+=40;
            
            if(col==columnas){
                col=0;
                x=0;
                fil++;
                y+=29;
           }
        }

        establecerBotonYBarra();
        establecerDiamantes(ListaDiamantes);
        establecerPozos(ListaPozos);
        establecerPuertas(ListaPuertas);
    }
    
    public void establecerPuertas(ArrayList<Puertas>ListaPuertas){
        int y=41;
        int x= 450;
        
        if(nivel==1){
            ListaPuertas.add(new PuertaFuego(x,y));
            ListaPuertas.add(new PuertaAgua(x+50,y));
        }
        if(nivel==2){
            ListaPuertas.add(new PuertaFuego(x-400,y));
            ListaPuertas.add(new PuertaAgua(x-350,y));
        }
    }
    
    public void establecerBotonYBarra(){
        if(nivel==1){
            barra= new BarraBoton(483,200, nivel);
            barra2 = new BarraBoton(42,290, nivel);
            boton2= new Boton(170, 390);
            boton = new Boton(240, 270);
        }
        if (nivel==2){
            barra= new BarraBoton(483,200,nivel);
            barra2 = new BarraBoton(325,91,nivel);
            barraVertical= new BarraVertical(315,265);
            boton2= new Boton(360, 71);
            boton = new Boton(360, 330);
            
            /*BARRAS ESTATICAS*/
            ListaBarras.add(new BarraBoton(380,180, nivel));
            ListaBarras.add(new BarraBoton(180,180, nivel));
        }

    }
    
    public void establecerPozos(ArrayList<Pozos>ListaPozos){
        int x=200;
        int y=515;
        int WIDTH=80;
        if(nivel==1){
            ListaPozos.add(new PozoAgua(x,y, WIDTH));
            ListaPozos.add(new PozoFuego(x+130,y, WIDTH));
            ListaPozos.add(new PozoVerde(x+60, y-114, WIDTH));
        }
        if(nivel==2){
            /*ABAJO*/
            ListaPozos.add(new PozoAgua(x+83,y, WIDTH+40));
            ListaPozos.add(new PozoFuego(x-80,y, WIDTH+40));
            /*arriba*/
            ListaPozos.add(new PozoAgua(x-80,y-84,WIDTH+40));
            ListaPozos.add(new PozoFuego(x+83,y-84,WIDTH+40));
            /*pozo verde*/
            ListaPozos.add(new PozoVerde(x+160, y-290, WIDTH+40));
            ListaPozos.add(new PozoVerde(x-40, y-290, WIDTH+40));
        }
    }
    
    public void establecerPersonaje(int opcion){
        if(opcion==0){
            niño= new NiñaAgua(this);
        }
        else if(opcion ==1){
            niño= new NiñoFuego(this);
        }
    }
    
    public void establecerDiamantes(ArrayList<Diamantes>ListaDiamantes){
        int x=220;
        int y=460;
        
        if(nivel==1){
            ListaDiamantes.add( new DiamanteAgua(x,y));
            ListaDiamantes.add( new DiamanteFuego(x+130,y));
            ListaDiamantes.add( new DiamanteAgua(x+130,y-200));
            ListaDiamantes.add( new DiamanteFuego(x-50,y-200));
            ListaDiamantes.add( new DiamanteAgua(x-130,y-340));
            ListaDiamantes.add( new DiamanteFuego(x+140,y-410));
            ListaDiamantes.add( new DiamanteAgua(x-15,y-410));   
        }
        if(nivel==2){
            /*diamantes de arriba*/
            ListaDiamantes.add( new DiamanteAgua(x+80,y+25));
            ListaDiamantes.add( new DiamanteAgua(x+140,y+25)); 
            ListaDiamantes.add( new DiamanteFuego(x+80,y-60));
            ListaDiamantes.add( new DiamanteFuego(x+140,y-60));
          
            /*diamantes de abajo*/
            ListaDiamantes.add( new DiamanteFuego(x-90,y+25));
            ListaDiamantes.add( new DiamanteFuego(x-30,y+25));
            ListaDiamantes.add( new DiamanteAgua(x-90,y-60));
            ListaDiamantes.add( new DiamanteAgua(x-30,y-60));   
        }
    }
    
    public void perdidaNivel(){
        if(niño.detectarPozo()){
            int opcionFinal = JOptionPane.showOptionDialog(null, "Por favor Seleccione lo que desea hacer: ", "Seleccion...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null , new Object[]{"Reintentar", "Menu Principal", "Salir"}, "Reintentar");
            
            switch(opcionFinal){
                case 0: {
                    reiniciarNivel();
                    break;
                }
                case 1:{
                    estado=0;
                    break;
                }
                case 2:{
                    System.exit(0);
                    break;
                } 
            }
        }
    }
    
    public void nivelGanado(){
        if(niño.detectarPuerta()){
            temp.timer.stop();
            int opcion = JOptionPane.showConfirmDialog(null, "Diamantes: " + diamantesObtenidos + "\n" + "Tiempo: " + temp.minutos + ":"+ temp.segundo + "\n" + "Pasaste al nivel 2", "Muy bien " + nombre, JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
            nivel++;
            limpiarEscenario();
            temp.timer.restart();
            
            ConstruirMapa(ListaBloques, mapa.nivel_2, ListaDiamantes, ListaPozos);
        }
    }
    
    public void limpiarEscenario (){
        ListaBloques.clear();
        ListaPuertas.clear();
        ListaDiamantes.clear();
        ListaPozos.clear();
        niño.x=60;
        niño.y=470;
        temp.reiniciarValores();
    }
    
    public void reiniciarNivel(){
        establecerDiamantes(ListaDiamantes);
        establecerBotonYBarra();
        diamantesObtenidos = 0;
        niño.x=60;
        niño.y=470;
        cubo.X=390;
        cubo.Y=120;
        
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        switch (estado) {
            case 0:
                menu.paint(g);
                break;
            case 1:
                ImageIcon f = new ImageIcon(getClass().getResource("../imagenes/fondo.jpg"));
                g.drawImage(f.getImage(), 0, 0, 590, 590, null);
                /*bloque.paint(g);*/
                
                   
                    barra2.paint(g);
                    if(nivel==2){
                         barraVertical.paint(g);
                    }
                   
                    
                    for(int i=0; i<ListaBloques.size(); i++){
                       ListaBloques.get(i).paint(g);
                    }for(int i=0; i<ListaDiamantes.size(); i++){
                      ListaDiamantes.get(i).paint(g);
                    }for(int i=0; i<ListaPozos.size(); i++){
                      ListaPozos.get(i).paint(g);
                    }for(int i=0; i<ListaPuertas.size(); i++){
                      ListaPuertas.get(i).paint(g);
                    }  
                    for(int i=0; i<ListaBarras.size(); i++){
                        ListaBarras.get(i).paint(g);
                    }
                    
                    if(nivel==1){
                        cubo.paint(g);
                        barra.paint(g);
                    }
                    

                    boton2.paint(g);
                    niño.paint(g);
                    niño.accionSaltarCaer();
                    boton.paint(g);
                    temp.paint(g);
                

                break;
            default:
                break;
        }

        g.dispose();
    }
    

    

}
