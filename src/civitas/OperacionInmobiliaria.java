package civitas;

import java.util.ArrayList;

public enum OperacionInmobiliaria {
    CONSTRUIR_CASA,
    CONSTRUIR_HOTEL,
    TERMINAR;
    
    public static ArrayList<String> operaciones(){
        /*ArrayList<String> operaciones = new ArrayList<String> (){{
            for(int i = 0; i < OperacionInmobiliaria.values().length; i++)
                add(OperacionInmobiliaria.values()[i].toString());
        }};*/
        
        ArrayList<String> operaciones = new ArrayList<String> (){{
            for (OperacionInmobiliaria value : OperacionInmobiliaria.values()) {
                add(value.toString() + ",");
            }
        }};
        return operaciones;
    }
    
    public static OperacionInmobiliaria eleccion(int opcion){
        OperacionInmobiliaria eleccion = null;
        switch(opcion){
            case 0:
                eleccion = OperacionInmobiliaria.CONSTRUIR_CASA;
                break;
            case 1:
                eleccion = OperacionInmobiliaria.CONSTRUIR_HOTEL;
                break;
            case 2:
                eleccion = OperacionInmobiliaria.TERMINAR;
        }
        return eleccion;
    }
}
