package civitas;

import java.util.ArrayList;

/**
 *
 * @author Marina Jun Carranza Sánchez
 */
public class Jugador implements Comparable<Jugador>{
    static protected int CasasPorHotel = 4,
                         CasasMax = 4, HotelesMax = 4;
    static private float PasoPorSalida = 1000;

    private float SaldoInicial = 7500;
    private int casillaActual;
    protected String nombre;
    public float saldo;
    private boolean puedeComprar;
    ArrayList<CasillaCalle> propiedades;
    
    public Jugador(String nombre){
        this.nombre = nombre;
        this.casillaActual = 0;
        this.saldo = SaldoInicial;
        this.puedeComprar = true;
        this.propiedades = new ArrayList<CasillaCalle>();
    }
    
    protected Jugador(Jugador otro){
        this.nombre = otro.nombre;
        this.casillaActual = otro.casillaActual;
        this.saldo = otro.saldo;
        this.puedeComprar = otro.puedeComprar;
        this.propiedades = otro.propiedades;
    }
    
    int cantidadCasasHoteles(){
        int sum = 0;
        for (CasillaCalle propiedad: this.propiedades)
            sum += propiedad.cantidadCasasHoteles();
        
        return sum;
    }
    @Override
    public int compareTo(Jugador otro){
        return Float.compare(saldo, otro.saldo);
    }
    
    public boolean comprar(CasillaCalle titulo){
        boolean result = false;
        float precio;
        if (this.puedeComprar){
            precio = titulo.getPrecioCompra();
            
            if (this.puedoGastar(precio)){
                result = titulo.comprar(this);
                this.propiedades.add(titulo);
                Diario.getInstance().ocurreEvento(nombre + " compra la propiedad " + titulo.getNombre());
                this.puedeComprar = false;
            }else
                Diario.getInstance().ocurreEvento(nombre + " no tiene saldo suficiente para comprar la propiedad " + titulo.getNombre());
        }
        return result;
        
    }
    
    boolean construirCasa(int ip){
        boolean res = false;
        boolean existe = this.existeLaPropiedad(ip);
        CasillaCalle propiedad;
        boolean puedoEdificar;
        if (existe){
            propiedad = this.propiedades.get(ip);
            puedoEdificar = this.puedoEdificarCasa(propiedad);
            
            if (puedoEdificar){
                propiedad.construirCasa(this);
                res = true;
                Diario.getInstance().ocurreEvento(nombre + " construye una casa en la propiedad " + ip);
            }
        }
        return res;
    }
    
    boolean construirHotel(int ip){
        boolean result = false;
        CasillaCalle propiedad;
        boolean puedoEdificarHotel;
        if (this.existeLaPropiedad(ip)){
            propiedad = this.propiedades.get(ip);
            puedoEdificarHotel = this.puedoEdificarHotel(propiedad);
            
            if (puedoEdificarHotel){
                result = propiedad.construirHotel(this);
                propiedad.derruirCasas(this.getCasasPorHotel(), this);
                Diario.getInstance().ocurreEvento(nombre + " contruye un hotel en la propiedad " + ip);
            }
            
        }
        return result;
    }
    
    boolean enBacarrota(){
        boolean ok = false;
        if (saldo < 0)
            ok = true;
        return ok;
    }
    
    private boolean existeLaPropiedad(int ip){
        boolean ok = false;
        if (ip < propiedades.size() && ip >= 0)
            ok = true;
        return ok;
    }
    
    int getCasasMax(){
        return CasasMax;
    }
    
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
    
    public int getCasillaActual(){
        return casillaActual;
    }
    
    int getHotelesMax(){
        return HotelesMax;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    public ArrayList<CasillaCalle> getPropiedades(){
        return propiedades;
    }
    
    boolean getPuedeComprar(){
        return puedeComprar;
    }
    
    
    public float getSaldo(){
        return saldo;
    }
    
    boolean modificarSaldo(float cantidad){
        saldo += cantidad;
        if (cantidad < 0)
            Diario.getInstance().ocurreEvento("Se decrementa en " + cantidad +  " el saldo de " + nombre);
        else
            Diario.getInstance().ocurreEvento("Se incrementa en " + cantidad +  " el saldo de " + nombre);

        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        casillaActual = numCasilla;
        puedeComprar = false;
        Diario.getInstance().ocurreEvento(nombre + " se desplaza a la casilla " + casillaActual);
        return true;
    }
    
    boolean paga(float cantidad){
        return modificarSaldo(cantidad * -1);
    }
    
    
    boolean pagaAlquiler (float cantidad){
        return paga(cantidad);
    }
    
    boolean pasaPorSalida(){
        recibe(getPremioPasoSalida());
        Diario.getInstance().ocurreEvento(nombre + "pasa por la casilla de salida");
        return true;
    }
    
    boolean puedeComprarCasilla(){
        puedeComprar = true;
        return puedeComprar;
    }
    
    private boolean puedoEdificarCasa(CasillaCalle propiedad){
        boolean ok = false;
        float precioEdificar = propiedad.getPrecioEdificar();
        if (this.puedoGastar(precioEdificar) && propiedad.getNumCasas() < this.getCasasMax())
            ok = true;
        
        return ok;
    }
    
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        boolean ok = false;
        float precio = propiedad.getPrecioEdificar();
        if (this.puedoGastar(precio)){
            if (propiedad.getNumHoteles() < HotelesMax){
                if (propiedad.getNumCasas() >= this.getCasasPorHotel())
                    ok = true;
            }
        }
        return ok;
    }
    
    private boolean puedoGastar(float precio){
        boolean ok = false;
        if (saldo >= precio)
            ok = true;
        return ok;
    }
    
    boolean recibe(float cantidad){
        boolean ok = modificarSaldo(cantidad);
        return ok;
    }
    
    boolean tieneAlgoQueGestionar(){
        boolean ok = propiedades.isEmpty();
        return ok;
    }
    
    
    public Jugador convertir(){
        return new JugadorEspeculador(this);
    }
    
    public boolean esEspeculador(){
        return false;
    }
    
    @Override
    public String toString(){
        String descrip = null;
        descrip = "\nJugador(a): " + nombre + "\n >Saldo:" + saldo + "\n >Casilla actual: " +
                  casillaActual + "\n >¿Puede comprar? " + puedeComprar + "\n Propiedades:";
    
        for (CasillaCalle p : this.propiedades)
            descrip += p.toString();
        
        return descrip;
    }
    
}
