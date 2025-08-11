
package GUI.Ejecutables;
import GUI.Ejecutables.Clientes.GestionClientes;
import GUI.Ejecutables.Empleados.GestionEmpleados;
import GUI.Ejecutables.Vehiculos.GestionVehiculos;
import GUI.Ejecutables.Contratos.GestionContratos;
import GUI.Ejecutables.Reservas.GestionReservas;

/**
 * 11/08/2025
 * @author denis
 */
public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    
    //Inicializacion de Jpanels
    MenuPrincipal menuprincipal_jpanel = new MenuPrincipal();
    GestionEmpleados gestionempleado_jpanel = new GestionEmpleados();
    GestionClientes gestioncliente_jpanel = new GestionClientes();
    GestionVehiculos gestionvehiculo_jpanel = new GestionVehiculos();
    GestionContratos gestioncontrato_jpanel = new GestionContratos();
    GestionReservas gestionreserva_jpanel = new GestionReservas();
    
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();        
    //Inicializar tamaño de Jpanels
    menuprincipal_jpanel.setSize(1000, 600);
    gestionempleado_jpanel.setSize(1000, 600);
    gestioncliente_jpanel.setSize(1000, 600);
    gestionvehiculo_jpanel.setSize(1000, 600);
    gestioncontrato_jpanel.setSize(1000, 600);
    gestionreserva_jpanel.setSize(1000, 600);
    
    //Inicio por default
        add(menuprincipal_jpanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    // End of variables declaration//GEN-END:variables
}
