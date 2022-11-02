package civitas;

import java.util.ArrayList;
import GUI.Dado;

/**
 *
 * @author Marina Jun Carranza Sánchez
 */
public class Civitas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // 1) Llamar 100 veces a quienEmpieza() si hay 4 jugadores, halla total cada valor
        int n_jug = 4, n;
        int[] opciones = new int[n_jug];
        
        
        for (int i = 0; i < n_jug; i++)
            opciones[i] = 0;
        
        for (int i = 0; i < 100; i++){
            n = Dado.getInstance().quienEmpieza(n_jug);
            opciones[n]++;
        }
           
        for (int i = 0; i < n_jug; i++)
            System.out.println("Jugador " + (i+1) + " empieza " + opciones[i] + " veces.");
    
        // 2) Comprobar setDebug y tirar
        Dado.getInstance().setDebug(true);
        for (int i = 0; i < 5; i++){
            Dado.getInstance().tirar();
            System.out.println(Dado.getInstance().getUltimoResultado());
        }
        
        // 3) Probar getUltimoResulado()
        Dado.getInstance().setDebug(false);
        for (int i = 0; i < 5; i++){
            Dado.getInstance().tirar();
            System.out.println(Dado.getInstance().getUltimoResultado());
        }
        
        // 4) Mostrar valores de tipos enumerados 
        MazoSorpresas mazo1 = new MazoSorpresas();
        
        Casilla c1 = new CasillaCalle("Calle_1", 200, 300, 500);
        Casilla desc1 = new Casilla("Descanso_1");
        Casilla sorp1 = new CasillaSorpresa("Sorpresa_1", mazo1);

        System.out.println(c1.toString());
        System.out.println(desc1.toString());
        System.out.println(sorp1.toString());
        
        // 5) Probar Tablero
        Tablero tab = new Tablero();
        Casilla c2 = new CasillaCalle("Calle_2", 325, 450, 600);
        Casilla c3 = new CasillaCalle("Calle_3", 175, 280, 323);

        tab.addCasilla(c1);
        tab.addCasilla(c2);
        tab.addCasilla(c3);
        
        // 6) Calle más cara, más barata, precio medio
        float prec_med, sum = 0, min = 999999, max =0; 
        int n_cara = 0, n_barata = 0, n_calles = 3;
        
        for (int i = 1; i <= n_calles; i++){
            if (((CasillaCalle)tab.getCasilla(i)).getPrecioAlquilerCompleto() < min){
                n_barata = i;
                min = ((CasillaCalle)tab.getCasilla(i)).getPrecioAlquilerCompleto();
            }
            
            if (((CasillaCalle)tab.getCasilla(i)).getPrecioAlquilerCompleto() > max){
                n_cara = i;
                max = ((CasillaCalle)tab.getCasilla(i)).getPrecioAlquilerCompleto();
            }
            
            sum += ((CasillaCalle)tab.getCasilla(i)).getPrecioAlquilerCompleto();
        }
        
        prec_med = sum/n_calles;
        String calle_cara = tab.getCasilla(n_cara).toString();
        String calle_barata = tab.getCasilla(n_barata).toString();
        System.out.println("Calle más barata:\n" + calle_barata + "\n\nCalle más cara:\n" + calle_cara + "\n\nMedia precio: " + prec_med);
    
        
        // 7) Métodos Diario
        Diario diario = new Diario();
        diario.ocurreEvento("Ocurre evento X");
        diario.ocurreEvento("Ocurre evento Y");

        if (diario.eventosPendientes())
            System.out.println("\nEventos pendientes por leer: " + diario.getEventos().size());
        else
            System.out.println("\nNo hay eventos pendientes por leer.");

        System.out.println(diario.leerEvento());
        if (diario.eventosPendientes())
            System.out.println("\nEventos pendientes por leer: " + diario.getEventos().size());
        else
            System.out.println("\nNo hay eventos pendientes por leer.");

        System.out.println(diario.leerEvento());
        if (diario.eventosPendientes())
            System.out.println("\nEventos pendientes por leer: " + diario.getEventos().size());
        else
            System.out.println("\nNo hay eventos pendientes por leer.");
        
        // 8) Tirar dado y avanzar posiciones en tablero
        for (int i = 0; i < 5; i++){
            int tirada = Dado.getInstance().tirar();
            System.out.println("\nPartiendo de la casilla " + 0 + ", sale un " + tirada + " en el dado. Se avanza a la casilla: " + tab.nuevaPosicion(0, tirada));
        }
        
    }
    
    
}
