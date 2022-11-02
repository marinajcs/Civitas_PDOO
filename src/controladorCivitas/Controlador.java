package controladorCivitas;

import GUI.CivitasView;
import civitas.CivitasJuego;
import civitas.GestionInmobiliaria;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;

/**
 *
 * @author mjcs
 */
public class Controlador {
    //private VistaTextual vista;
    private CivitasView vista;
    private CivitasJuego juegoModel;
    
    public Controlador(CivitasJuego juego, CivitasView vista){
        this.vista = vista;
        this.juegoModel = juego;
        vista.setCivitasJuego(juegoModel);
    }
    
    public void juega(){
        OperacionJuego opcionJuego;
        vista.mostrarEventos();
        while(!juegoModel.finalDelJuego()){                
            vista.actualiza();
            vista.pausa();
            opcionJuego = juegoModel.siguientePaso();
            vista.mostrarSiguienteOperacion(opcionJuego);
            if(opcionJuego != OperacionJuego.PASAR_TURNO){
                vista.mostrarEventos();
            }
            
            if(!juegoModel.finalDelJuego()){
                switch(opcionJuego){
                    
                    case COMPRAR:
                            if(vista.comprar() == Respuesta.SÍ)
                                juegoModel.comprar();
                        juegoModel.siguientePasoCompletado(opcionJuego);
                        vista.mostrarEventos();
                        break;
                    case GESTIONAR:
                        int numPropiedad;
                        OperacionInmobiliaria opcion = vista.elegirOperacion();
                        if( opcion != OperacionInmobiliaria.TERMINAR){
                            numPropiedad = vista.elegirPropiedad();
                            GestionInmobiliaria gestion = new GestionInmobiliaria(opcion, numPropiedad);
                            
                            switch(gestion.getOperacion()){
                                
                                case CONSTRUIR_CASA:
                                    juegoModel.construirCasa(numPropiedad);
                                    break;
                                    
                                case CONSTRUIR_HOTEL: 
                                    juegoModel.construirHotel(numPropiedad);
                                    break;
                            }
                        }     
                        juegoModel.siguientePasoCompletado(opcionJuego);
                        vista.mostrarEventos();
                        break;
                }
            }
            else
                vista.actualiza();
        }
    
    }
}
