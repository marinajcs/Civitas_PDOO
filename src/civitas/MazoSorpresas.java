package civitas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author marina
 */
public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada, debug;
    private int usadas;
    
    private void init(){
        sorpresas = new ArrayList<Sorpresa>();
        barajada = false;
        usadas = 0;
    }
    
    MazoSorpresas(){
        init();
        debug = false;
    }
    
    MazoSorpresas(boolean debug){
        init();
        this.debug = debug;
        if (debug)
            Diario.getInstance().ocurreEvento("Estado debug del dado activado");
    }
    
    void alMazo(Sorpresa s){
        if (!barajada)
            sorpresas.add(s);
        
    }
    
    Sorpresa siguiente(){
        if (!barajada || usadas == sorpresas.size()){
            if (!debug)
                Collections.shuffle(sorpresas);
                usadas = 0;
                barajada = true;
        }
        
        usadas++;
        sorpresas.add(sorpresas.remove(0)); //quitar primera y añadir al final
        Sorpresa sorpresa = sorpresas.get(sorpresas.size()-1);

        return sorpresa;        
    }
}
