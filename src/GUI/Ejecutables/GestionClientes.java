package GUI.Ejecutables;

import Clientes.Cliente;
import Clientes.ClienteArrayList;
import Clientes.ClienteNoEncontradoException;
import Clientes.ClienteReservaException;
import Clientes.Tipo_licencia_Enum;
import Gestion_Reservas.GestionReserva;
import Utils.UtilGuis;
import Utils.UtilsFecha;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.Frame;
import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author denis
 */
public class GestionClientes extends javax.swing.JPanel {
    
    private MainFrame mainFrame;
    private Cliente cliente;
    private ClienteArrayList clienteLista;
    private GestionReserva gestionReserva;

    public void Agregar() {
        String cedula = txtCedula.getText();
        String nombre = txtNombreCompleto.getText();
        String correo = txtCorreoElectronico.getText();
        String telefono = txtTeléfono.getText();
        LocalDate fecha = UtilsFecha.toLocalDate(txtFechaNacimiento.getText());
        Tipo_licencia_Enum licencia = Tipo_licencia_Enum.valueOf(txtTipoLicencia.getSelectedItem().toString());

        cliente = new Cliente(licencia, cedula, nombre, fecha, telefono, correo);

        if (!clienteLista.añadir(cliente)) {
            JOptionPane.showMessageDialog(this, "No se agrego el registro");
            return;
        }

        JOptionPane.showMessageDialog(this, "Registro agregado " + cliente.getNombre(), "Agregado", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean validacionRequerida() {
        return UtilGuis.validateRequiere(txtTipoLicencia, txtCedula, txtNombreCompleto, txtFechaNacimiento, txtTeléfono, txtCorreoElectronico);
    }

    private void limpiarCampos() {
        txtCedula.setValue(null);
        txtNombreCompleto.setValue(null);
        txtTeléfono.setValue(null);
        txtCorreoElectronico.setValue(null);
        txtFechaNacimiento.setValue(null);
        txtTipoLicencia.setSelectedIndex(-1);  // limpia el campo (es d la funcion eliminar)
    }

    private void Actualizar() {
        if (cliente == null) {
            UtilGuis.showErrorMessage(this, "No se ha seleccionado ningun registro", "Error");
        }

        if (!validacionRequerida()) {
            UtilGuis.showErrorMessage(this, "Faltan datos requeridos", "Error");
        }

        Tipo_licencia_Enum licencia = (Tipo_licencia_Enum) txtTipoLicencia.getSelectedItem();
        cliente.setLicencia(licencia);
        cliente.setCorreo(txtCorreoElectronico.getText());
        cliente.setTelefono(txtTeléfono.getText());

    }

    public Cliente getCliente() {
        return cliente;
    }

    public ClienteArrayList getClienteLista() {
        return clienteLista;
    }   

    private void Buscar() {
    // crea y muestra el dialogo
    TablaBuscarCliente dialog = new TablaBuscarCliente(this.mainFrame, true);
    dialog.setListaClientes(clienteLista); // le paso la lista de clientes
    dialog.setVisible(true);

    // recupera el cliente seleccionado
    cliente = dialog.getClienteSeleccionado();

    if (cliente != null) {
        txtCedula.setText(cliente.getCedula());
        txtNombreCompleto.setText(cliente.getNombre());
        txtCorreoElectronico.setText(cliente.getCorreo());
        txtTeléfono.setText(cliente.getTelefono());
        txtFechaNacimiento.setText(cliente.getFechaNacimiento().toString());
        txtTipoLicencia.setSelectedItem(cliente.getLicencia());
    }

    }

    private void Elimina() {
        if (cliente == null) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un cliente para eliminar",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            clienteLista.eliminarCliente(cliente, gestionReserva);
            JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente");
            limpiarCampos();
            cliente = null;

        } catch (ClienteReservaException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClienteNoEncontradoException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public GestionClientes() {
        initComponents();
        clienteLista = ClienteArrayList.getInstanciaClientes();
        this.gestionReserva = GestionReserva.getInstanciaReserva();

        // Cargar  el combo 
        txtTipoLicencia.setModel(new javax.swing.DefaultComboBoxModel<>(
                java.util.Arrays.stream(Tipo_licencia_Enum.values()).map(Enum::name).toArray(String[]::new)
        ));
// Opcional: que arranque sin nada seleccionado
        txtTipoLicencia.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTipoLicencia = new javax.swing.JComboBox<>();
        txtFechaNacimiento = new javax.swing.JFormattedTextField();
        txtNombreCompleto = new javax.swing.JFormattedTextField();
        txtCedula = new javax.swing.JFormattedTextField();
        txtCorreoElectronico = new javax.swing.JFormattedTextField();
        txtTeléfono = new javax.swing.JFormattedTextField();
        btnActualizar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 51));
        jLabel2.setText("Gestión cliente");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 13, 300, 80));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Agregar cliente1.png"))); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 51));
        jLabel3.setText("Cedúla");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 51));
        jLabel4.setText("##/##/####");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 51));
        jLabel5.setText("Teléfono");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 51));
        jLabel6.setText("Agregar");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 51));
        jLabel7.setText("Tipo de licencia");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 51));
        jLabel8.setText("Nombre");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        jPanel1.add(txtTipoLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 190, 40));

        txtFechaNacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        txtFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaNacimientoActionPerformed(evt);
            }
        });
        jPanel1.add(txtFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 210, 40));

        txtNombreCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCompletoActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreCompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 170, 40));

        txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#########"))));
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 150, 40));

        txtCorreoElectronico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoElectronicoActionPerformed(evt);
            }
        });
        jPanel1.add(txtCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 200, 40));

        txtTeléfono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("########"))));
        jPanel1.add(txtTeléfono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 140, 40));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/actualizar2.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, -1, 80));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/lupa1.jpg"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, -1, 80));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Eliminar1.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 51));
        jLabel9.setText("Actualizar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 51));
        jLabel10.setText("Buscar");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 510, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 51));
        jLabel11.setText("Eliminar");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 51));
        jLabel12.setText("Correo");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 51));
        jLabel14.setText("Fecha de nacimiento");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, -1, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/cliente33.jpg"))); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCompletoActionPerformed

    private void txtCorreoElectronicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoElectronicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoElectronicoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        Actualizar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Elimina();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaNacimientoActionPerformed
       String fechaTexto = txtFechaNacimiento.getText();

    try {
        // Convertir a LocalDate (usando tu clase UtilsFecha)
        LocalDate fechaNacimiento = UtilsFecha.toLocalDate(fechaTexto);
        LocalDate hoy = LocalDate.now();

        // Calcular edad
        int edad = java.time.Period.between(fechaNacimiento, hoy).getYears();

        if (edad < 18) {
            JOptionPane.showMessageDialog(this,
                "El cliente debe ser mayor de edad (mínimo 18 años).",
                "Fecha inválida",
                JOptionPane.ERROR_MESSAGE);
            txtFechaNacimiento.setValue(null); // limpia el campo
        } else {
            JOptionPane.showMessageDialog(this,
                "Edad válida: " + edad + " años.",
                "Validación correcta",
                JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(this,
            "Formato de fecha incorrecto. Use dd/MM/yyyy",
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_txtFechaNacimientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtCorreoElectronico;
    private javax.swing.JFormattedTextField txtFechaNacimiento;
    private javax.swing.JFormattedTextField txtNombreCompleto;
    private javax.swing.JFormattedTextField txtTeléfono;
    private javax.swing.JComboBox<String> txtTipoLicencia;
    // End of variables declaration//GEN-END:variables
}
