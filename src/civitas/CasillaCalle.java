package civitas;

import java.util.ArrayList;

/**
 *
 * @author mjcs
 */
public class CasillaCalle extends Casilla{
    static private float FACTORALQUILERCALLE = 1.0f,
                         FACTORALQUILERCASA = 1.0f,
                         FACTORALQUILERHOTEL = 4.0f;
    
    private float precioCompra, precioEdificar, precioBaseAlquiler;
    private int numCasas, numHoteles;
    protected Jugador propietario;

    public CasillaCalle(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        super(nombre);
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.propietario = null;
        numCasas = 0;
        numHoteles = 0;
    }
    
    //Getters
    public String getNombre(){
        return nombre;
    }
    
    float getPrecioCompra(){
        return precioCompra;
    }
    
    float getPrecioEdificar(){
        return precioEdificar;
    }
    
    public int getNumCasas(){
        return numCasas;
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    public int cantidadCasasHoteles(){
        return numCasas + numHoteles;
    }
    
    float getPrecioAlquilerCompleto(){
        return (this.precioBaseAlquiler*(FACTORALQUILERCALLE + numCasas*FACTORALQUILERCASA + numHoteles*FACTORALQUILERHOTEL));
    }
    
    boolean construirCasa(Jugador propietario){
        propietario.paga(precioEdificar);
        this.numCasas++;
        return true;
    }
    
    boolean construirHotel(Jugador propietario){
        propietario.paga(precioEdificar);
        this.numHoteles++;
        return true;
    }
    
     public boolean esEsteElPropietario(Jugador jugador){
        boolean ok = false;
        if (this.propietario == jugador)
            ok = true;
        return ok;
    }
    
    public boolean tienePropietario(){
        boolean ok = false;
        if (this.propietario != null)
            ok = true;
        return ok;
    }
    
    public boolean comprar(Jugador jugador){
        this.propietario = jugador;
        this.propietario.paga(precioCompra);
        return true;
    }
    
    boolean derruirCasas(int n, Jugador jugador){
        boolean ok = false;
        if (esEsteElPropietario(jugador) && numCasas >= n){
            numCasas -= n;
            ok = true;
        }
        return ok;
    }
    
    @Override
    void recibeJugador(int actual, ArrayList<Jugador> todos){
        informe(actual,todos);
        Jugador jugador = todos.get(actual);
        
        if (!this.tienePropietario())
            jugador.puedeComprarCasilla();
        else
            tramitarAlquiler(jugador);
    }
    
    public void tramitarAlquiler(Jugador jugador){
        if (tienePropietario() && !esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(this.precioBaseAlquiler);
            this.propietario.recibe(this.precioBaseAlquiler);
        }
    }
    
    void actualizaPropietarioPorConversion(Jugador jugador){
        this.propietario = jugador;
    }
    
    @Override
    public String toString(){
        String descrip;
        descrip = "\nCALLE " + nombre + "\n >Precios:" + "\n   -Compra: " + precioCompra 
                      + "\n   -Edificar: " + precioEdificar + "\n   -Alquiler base: " + 
                      precioBaseAlquiler + "\n >Casas: " + numCasas + "\n >Hoteles: " + 
                      numHoteles + "\n >Propietario/a: ";
            
            if (propietario != null)
                descrip += propietario.getNombre();
            
        return descrip;
    }
    
}
