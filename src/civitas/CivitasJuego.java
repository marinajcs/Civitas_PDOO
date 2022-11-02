package civitas;

import java.util.ArrayList;
import java.util.Collections;
import GUI.Dado;

/**
 *
 * @author Marina Jun Carranza Sánchez
 */

public class CivitasJuego {
    private int indiceJugadorActual;
    
    private MazoSorpresas mazo = null;
    private Tablero tablero = null;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private EstadoJuego estado = null;
    private GestorEstados gestor = new GestorEstados();
    
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        for (int i = 0; i < nombres.size(); i++){
            Jugador jugador = new Jugador(nombres.get(i));
            jugadores.add(jugador);
        }

        Dado.getInstance().setDebug(debug);
        estado = gestor.estadoInicial();
        indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size());
        mazo = new MazoSorpresas();
        tablero = new Tablero();
        inicializaTablero(mazo);
        inicializaMazoSorpresas();
    }
    
    private void avanzaJugador(){
       Jugador jugActual = this.getJugadorActual();
       int posActual = jugActual.getCasillaActual();
       int tirada = Dado.getInstance().tirar();
       int posNueva = tablero.nuevaPosicion(posActual, tirada);
       Casilla casilla = tablero.getCasilla(posNueva);
       this.contabilizarPasosPorSalida(jugActual);
       jugActual.moverACasilla(posNueva);
       casilla.recibeJugador(this.indiceJugadorActual, jugadores);
    }
    
    public boolean comprar(){
        boolean res;
        Jugador jugActual = this.getJugadorActual();
        int numCasillaActual = jugActual.getCasillaActual();
        Casilla casilla = this.tablero.getCasilla(numCasillaActual);
        res = jugActual.comprar((CasillaCalle)casilla);
        
        return res;
    }
    
    public boolean construirCasa(int ip){
        return jugadores.get(indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
        return jugadores.get(indiceJugadorActual).construirHotel(ip);
    }
    
    private void contabilizarPasosPorSalida(Jugador jugadorActual){
        if (tablero.computarPasoPorSalida())
            jugadorActual.pasaPorSalida();
    }
    
    public boolean finalDelJuego(){
        boolean fin = false;
        for (int i = 0; i < jugadores.size() && !fin; i++)
            if (jugadores.get(i).enBacarrota())
                fin = true;
        
        return fin;
    }

    public int getIndiceJugadorActual() {
        return indiceJugadorActual;
    }

    public Jugador getJugadorActual(){
        return jugadores.get(indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    public Tablero getTablero() {
        return tablero;
    }

    private void inicializaMazoSorpresas(){
        //6 del tipo PAGARCOBRAR    
        mazo.alMazo(new SorpresaPagarCobrar("\nCobra: 50", 50));
        mazo.alMazo(new SorpresaPagarCobrar("\nCobra: 75", 75));
        mazo.alMazo(new SorpresaPagarCobrar("\nCobra: 100", 100));
        mazo.alMazo(new SorpresaPagarCobrar("\nPaga: 25", -25));
        mazo.alMazo(new SorpresaPagarCobrar("\nPaga: 50", -50));
        mazo.alMazo(new SorpresaPagarCobrar("\nPaga: 75", -75));
        
        //4 del tipo PORCASAHOTEL
        mazo.alMazo(new SorpresaPorCasaHotel("\nCobra por cada casa/hotel: 50", 50));
        mazo.alMazo(new SorpresaPorCasaHotel("\nCobra por cada casa/hotel: 75", 75));
        mazo.alMazo(new SorpresaPorCasaHotel("\nPaga por cada casa/hotel: 50", -50));
        mazo.alMazo(new SorpresaPorCasaHotel("\nPaga por cada casa/hotel: 50", -75));
       
    }
    
    private void inicializaTablero(MazoSorpresas mazo){
        //SALIDA[0] añadida en constructor
        
        //PROPIEDAD[1-3] (3)
        tablero.addCasilla(new CasillaCalle("Calle_1",100,50,10));
        tablero.addCasilla(new CasillaCalle("Calle_2",125,60,15));
        tablero.addCasilla(new CasillaCalle("Calle_3",140,75,20));
        
        //SORPRESA[4]
        tablero.addCasilla(new CasillaSorpresa("Sorpresa_1",this.mazo));
        
        //PROPIEDAD[5-7]
        tablero.addCasilla(new CasillaCalle("Calle_4",150,75,25));
        tablero.addCasilla(new CasillaCalle("Calle_5",200,80,35));
        tablero.addCasilla(new CasillaCalle("Calle_6",300,100,40));
        
        //SORPRESA[8]
        tablero.addCasilla(new CasillaSorpresa("Sorpresa_2",this.mazo));
        
        //PROPIEDAD[9]
        tablero.addCasilla(new CasillaCalle("Calle_7",400,110,40));
        
        //PARKING[10]
        tablero.addCasilla(new Casilla("PARKING"));
        
        //PROPIEDAD[11-13]
        tablero.addCasilla(new CasillaCalle("Calle_8",425,120,40));
        tablero.addCasilla(new CasillaCalle("Calle_9",450,125,50));
        tablero.addCasilla(new CasillaCalle("Calle_10",475,125,50));
        
        //SORPRESA[14] 
        tablero.addCasilla(new CasillaSorpresa("Sorpresa_3",this.mazo));
        
        //PROPIEDAD[15-17]
        tablero.addCasilla(new CasillaCalle("Calle_11",500,150,50));
        tablero.addCasilla(new CasillaCalle("Calle_12",525,150,75));
        tablero.addCasilla(new CasillaCalle("Calle_13",550,175,75));
        
        //SORPRESA[18]
        tablero.addCasilla(new CasillaSorpresa("Sorpresa_4",this.mazo));
        
        //PROPIEDAD[19]                                             C  / E / A
        tablero.addCasilla(new CasillaCalle("Calle_14",600,200,100));
        
    }
    
    private void pasarTurno(){
        int n = indiceJugadorActual + 1;
        if (n >= jugadores.size())
            indiceJugadorActual = 0;
        else
            indiceJugadorActual += 1;
    }
    
    public OperacionJuego siguientePaso(){
        Jugador jugActual = this.getJugadorActual();
        OperacionJuego operacion = gestor.siguienteOperacion(jugActual, estado);
        
        if (operacion == OperacionJuego.PASAR_TURNO){
            this.pasarTurno();
            this.siguientePasoCompletado(operacion);
        }else if (operacion == OperacionJuego.AVANZAR){
            this.avanzaJugador();
            this.siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        estado = gestor.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }
    
    public ArrayList<Jugador> ranking(){
        ArrayList<Jugador> ranking = new ArrayList(jugadores);
        Collections.sort(ranking);
        return ranking;
    }
    
    public String mostrarRanking(){
        ArrayList<Jugador> rank = this.ranking();
        String ranking = null;
        
        for (int i = 1; i < 5; i++)
            ranking += "\n" + i + "º) " + rank.get(i);
        
        return ranking;
    }

}
