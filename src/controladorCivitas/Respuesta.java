package controladorCivitas;

import java.util.ArrayList;

public enum Respuesta {
    NO,
    SÍ;
    
    
    public static ArrayList<String> respuestas(){
        /*ArrayList<String> respuestas = new ArrayList<String> (){{
            for(int i = 0; i < Respuesta.values().length; i++)
                add(Respuesta.values()[i].toString());
        }};*/
        ArrayList<String> respuestas = new ArrayList<String> (){{
            for (Respuesta value : Respuesta.values()) {
                add(value.toString());
            }
        }};
        
        return respuestas;
        
    }
}
