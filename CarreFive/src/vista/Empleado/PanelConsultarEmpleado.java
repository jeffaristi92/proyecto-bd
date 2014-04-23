/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Empleado;

import AccesoDatos.FachadaBD;
import controlador.controladorEmpleado;
import javax.swing.JOptionPane;
import modelo.Empleado;

/**
 *
 * @author usuario
 */
public class PanelConsultarEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form panelConsultarEmpleado
     */
    controladorEmpleado controlador;
    FachadaBD fachada;
    Empleado permisosEmpleado;
    Empleado e;

    public PanelConsultarEmpleado(FachadaBD f, Empleado pE) {
        permisosEmpleado = pE;
        fachada = f;
        controlador = new controladorEmpleado(fachada);
        e = new Empleado();
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

        panelBuscar = new javax.swing.JPanel();
        campoBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        panelDatosEmpleado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoCargo = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();

        panelBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBuscarLayout = new javax.swing.GroupLayout(panelBuscar);
        panelBuscar.setLayout(panelBuscarLayout);
        panelBuscarLayout.setHorizontalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoBuscar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscarLayout.createSequentialGroup()
                        .addGap(0, 63, Short.MAX_VALUE)
                        .addComponent(botonBuscar)))
                .addContainerGap())
        );
        panelBuscarLayout.setVerticalGroup(
            panelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonBuscar)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        panelDatosEmpleado.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Empleado"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

        jLabel3.setText("Cedula");
        jLabel3.setToolTipText("");

        campoId.setEditable(false);

        jLabel4.setText("Telefono");

        jLabel5.setText("Direccion");

        jLabel6.setText("Cargo");

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosEmpleadoLayout = new javax.swing.GroupLayout(panelDatosEmpleado);
        panelDatosEmpleado.setLayout(panelDatosEmpleadoLayout);
        panelDatosEmpleadoLayout.setHorizontalGroup(
            panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                        .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                            .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosEmpleadoLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(14, 14, 14)))
                                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoNombre)
                                    .addComponent(campoId))))
                        .addGap(13, 13, 13)
                        .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(campoTelefono)
                            .addComponent(campoCargo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosEmpleadoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonActualizar)))
                .addContainerGap())
        );
        panelDatosEmpleadoLayout.setVerticalGroup(
            panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosEmpleadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDatosEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(campoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDatosEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelDatosEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 344, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        String id = campoBuscar.getText();
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la cedula de un empleado");
        } else {
            e = controlador.consultarEmpleado(id);
            campoId.setText(e.getidEmpleado());
            campoNombre.setText(e.getnombreEmpleado());
            campoApellido.setText(e.getapellidoEmpleado());
            campoDireccion.setText(e.getdireccionEmpleado());
            campoTelefono.setText(e.gettelefonoEmpleado());
            campoCargo.setText(e.getcargoEmpleado());
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
        String nombre = campoNombre.getText();
        String apellido = campoApellido.getText();
        String direccion = campoDireccion.getText();
        String telefono = campoTelefono.getText();
        String cargo = campoCargo.getText();

        if (nombre.equals("") || apellido.equals("") || direccion.equals("") || telefono.equals("") || cargo.equals("")) {
            JOptionPane.showMessageDialog(null,"Llene todos los campos");
        } else {
            e.setnombreEmpleado(nombre);
            e.setapellidoEmpleado(apellido);
            e.setdireccionEmpleado(direccion);
            e.settelefonoEmpleado(telefono);
            e.setcargoEmpleado(cargo);
            boolean actualizado =controlador.actualizarEmpleado(e);
            
            if(actualizado==true){
                JOptionPane.showMessageDialog(null,"Empleado actualizado con exito");
            }else{
                JOptionPane.showMessageDialog(null,"No se pudo actualizar el empleado");
            }
        }
    }//GEN-LAST:event_botonActualizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoBuscar;
    private javax.swing.JTextField campoCargo;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel panelBuscar;
    private javax.swing.JPanel panelDatosEmpleado;
    // End of variables declaration//GEN-END:variables
}