package civitas;

/**
 *
 * @author mjcs
 */
public class JugadorEspeculador extends Jugador{
    static protected int FACTOR_ESPECULADOR = 2;
    
    protected JugadorEspeculador(Jugador otro) {
        super(otro);
        this.actualizaPropiedadesPorConversion();
    }
    
    @Override
    boolean paga(float cantidad){
        float cant_esp = cantidad/FACTOR_ESPECULADOR;
        return super.paga(cant_esp);
    }
    
    @Override
    int getCasasMax(){
        int casas_max = super.getCasasMax() * FACTOR_ESPECULADOR;
        return casas_max;
    }
    
    @Override
    int getHotelesMax(){
        int hoteles_max = super.getHotelesMax() * FACTOR_ESPECULADOR;
        return hoteles_max;    
    }
    
    @Override
    public boolean esEspeculador(){
        return true;
    }
    
    @Override
    public String toString(){
        String descrip = "\n--Jugador(a) de abajo es especulador/a--";
        descrip += super.toString();
        
        return descrip;
    }

    void actualizaPropiedadesPorConversion(){
        for (int i = 0; i < this.propiedades.size(); i++)
            this.propiedades.get(i).actualizaPropietarioPorConversion(this);
    }
    
}
