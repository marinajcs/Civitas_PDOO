package civitas;

import java.util.ArrayList;

/**
 *
 * @author Marina Jun Carranza Sánchez
 */

public class Casilla {
    // Atributos básicos
    String nombre;
    
    //costructores
    Casilla(String nombre){
        this.nombre = nombre;
    }
    
    String getNombre(){
        return nombre;
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("La casilla " + todos.get(actual).getCasillaActual() + " recibe a " + todos.get(actual).getNombre());
    }
    
    void recibeJugador (int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
    }
    
    @Override
    public String toString(){
        String descrip;
        descrip = "\nDESCANSO: " + this.nombre;
        
        return descrip;
    }
    
}