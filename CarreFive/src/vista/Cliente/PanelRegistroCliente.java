/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Cliente;

import AccesoDatos.ConexionBD;
import AccesoDatos.FachadaBD;
import controlador.controladorCliente;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Empleado;

/**
 *
 * @author Fernando
 */
public class PanelRegistroCliente extends javax.swing.JPanel {

    public FachadaBD fachada;
    public ConexionBD conexion;
    Empleado permisosEmpleado;
    controladorCliente controlCliente;

    /**
     * Creates new form PanelRegistroClientes
     */
    public PanelRegistroCliente(FachadaBD f, Empleado pE) {
        permisosEmpleado = pE;
        fachada = f;
        controlCliente = new controladorCliente(fachada);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        campoNombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoApellidoCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoIdCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoTelefonoCliente = new javax.swing.JTextField();
        campoDireccionCliente = new javax.swing.JTextField();
        botonRegistrarCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Registro Cliente"));

        jLabel2.setText("Nombre *");

        jLabel3.setText("Apellidos *");

        jLabel4.setText("Cédula *");

        jLabel5.setText("Teléfono");

        campoDireccionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDireccionClienteActionPerformed(evt);
            }
        });

        botonRegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Add.png"))); // NOI18N
        botonRegistrarCliente.setText("Registrar");
        botonRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarClienteActionPerformed(evt);
            }
        });

        jLabel7.setText("Dirección ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(campoNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(campoApellidoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoDireccionCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(campoIdCliente))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(campoTelefonoCliente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonRegistrarCliente)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(campoApellidoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(campoTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(botonRegistrarCliente)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Registrar Cliente");
    }// </editor-fold>//GEN-END:initComponents

    private void botonRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarClienteActionPerformed
        // TODO add your handling code here:
        String nombreCliente = campoNombreCliente.getText();
        String apellidoCliente = campoApellidoCliente.getText();;
        String cedula = campoIdCliente.getText();
        String telefono = campoTelefonoCliente.getText();
        String direccionC = campoDireccionCliente.getText();

        if (nombreCliente.equals("") || apellidoCliente.equals("") || cedula.equals("")) {
            JOptionPane.showMessageDialog(null,"Llene todos los campos obligatorios");
        } else {
            
            Cliente c = new Cliente(cedula, nombreCliente, apellidoCliente, direccionC, telefono, 0); 
            boolean flag = controlCliente.registrarCliente(c);
            if (flag==true) {
                JOptionPane.showMessageDialog(null, "Se ha registrado con exito el cliente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al almacenar un Cliente");
            }
        }

    }//GEN-LAST:event_botonRegistrarClienteActionPerformed

    private void campoDireccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDireccionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDireccionClienteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRegistrarCliente;
    private javax.swing.JTextField campoApellidoCliente;
    private javax.swing.JTextField campoDireccionCliente;
    private javax.swing.JTextField campoIdCliente;
    private javax.swing.JTextField campoNombreCliente;
    private javax.swing.JTextField campoTelefonoCliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    void limpiar() {
        campoNombreCliente.setText("");
        campoApellidoCliente.setText("");
        campoIdCliente.setText("");
        campoTelefonoCliente.setText("");
        campoDireccionCliente.setText("");
    }
}
