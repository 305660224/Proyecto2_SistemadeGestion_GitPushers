package GUI.Ejecutables;




import Clientes.Cliente;
import GUI.Ejecutables.*;
import GestionContratosAlquiler.Alquiler;
import Logico.Vehiculos.Estado;
import Logico.Vehiculos.Vehiculo;
import java.time.Year;
import javax.swing.JOptionPane;
import Utils.UtilsFecha;
import java.time.LocalDate;

/**
 *
 * @author denis
 */
public class GestionContratos extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private Vehiculo vehiculo;
    private Cliente cliente;
    
    public GestionContratos(MainFrame mainFrame) {
        initComponents();
        this.mainFrame = mainFrame;
        vehiculo = mainFrame.getBuscarvehiculos_jdialog().getVehiculo();
    }

        private void save(){
        String NumeroAlquiler=txtNumeroAlquiler.getText();
        String ClienteId=txtClienteId.getText();
        String Vehiculo=txtVehiculo.getText();
        LocalDate FechaInicio=UtilsFecha.toLocalDate(txtFechaInicio.getText());
        LocalDate FechaFin=UtilsFecha.toLocalDate(txtFechaFin.getText());
        
        if (FechaInicio.isAfter(FechaFin)||FechaInicio.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(this, "La FECHA del contrato ES INCORRECTA!");
            return ;
        } else {  
        if (mainFrame.getAgregarClientes_Jpanel().getClienteLista().buscarXcedula(ClienteId) == null) {
            JOptionPane.showMessageDialog(this, "NO se encontro el CLIENTE indicado");
            return ;
        } else { 
            cliente = mainFrame.getAgregarClientes_Jpanel().getClienteLista().buscarXcedula(ClienteId);
        if ( mainFrame.getVehiculosHashMap().buscar(Vehiculo) == null) {
            JOptionPane.showMessageDialog(this, "NO se encontro el VEHICULO indicado");
        } else {
            vehiculo =  mainFrame.getVehiculosHashMap().buscar(Vehiculo);
            mainFrame.setContrato(new Alquiler(NumeroAlquiler, cliente, vehiculo, FechaInicio, FechaFin));
            mainFrame.getContratoslista().añadir(mainFrame.getContrato());
            vehiculo.setEstado(Estado.ALQUILADO);
        }
    }
  }      
} 
    
    public void limpiar() {
    txtClienteId.setText("");
    txtClienteNombre.setText("");
    txtFechaFin.setText("");
    txtFechaInicio.setText("");
    txtNumeroAlquiler.setText("");
    txtVehiculo.setText("");  
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JFormattedTextField();
        txtFechaInicio = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtClienteNombre = new javax.swing.JTextField();
        txtNumeroAlquiler = new javax.swing.JFormattedTextField();
        txtVehiculo = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtClienteId = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("numeroAlquiler");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("vehiculo");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("fechaFin");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("fechaInicio");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        txtFechaFin.setBackground(new java.awt.Color(0, 102, 102));
        txtFechaFin.setBorder(null);
        txtFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaFin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinActionPerformed(evt);
            }
        });
        add(txtFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 150, 30));

        txtFechaInicio.setBackground(new java.awt.Color(0, 102, 102));
        txtFechaInicio.setBorder(null);
        txtFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        txtFechaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });
        add(txtFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 150, 30));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cliente Id ");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        txtClienteNombre.setEditable(false);
        txtClienteNombre.setBackground(new java.awt.Color(0, 102, 102));
        txtClienteNombre.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtClienteNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClienteNombre.setBorder(null);
        txtClienteNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteNombreActionPerformed(evt);
            }
        });
        add(txtClienteNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 150, 30));

        txtNumeroAlquiler.setBackground(new java.awt.Color(0, 102, 102));
        txtNumeroAlquiler.setBorder(null);
        txtNumeroAlquiler.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtNumeroAlquiler.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumeroAlquiler.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroAlquiler.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtNumeroAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroAlquilerActionPerformed(evt);
            }
        });
        add(txtNumeroAlquiler, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 30));

        txtVehiculo.setBackground(new java.awt.Color(0, 102, 102));
        txtVehiculo.setBorder(null);
        txtVehiculo.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtVehiculo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAA-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtVehiculo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVehiculo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVehiculoActionPerformed(evt);
            }
        });
        add(txtVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 150, 30));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/Search.png"))); // NOI18N
        jButton2.setMaximumSize(new java.awt.Dimension(60, 60));
        jButton2.setMinimumSize(new java.awt.Dimension(60, 60));
        jButton2.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 60, 60));

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/New.png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, -1, 60));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/Save.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 490, -1, 60));

        txtClienteId.setBackground(new java.awt.Color(0, 102, 102));
        txtClienteId.setBorder(null);
        txtClienteId.setForeground(new java.awt.Color(255, 255, 255));
        txtClienteId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));
        txtClienteId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClienteId.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtClienteId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteIdActionPerformed(evt);
            }
        });
        add(txtClienteId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 150, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Cliente Nombre");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/agregarContrato_Background.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void txtClienteNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteNombreActionPerformed

    private void txtNumeroAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroAlquilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroAlquilerActionPerformed

    private void txtVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVehiculoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtClienteIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteIdActionPerformed
        txtClienteNombre.setText(mainFrame.getAgregarClientes_Jpanel().getClienteLista().buscarXcedula(txtClienteId.getText()).getNombre());
    }//GEN-LAST:event_txtClienteIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JFormattedTextField txtClienteId;
    private javax.swing.JTextField txtClienteNombre;
    private javax.swing.JFormattedTextField txtFechaFin;
    private javax.swing.JFormattedTextField txtFechaInicio;
    private javax.swing.JFormattedTextField txtNumeroAlquiler;
    private javax.swing.JFormattedTextField txtVehiculo;
    // End of variables declaration//GEN-END:variables
}
