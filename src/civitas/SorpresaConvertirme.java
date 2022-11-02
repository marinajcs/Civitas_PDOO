package civitas;

import java.util.ArrayList;

/**
 *
 * @author mjcs
 */
public class SorpresaConvertirme extends Sorpresa{

    SorpresaConvertirme(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    
    @Override
    void aplicarAJugador(int actual, ArrayList<Jugador> todos) {
        informe(actual, todos);
        Jugador jugador_esp = todos.get(actual).convertir();
        todos.set(actual, jugador_esp);
    }
    
}
