package civitas;

import java.util.ArrayList;

/**
 *
 * @author Marina Jun Carranza Sánchez
 */
public class Tablero {
    private ArrayList<Casilla> tablero;
    private boolean porSalida;
    //private Casilla ult_casilla;
    
    public Tablero(){
        tablero = new ArrayList<Casilla>();
        Casilla salida = new Casilla("SALIDA"); 
        addCasilla(salida);
        porSalida = false;
        //ult_casilla = casillas.get(casillas.size()-1);
    }
    
    private boolean correcto(int numCasilla){
        boolean ok = false;
        if (0 < numCasilla && numCasilla < tablero.size())
            ok = true;
        return ok;
    }
    
    boolean computarPasoPorSalida(){
        if (porSalida){
            porSalida = false;
            return true;
        } else
            return porSalida;
    }
    
    void addCasilla(Casilla casilla){
        tablero.add(casilla);
    }
 
    public Casilla getCasilla(int numCasilla){
        if (correcto(numCasilla))
            return tablero.get(numCasilla);
        else
            return null;
        
    }
    
    public ArrayList<Casilla> getCasillas(){
        return tablero;
    }
    
    int nuevaPosicion(int actual, int tirada){
        int nueva_pos = actual + tirada;
        if (nueva_pos >= tablero.size()){
            nueva_pos = nueva_pos % tablero.size();
            porSalida = true;
        }
        return nueva_pos;
    }
    
}
