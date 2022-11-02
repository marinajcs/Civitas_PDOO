package civitas;

import java.util.ArrayList;

/**
 *
 * @author mjcs
 */
public class CasillaSorpresa extends Casilla{
    MazoSorpresas mazo;
    //Sorpresa sorpresa;

    public CasillaSorpresa(String nombre, MazoSorpresas mazo) {
        super(nombre);
        this.nombre = nombre;
        this.mazo = mazo;
        //this.sorpresa = null;
    }
    
    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        Sorpresa sorpresa = mazo.siguiente();
        informe(actual, todos);
        sorpresa.aplicarAJugador(actual, todos);
    }
    
    @Override
    public String toString(){
        String descrip;
        descrip = "\\nSORPRESA: " + this.nombre;
        
        return descrip;
    }
}
