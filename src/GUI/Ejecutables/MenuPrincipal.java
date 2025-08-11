
package GUI.Ejecutables;

/**
 *
 * @author denis
 */
public class MenuPrincipal extends javax.swing.JPanel {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_Botones = new javax.swing.JPanel();
        jB_MenuVehiculos = new javax.swing.JButton();
        jB_MenuClientes = new javax.swing.JButton();
        jB_MenuEmpleados = new javax.swing.JButton();
        jB_MenuContratos = new javax.swing.JButton();
        jB_MenuReservas = new javax.swing.JButton();
        jL_fondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1000, 600));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jP_Botones.setOpaque(false);

        jB_MenuVehiculos.setBackground(new java.awt.Color(0, 0, 0));
        jB_MenuVehiculos.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jB_MenuVehiculos.setForeground(new java.awt.Color(204, 255, 255));
        jB_MenuVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/VehiculosMenu.png"))); // NOI18N
        jB_MenuVehiculos.setText("Vehiculos");
        jB_MenuVehiculos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jB_MenuVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_MenuVehiculosMouseEntered(evt);
            }
        });
        jB_MenuVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_MenuVehiculosActionPerformed(evt);
            }
        });

        jB_MenuClientes.setBackground(new java.awt.Color(12, 12, 12));
        jB_MenuClientes.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jB_MenuClientes.setForeground(new java.awt.Color(255, 255, 255));
        jB_MenuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/ClientesMenu.png"))); // NOI18N
        jB_MenuClientes.setText("Clientes");
        jB_MenuClientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jB_MenuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_MenuClientesMouseEntered(evt);
            }
        });

        jB_MenuEmpleados.setBackground(new java.awt.Color(25, 25, 25));
        jB_MenuEmpleados.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jB_MenuEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        jB_MenuEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/EmpleadosMenu.png"))); // NOI18N
        jB_MenuEmpleados.setText("Empleados");
        jB_MenuEmpleados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jB_MenuEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_MenuEmpleadosMouseEntered(evt);
            }
        });

        jB_MenuContratos.setBackground(new java.awt.Color(38, 38, 38));
        jB_MenuContratos.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jB_MenuContratos.setForeground(new java.awt.Color(255, 255, 255));
        jB_MenuContratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/ContratosMenu.png"))); // NOI18N
        jB_MenuContratos.setText("Contratos");
        jB_MenuContratos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jB_MenuContratos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_MenuContratosMouseEntered(evt);
            }
        });

        jB_MenuReservas.setBackground(new java.awt.Color(51, 51, 51));
        jB_MenuReservas.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jB_MenuReservas.setForeground(new java.awt.Color(255, 255, 255));
        jB_MenuReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Iconos/ReservasMenu.png"))); // NOI18N
        jB_MenuReservas.setText("Reservas");
        jB_MenuReservas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jB_MenuReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jB_MenuReservasMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jP_BotonesLayout = new javax.swing.GroupLayout(jP_Botones);
        jP_Botones.setLayout(jP_BotonesLayout);
        jP_BotonesLayout.setHorizontalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BotonesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_MenuVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_MenuClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_MenuEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_MenuContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_MenuReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jP_BotonesLayout.setVerticalGroup(
            jP_BotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_BotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_MenuVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jB_MenuClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jB_MenuEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jB_MenuContratos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jB_MenuReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        add(jP_Botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 470, 290));

        jL_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Menu principal_Vehiculos.png"))); // NOI18N
        add(jL_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jB_MenuVehiculosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_MenuVehiculosMouseEntered
        jL_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Menu principal_Vehiculos.png")));
    }//GEN-LAST:event_jB_MenuVehiculosMouseEntered

    private void jB_MenuClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_MenuClientesMouseEntered
        jL_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Menu principal_Clientes.png")));
    }//GEN-LAST:event_jB_MenuClientesMouseEntered

    private void jB_MenuEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_MenuEmpleadosMouseEntered
        jL_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Menu principal_Empleados.png")));
    }//GEN-LAST:event_jB_MenuEmpleadosMouseEntered

    private void jB_MenuContratosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_MenuContratosMouseEntered
        jL_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Menu principal_Contratos.png")));
    }//GEN-LAST:event_jB_MenuContratosMouseEntered

    private void jB_MenuReservasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_MenuReservasMouseEntered
        jL_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/Menu principal_Reserva.png")));
    }//GEN-LAST:event_jB_MenuReservasMouseEntered

    private void jB_MenuVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_MenuVehiculosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_MenuVehiculosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_MenuClientes;
    private javax.swing.JButton jB_MenuContratos;
    private javax.swing.JButton jB_MenuEmpleados;
    private javax.swing.JButton jB_MenuReservas;
    private javax.swing.JButton jB_MenuVehiculos;
    private javax.swing.JLabel jL_fondo;
    private javax.swing.JPanel jP_Botones;
    // End of variables declaration//GEN-END:variables
}
