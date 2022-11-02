
import GUI.CapturaNombres;
import controladorCivitas.Controlador;
import civitas.CivitasJuego;
import GUI.Vista;
import GUI.CivitasView;
import GUI.Dado;
import java.awt.Frame;
import java.util.ArrayList;


public class TestP5 {
    
    public static void main(String[] args) {
        CivitasView vista = new CivitasView();
        CapturaNombres captura_nombres = new CapturaNombres(vista, true);
        ArrayList<String> nombres = new ArrayList();
        nombres = captura_nombres.getNombres();
        
        Dado.createInstance(vista);

        CivitasJuego juego = new CivitasJuego(nombres, false);
        Controlador controlador = new Controlador(juego,vista);
        
        vista.actualiza();
        controlador.juega();
    }
}

