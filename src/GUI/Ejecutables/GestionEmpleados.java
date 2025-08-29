package GUI.Ejecutables;

import GUI.Ejecutables.*;
import GestiónEmpleados.Empleado;
import GestiónEmpleados.GestorEmpleados;
import Utils.UtilGuis;
import java.time.LocalDate;
import Utils.UtilGuis;
import Utils.UtilsFecha;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author denis
 */
public class GestionEmpleados extends javax.swing.JPanel {

    private Empleado empleado;
    private GestorEmpleados gestorEmpleados;
    private DefaultTableModel model;
    private MainFrame mainFrame;

    public GestionEmpleados(MainFrame mainFrame) {
        gestorEmpleados = new GestorEmpleados();
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void clear() {
        txtCedula.setText("");
        txtNombre.setText("");
        txtFecha.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtPuesto.setText("");
        txtSalario.setText("");

        empleado = null;
    }

    private void delete() {
        if (empleado == null) {
            UtilGuis.showErrorMessage(this, "Debe especificar cuál empleado eliminar", "Error");
            return;
        }

        if (!gestorEmpleados.remover(empleado)) {
            JOptionPane.showMessageDialog(this, "No se eliminó el registro del empleado");
            return;
        }

        empleado = null;
        clear();
    }

    private void search() {
        mainFrame.getTablaEmpleados_jpanel().setGestorEmpleados(gestorEmpleados);
        mainFrame.getTablaEmpleados_jpanel().loadTable();
        mainFrame.getCardlayout().show(mainFrame.getActual_JPanel(), "tablaEmpleados_jpanel");

        empleado = mainFrame.getTablaEmpleados_jpanel().getEmpleado();

        if (empleado == null) {
            clear();
        } else {
            showDataEmpleado();
        }
    }

    private void showDataEmpleado() {
        txtCedula.setText(empleado.getCedula());
        txtNombre.setText(empleado.getNombre());
        txtFecha.setText(UtilsFecha.toString(empleado.getFechaNacimiento()));
        txtTelefono.setText(empleado.getTelefono());
        txtCorreo.setText(empleado.getCorreo());
        txtPuesto.setText(empleado.getPuesto());
        txtSalario.setText(String.valueOf(empleado.getSalario()));
    }

    private void add() {
        if (!UtilGuis.validateRequiere(txtCedula, txtNombre, txtFecha, txtTelefono, txtCorreo, txtPuesto, txtSalario)) {
            UtilGuis.showErrorMessage(this, "Faltan datos requeridos", "Error");
            return;
        }

        try {
            String cedula = txtCedula.getText().trim();
            String nombre = txtNombre.getText().trim();
            LocalDate fechaNacimiento = UtilsFecha.toLocalDate(txtFecha.getText().trim());
            String telefono = txtTelefono.getText().trim();
            String correo = txtCorreo.getText().trim();
            String puesto = txtPuesto.getText().trim();
            double salario = Double.parseDouble(txtSalario.getText().trim());

            empleado = new Empleado(cedula, nombre, fechaNacimiento, telefono, correo, puesto, salario);

            if (!gestorEmpleados.añadir(empleado)) {
                JOptionPane.showMessageDialog(this, "No se agregó el registro  , Verifique si ya existe un empleado con esa cédula");
                return;
            }

            UtilGuis.showMessage(this, "Registro agregado: " + empleado.getNombre(), "Agregado");
            // Aquí podrías actualizar alguna vista o tabla si lo necesitas
        } catch (NumberFormatException e) {
            UtilGuis.showErrorMessage(this, "El salario debe ser un número válido.", "Error de formato");
        } catch (IllegalArgumentException e) {
            UtilGuis.showErrorMessage(this, e.getMessage(), "Error de validación");
        } catch (Exception e) {
            UtilGuis.showErrorMessage(this, "Error inesperado: " + e.getMessage(), "Error");
        }
    }

    private void reload() {
        if (empleado == null) {
            UtilGuis.showErrorMessage(this, "No se ha seleccionado ningún empleado", "Error");
            return;
        }

        if (!UtilGuis.validateRequiere(txtTelefono, txtCorreo, txtPuesto)) {
            UtilGuis.showErrorMessage(this, "Faltan datos requeridos", "Error");
            return;
        }

        try {
            String nuevoTelefono = txtTelefono.getText().trim();
            String nuevoCorreo = txtCorreo.getText().trim();
            String nuevoPuesto = txtPuesto.getText().trim();

            empleado.setTelefono(nuevoTelefono);
            empleado.setCorreo(nuevoCorreo);
            empleado.setPuesto(nuevoPuesto);

            UtilGuis.showMessage(this,
                    "Empleado actualizado: " + empleado.getNombre(),
                    "Teléfono: " + empleado.getTelefono()
                    + ", Correo: " + empleado.getCorreo()
                    + ", Puesto: " + empleado.getPuesto()
            );
        } catch (IllegalArgumentException e) {
            UtilGuis.showErrorMessage(this, e.getMessage(), "Error de validación");
        } catch (Exception e) {
            UtilGuis.showErrorMessage(this, "Error inesperado: " + e.getMessage(), "Error");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
        txtCorreo = new javax.swing.JTextField();
        txtPuesto = new javax.swing.JTextField();
        txtSalario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnReload = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 180, -1));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 145, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cedula :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 200, -1));

        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 145, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Fecha De Nacimiento :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Telefono :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 190, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Correo :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 200, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Puesto :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 200, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Salario :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 200, -1));

        txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jPanel1.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 145, -1));

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 145, -1));
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 145, -1));
        jPanel1.add(txtPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 330, 145, -1));
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 145, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 20, 290));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/contact_new (4).png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, -1, 50));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, 0, 790, 423));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setOpaque(false);

        btnReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/reload (5).png"))); // NOI18N
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/edit_delete_mail (4).png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/accepted_48.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/system-search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btnReload)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addGap(32, 32, 32)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReload)
                    .addComponent(btnSearch)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 400, 470, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/agregarcliente.png"))); // NOI18N
        jLabel13.setText("jLabel13");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1040, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        reload();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        add();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search();
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
