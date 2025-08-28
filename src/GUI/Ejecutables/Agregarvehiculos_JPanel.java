package GUI.Ejecutables;
import javax.swing.*;
import javax.swing.DefaultComboBoxModel;
import Logico.Vehiculos.*;
import java.time.Year;

/**
 *
 * @author denis
 */
public class Agregarvehiculos_JPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    
    public Agregarvehiculos_JPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        mostrarCategorias();
        limpiar();
    }
    
        private void save(){
        String placa=txtPlaca.getText();
        String marca=(String)txtMarca.getSelectedItem();
        String modelo=txtModelo.getText();
        Year año=Year.parse(txtAño.getText());
        Categoria categoria=(Categoria)txtCategoria.getSelectedItem();
        
        mainFrame.setVehiculo(new Vehiculo(placa, marca, modelo, año, categoria));
        if (año.isAfter(Year.now())||año.isBefore(Year.of(1990))) {
            JOptionPane.showMessageDialog(this, "El año del vehiculo ES INCORRECTO!");
        } else {                       
        if (!mainFrame.getVehiculosHashMap().anadir(mainFrame.getVehiculo())){
            JOptionPane.showMessageDialog(this, "El vehiculo YA EXISTE en el registro!");
            return;
        }}
        mostrarMarcas();
        mainFrame.getBuscarvehiculos_jdialog().setVehiculosHashMap(mainFrame.getVehiculosHashMap());
        mainFrame.getBuscarvehiculos_jdialog().cargartabla();
    }    
    
    private void limpiar(){
        txtAño.setText("");
        txtModelo.setText("");
        txtPlaca.setText("");
        txtCategoria.setSelectedIndex(-1);
        txtMarca.setSelectedIndex(-1);
    }
    
    private void mostrarMarcas(){ 
    DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (String marca:mainFrame.getVehiculosHashMap().getMarcas()) {
            model.addElement(marca);
        }
        txtMarca.setModel(model);
    }
    
    private void mostrarCategorias(){
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Categoria categoria:Categoria.values()){
            model.addElement(categoria);
        }
        txtCategoria.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtModelo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAño = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JFormattedTextField();
        txtCategoria = new javax.swing.JComboBox<>();
        txtMarca = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1015, 625));
        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtModelo.setBackground(new java.awt.Color(0, 102, 102));
        txtModelo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtModelo.setForeground(new java.awt.Color(255, 255, 255));
        txtModelo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtModelo.setBorder(null);
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });
        jPanel1.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, 150, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Placa");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Año");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 370, -1, -1));

        txtAño.setBackground(new java.awt.Color(0, 102, 102));
        txtAño.setBorder(null);
        txtAño.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtAño.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAño.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAño.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoActionPerformed(evt);
            }
        });
        jPanel1.add(txtAño, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 300, 150, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modelo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Marca");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, -1, -1));

        txtPlaca.setBackground(new java.awt.Color(0, 102, 102));
        txtPlaca.setBorder(null);
        txtPlaca.setForeground(new java.awt.Color(255, 255, 255));
        try {
            txtPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAA-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtPlaca.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPlaca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 150, 30));

        txtCategoria.setBackground(new java.awt.Color(0, 102, 102));
        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtCategoria.setForeground(new java.awt.Color(255, 255, 255));
        txtCategoria.setBorder(null);
        jPanel1.add(txtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 150, 30));

        txtMarca.setBackground(new java.awt.Color(0, 102, 102));
        txtMarca.setEditable(true);
        txtMarca.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtMarca.setForeground(new java.awt.Color(255, 255, 255));
        txtMarca.setBorder(null);
        txtMarca.setFocusCycleRoot(true);
        jPanel1.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, 150, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/Save.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 490, -1, 60));

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
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 60, 60));

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/New.png"))); // NOI18N
        jButton3.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, -1, 60));

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Buscar Imagen");
        jButton4.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 390, 30));

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/Edit_Car.png"))); // NOI18N
        jButton5.setPreferredSize(new java.awt.Dimension(60, 60));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 60, 60));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/agregarVehiculo_Background.png"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser seleccionar = new JFileChooser();
        seleccionar.showOpenDialog(seleccionar);
        jLabel7.setIcon(new javax.swing.ImageIcon(seleccionar.getSelectedFile().getAbsolutePath()));;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        mainFrame.getCardlayout().show(mainFrame.getActual_JPanel(), "editarvehiculos");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mainFrame.buscar();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtAño;
    private javax.swing.JComboBox<String> txtCategoria;
    private javax.swing.JComboBox<String> txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JFormattedTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
