package GUI;

import civitas.CasillaCalle;
import civitas.Jugador;
import java.util.ArrayList;

/**
 *
 * @author marin
 */
public class JugadorPanel extends javax.swing.JPanel {

    Jugador jugador;
    
    public JugadorPanel() {
        initComponents();
        this.setVisible(true);
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
        this.nombre_txt.setText(this.jugador.getNombre());
        this.saldo_txt.setText(Float.toString(this.jugador.saldo));
        boolean es_espec = this.jugador.esEspeculador();
        this.espec_txt.setText(Boolean.toString(es_espec));
        
        this.rellenaPropiedades(this.jugador.getPropiedades());
        
        repaint();
        revalidate();
    }
    
    private void rellenaPropiedades (ArrayList<CasillaCalle> lista) {
        // Se elimina la información antigua
        propiedadesPanel.removeAll();
        // Se recorre la lista de propiedades para ir creando sus vistas individuales y añadirlas al panel
        for (CasillaCalle t : lista) {
            PropiedadPanel vistaPropiedad = new PropiedadPanel();
            vistaPropiedad.setPropiedad(t);
            propiedadesPanel.add(vistaPropiedad);
            vistaPropiedad.setVisible(true);
        }
        // Se fuerza la actualización visual del panel propiedades y del panel del jugador
        repaint();
        revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        nombre_txt = new javax.swing.JTextField();
        saldo = new javax.swing.JLabel();
        saldo_txt = new javax.swing.JTextField();
        es_espec = new javax.swing.JLabel();
        espec_txt = new javax.swing.JTextField();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        propiedadesPanel = new javax.swing.JPanel();

        nombre.setText("Nombre");

        nombre_txt.setEditable(false);
        nombre_txt.setText("nombre_txt");

        saldo.setText("Saldo");

        saldo_txt.setEditable(false);
        saldo_txt.setText("saldo_txt");

        es_espec.setText("¿Es especulador/a?");

        espec_txt.setEditable(false);
        espec_txt.setText("espec_txt");
        espec_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espec_txtActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setText("Información de jugador/a:");

        jScrollPane1.setViewportView(propiedadesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(nombre)
                        .addGap(18, 18, 18)
                        .addComponent(nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(saldo)
                        .addGap(27, 27, 27)
                        .addComponent(saldo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(es_espec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(espec_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(title)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(nombre_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saldo)
                    .addComponent(saldo_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(es_espec)
                    .addComponent(espec_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void espec_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espec_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_espec_txtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel es_espec;
    private javax.swing.JTextField espec_txt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombre_txt;
    private javax.swing.JPanel propiedadesPanel;
    private javax.swing.JLabel saldo;
    private javax.swing.JTextField saldo_txt;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
