package civitas;

import java.util.ArrayList;

/**
 *
 * @author mjcs
 */
public class SorpresaPagarCobrar extends Sorpresa{
    //MazoSorpresas mazo;
    
    SorpresaPagarCobrar(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
        //this.mazo = null;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificarSaldo(this.valor);
    }
}
