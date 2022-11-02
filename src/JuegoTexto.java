
import GUI.CapturaNombres;
import GUI.CivitasView;
import GUI.Dado;
import civitas.CivitasJuego;
import controladorCivitas.Controlador;
import java.util.ArrayList;
import GUI.Vista;
import GUI.VistaTextual;
import java.util.Scanner;


/**
 *
 * @author 
 */
public class JuegoTexto {
    
    public static void main(String[] args) {
        
        final int min = 2, max = 4;
        Scanner in = new Scanner (System.in);
        
        ArrayList<String> jugadores = new ArrayList<String>(){
            {
                System.out.println("¿Cuantos jugadores van a jugar?");
                int n_jugadores = in.nextInt();
                while(n_jugadores > min || n_jugadores < max){
                    System.out.println("¿Cuantos jugadores van a jugar?");        
                    n_jugadores = in.nextInt();    
                }
                int contador = 0;
                System.out.println("Introduce el nombre de los jugadores:");
                while(contador < n_jugadores){
                    add(in.next());
                    contador++;
                }
            }
        };
        
        CivitasJuego juego = new CivitasJuego(jugadores, false);
        VistaTextual vista = new VistaTextual(juego);
       // Dado.createInstance(vista);

    }

}