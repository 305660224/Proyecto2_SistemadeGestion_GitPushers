
package GUI.Ejecutables;
import GUI.Ejecutables.Buscarvehiculos_JDialog;
import Logico.Vehiculos.*;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * 11/08/2025
 * @author denis
 */
public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    
    //Creacion instancia Jpanels/JDiaogs
    private Bienvenida_JPanel bienvenida_jpanel;
    private Agregarvehiculos_JPanel agregarvehiculos_jpanel;
    private Editarvehiculos_JPanel editarvehiculos_jpanel;
    private Buscarvehiculos_JDialog buscarvehiculos_jdialog = new Buscarvehiculos_JDialog(this, false);
    private GestionEmpleados gestionEmpleados_jpanel ;
    private TablaEmpleados tablaEmpleados_jpanel;
    
    //Crear instancias de listas y/o objetos
    private CardLayout cardlayout;
    
    private VehiculosHashMap vehiculosHashMap;
    private Vehiculo vehiculo;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {   
        initComponents();    
    
    //inicializar listas y/o objetos    
    cardlayout = new CardLayout();
    Actual_JPanel.setLayout(cardlayout);
    
    vehiculosHashMap = new VehiculosHashMap();   
    vehiculo=null;    
    
    //inicializar instancia Jpanels/JDiaogs    
    bienvenida_jpanel = new Bienvenida_JPanel();
    agregarvehiculos_jpanel = new Agregarvehiculos_JPanel(this);    
    editarvehiculos_jpanel = new Editarvehiculos_JPanel(this);
    gestionEmpleados_jpanel = new GestionEmpleados(this);
    tablaEmpleados_jpanel = new TablaEmpleados();
    

    
    //Agregar los JPanels al JPanel contenedor
    Actual_JPanel.add(bienvenida_jpanel, "bienvenida");   
    Actual_JPanel.add(agregarvehiculos_jpanel, "agregarvehiculos");   
    Actual_JPanel.add(editarvehiculos_jpanel, "editarvehiculos");    
    Actual_JPanel.add(gestionEmpleados_jpanel,"gestionempleados");
    Actual_JPanel.add(tablaEmpleados_jpanel, "tablaEmpleados_jpanel");
    }
    
    public void buscar() {      
        buscarvehiculos_jdialog.setVehiculosHashMap(vehiculosHashMap);
        buscarvehiculos_jdialog.setVisible(true);
    }

    //GETS

    public Buscarvehiculos_JDialog getBuscarvehiculos_jdialog() {
        return buscarvehiculos_jdialog;
    }
   
    public CardLayout getCardlayout() {
        return cardlayout;
    }
    
    public JPanel getActual_JPanel() {
        return Actual_JPanel;
    }
      
    public VehiculosHashMap getVehiculosHashMap() {
        return vehiculosHashMap;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public GestionEmpleados getGestionEmpleados_jpanel() {
        return gestionEmpleados_jpanel;
    }
    
    


    
    //SETS
    
    public void setVehiculosHashMap(VehiculosHashMap vehiculosHashMap) {
        this.vehiculosHashMap = vehiculosHashMap;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Actual_JPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1015, 625));
        setSize(new java.awt.Dimension(1015, 625));
        getContentPane().setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout Actual_JPanelLayout = new javax.swing.GroupLayout(Actual_JPanel);
        Actual_JPanel.setLayout(Actual_JPanelLayout);
        Actual_JPanelLayout.setHorizontalGroup(
            Actual_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        Actual_JPanelLayout.setVerticalGroup(
            Actual_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );

        getContentPane().add(Actual_JPanel, "card2");

        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorderPainted(false);

        jMenu1.setText("Vehiculos");

        jMenuItem1.setText("Agregar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Editar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Buscar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Empleados");

        jMenuItem4.setText("Agregar Empleado");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reservas");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Alquileres");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    cardlayout.show(Actual_JPanel, "agregarvehiculos");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    cardlayout.show(Actual_JPanel, "editarvehiculos");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
    buscar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       cardlayout.show(Actual_JPanel, "gestionempleados");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Actual_JPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
