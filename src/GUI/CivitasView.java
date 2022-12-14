package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.Jugador;
import civitas.OperacionInmobiliaria;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import javax.swing.JOptionPane;

/**
 *
 * @author marin
 */
public class CivitasView extends javax.swing.JFrame implements Vista{

    CivitasJuego juego;
    
    public CivitasView() {
        initComponents();
    }

    public void setCivitasJuego(CivitasJuego juego){
        this.juego = juego;
        this.ranking.setVisible(false);
        this.ranking_txt.setVisible(false);        
        this.setVisible(true);
    }
    
    public CivitasJuego getCivitasJuego(){
        return this.juego;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        casilla_act = new javax.swing.JLabel();
        casilla_txt = new javax.swing.JTextField();
        sig_op = new javax.swing.JLabel();
        sig_op_txt = new javax.swing.JTextField();
        ranking = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ranking_txt = new javax.swing.JTextArea();
        jugadorPanel = new GUI.JugadorPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title.setText("Civitas");

        casilla_act.setText("Casilla actual");

        casilla_txt.setEditable(false);
        casilla_txt.setText("casilla_txt");

        sig_op.setText("Siguiente operación:");

        sig_op_txt.setEditable(false);
        sig_op_txt.setText("sig_op_txt");
        sig_op_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sig_op_txtActionPerformed(evt);
            }
        });

        ranking.setText("Ranking:");

        ranking_txt.setColumns(20);
        ranking_txt.setRows(5);
        ranking_txt.setText("\n\n\n");
        jScrollPane1.setViewportView(ranking_txt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(title))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sig_op)
                                .addGap(18, 18, 18)
                                .addComponent(sig_op_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174)
                                .addComponent(ranking)
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(casilla_act)
                                .addGap(27, 27, 27)
                                .addComponent(casilla_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(title)
                .addGap(31, 31, 31)
                .addComponent(jugadorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(casilla_act)
                    .addComponent(casilla_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sig_op)
                                    .addComponent(sig_op_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ranking)
                                .addGap(43, 43, 43))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sig_op_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sig_op_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sig_op_txtActionPerformed

    

    @Override
    public void actualiza() {
        jugadorPanel.setJugador(juego.getJugadorActual());
        int posCasilla = juego.getJugadorActual().getCasillaActual();
        casilla_txt.setText(juego.getTablero().getCasilla(posCasilla).toString());
        
        if (this.juego.finalDelJuego()){
            this.ranking_txt.setText(this.juego.mostrarRanking());
            this.ranking.setVisible(true);
            this.ranking_txt.setVisible(true);
        }
    }

    @Override
    public void pausa() {
        int val= JOptionPane.showConfirmDialog(null, "¿Continuar?","Siguiente paso", JOptionPane.YES_NO_OPTION);
        if (val==1)
            System.exit(0);    
    }

    @Override
    public Respuesta comprar() {
        Respuesta res;
        int opcion = 1-JOptionPane.showConfirmDialog(null, "¿Quieres comprar la calle actual?", "Compra", JOptionPane.YES_NO_OPTION);
        
        if (opcion == 0)
            res = Respuesta.NO;
        else
            res = Respuesta.SÍ;
        
        return res;
    }

    @Override
    public OperacionInmobiliaria elegirOperacion() {
        OperacionInmobiliaria op = null;
        GestionarDialog gestionarD = new GestionarDialog(this);
        int opt = gestionarD.getGestion();
        
        switch (opt) {
            case 0:
                op = OperacionInmobiliaria.CONSTRUIR_CASA;
                break;
            case 1:
                op = OperacionInmobiliaria.CONSTRUIR_HOTEL;
                break;
            case 2:
                op = OperacionInmobiliaria.TERMINAR;
                break;
        }        
        
        gestionarD.setVisible(true);
        return op;
    }

    @Override
    public int elegirPropiedad() {
        PropiedadDialog propiedadD = new PropiedadDialog(this, this.juego.getJugadorActual());
        int id = propiedadD.getPropiedad();
        
        return id;
    }

    @Override
    public void mostrarSiguienteOperacion(OperacionJuego sig) {
        this.sig_op_txt.setText(sig.toString());
        
        if(sig == OperacionJuego.AVANZAR){
            Dado.createInstance(this);
        }
        
        repaint();
        revalidate();
    }

    @Override
    public void mostrarEventos(){
        DiarioDialog diarioD;
            if (!Diario.getInstance().getEventos().isEmpty())
                diarioD = new DiarioDialog(this); //crea la ventana del diario    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel casilla_act;
    private javax.swing.JTextField casilla_txt;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.JugadorPanel jugadorPanel;
    private javax.swing.JLabel ranking;
    private javax.swing.JTextArea ranking_txt;
    private javax.swing.JLabel sig_op;
    private javax.swing.JTextField sig_op_txt;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
