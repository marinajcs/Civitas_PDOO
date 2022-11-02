
import civitas.CasillaCalle;
import civitas.Jugador;


/**
 *
 * @author marin
 */
public class TestP4 {
    public static void main(String[] args) {
        /* Para probar, hacer public temporalmente: 
        constructor de Jugador, constructor CasillaCalle, convertir, comprar
        */        
        Jugador jugador = new Jugador("Pepa");
        CasillaCalle propiedad = new CasillaCalle("Calle", 100, 200, 50);
        boolean res = jugador.comprar(propiedad);
        System.out.print(jugador.toString());
        
        Jugador jugador_esp = jugador.convertir();
        System.out.print(jugador_esp.toString());
       
    }

}
