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
    
    public Barras barra;
    public Boton boton;
    
    
    public Cubo cubo = new Cubo(this);
    
    
    public int diamantesObtenidos= 0;
    Menu menu = new Menu();
    NivelPasado nivelPasado = new NivelPasado();
    Mapa mapa= new Mapa();
    public int estado = 0;
    
    
    long timer = System.currentTimeMillis();
    int segundo=0;
    int minutos=0;
    int columnas=15;
    int filas=19;
    public int nivel=1;
    String nombre= "";
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
                else if(estado == 2){
                    nivelPasado.keyPressed(e);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        });
        setFocusable(true);


    }
    
    //METODOS
    public void Temporizador(Graphics g){
        Font score= new Font("ARIAL", Font.BOLD, 20);
        g.setFont(score);
        g.setColor(Color.YELLOW);
        
            
            if(System.currentTimeMillis()-timer>1000){
                timer+=1000;
                segundo+=1; 
            }
        
            if(segundo==59){
                segundo=0;
                minutos+=1;
            }
            if(minutos==0){
                g.drawString("00:" + (segundo<10 ? "0" + segundo : segundo) , 270, 50);
            }
            else if(minutos>0){
                g.drawString("0"+ minutos +":" + (segundo<10 ? "0" + segundo : segundo), 270, 50);
            }
        
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
        int x= 470;
        
        if(nivel==1){
            ListaPuertas.add(new PuertaFuego(x,y));
            ListaPuertas.add(new PuertaAgua(x+40,y));
        }
    }
    
    public void establecerBotonYBarra(){
        barra= new BarraBoton(481,200);
        boton= new Boton(100, 470);
    }
    
    public void establecerPozos(ArrayList<Pozos>ListaPozos){
        int x=200;
        int y=515;
        if(nivel==1){
            ListaPozos.add(new PozoAgua(x,y));
            ListaPozos.add(new PozoFuego(x+130,y));
            ListaPozos.add(new PozoVerde(x+60, y-114));
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
    }
    
    public void perdidaNivel(){
        if(niño.detectarPozo()){
            int opcionFinal = JOptionPane.showOptionDialog(null, "Por favor Seleccione lo que desea hacer: ", "Seleccion...", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null , new Object[]{"Reintentar", "Menu Principal", "Salir"}, "Reintentar");
            System.out.print(opcionFinal + "Esta fue la opcion final");
            
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
            estado=2;
        }
    }
    
    public void reiniciarNivel(){
        establecerDiamantes(ListaDiamantes);
        establecerBotonYBarra();
        diamantesObtenidos = 0;
        niño.x=60;
        niño.y=470;
        
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
                for(int i=0; i<ListaBloques.size(); i++){
                    ListaBloques.get(i).paint(g);
                }   for(int i=0; i<ListaDiamantes.size(); i++){
                    ListaDiamantes.get(i).paint(g);
                }   for(int i=0; i<ListaPozos.size(); i++){
                    ListaPozos.get(i).paint(g);
                }   for(int i=0; i<ListaPuertas.size(); i++){
                    ListaPuertas.get(i).paint(g);
                }   cubo.paint(g);
                barra.paint(g);
                niño.paint(g);
                niño.accionSaltarCaer();
                boton.paint(g);
                Temporizador(g);
                break;
            case 2:
                nivelPasado.paint(g);
                break;
            default:
                break;
        }

        g.dispose();
    }
    

    

}
