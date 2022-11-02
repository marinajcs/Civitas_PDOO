package civitas;

/**
 *
 * @author mjcs
 */
public class GestionInmobiliaria {
    private int propiedad;
    private OperacionInmobiliaria operacion;

    public GestionInmobiliaria(OperacionInmobiliaria gest, int ip) {
        this.propiedad = ip;
        this.operacion = gest;
    }

    public int getPropiedad() {
        return propiedad;
    }

    public OperacionInmobiliaria getOperacion() {
        return operacion;
    }
    
    
}
