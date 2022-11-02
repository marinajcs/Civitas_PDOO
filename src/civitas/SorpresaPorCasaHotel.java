package civitas;

import java.util.ArrayList;

/**
 *
 * @author mjcs
 */
public class SorpresaPorCasaHotel extends Sorpresa{
    
    SorpresaPorCasaHotel(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificarSaldo(valor);
    }
}
