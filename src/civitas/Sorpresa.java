package civitas;

import java.util.ArrayList;

/**
 *
 * @author Marina Jun Carranza Sánchez
 */
public abstract class Sorpresa {
    String texto;
    int valor;
    //MazoSorpresas mazo;
    
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);
         
    void informe(int actual, ArrayList<Jugador> todos){
        String evento = ("Se le aplica a " + todos.get(actual).getNombre() + " la siguiente sorpresa:\n" + this.toString());
        Diario.getInstance().ocurreEvento(evento);
    }
    
    @Override
    public String toString(){
        return texto;
    }    
          
}
