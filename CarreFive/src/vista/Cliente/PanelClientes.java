/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Cliente;

import AccesoDatos.FachadaBD;
import modelo.Empleado;

/**
 *
 * @author Fernando
 */
public class PanelClientes extends javax.swing.JPanel {

    /**
     * Creates new form PanelClientes
     */
    FachadaBD fachada;
    Empleado permisosEmpleado;
    public PanelClientes(FachadaBD f, Empleado pE) {
        permisosEmpleado = pE;
        fachada = f;
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

        jPanel2 = new javax.swing.JPanel();
        bCrearCliente = new javax.swing.JButton();
        bConsultarCliente = new javax.swing.JButton();
        botonListarClientes = new javax.swing.JButton();
        panelCentralClientes = new javax.swing.JPanel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestionar Cliente"));

        bCrearCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CrearCliente.png"))); // NOI18N
        bCrearCliente.setText("Nuevo");
        bCrearCliente.setToolTipText("Crear Cliente");
        bCrearCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearClienteActionPerformed(evt);
            }
        });

        bConsultarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ConsultarCliente.png"))); // NOI18N
        bConsultarCliente.setText("Consultar");
        bConsultarCliente.setToolTipText("Consultar Cliente");
        bConsultarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarClienteActionPerformed(evt);
            }
        });

        botonListarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente listado.png"))); // NOI18N
        botonListarClientes.setText("Lista");
        botonListarClientes.setToolTipText("Listado Clientes");
        botonListarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonListarClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bCrearCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bConsultarCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bCrearCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bConsultarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonListarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        panelCentralClientes.setPreferredSize(new java.awt.Dimension(630, 340));

        javax.swing.GroupLayout panelCentralClientesLayout = new javax.swing.GroupLayout(panelCentralClientes);
        panelCentralClientes.setLayout(panelCentralClientesLayout);
        panelCentralClientesLayout.setHorizontalGroup(
            panelCentralClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        panelCentralClientesLayout.setVerticalGroup(
            panelCentralClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentralClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCentralClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Menú Clientes");
    }// </editor-fold>//GEN-END:initComponents

    private void bCrearClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearClienteActionPerformed
        // TODO add your handling code here:
        panelCentralClientes.removeAll();
        PanelRegistroCliente obj=new PanelRegistroCliente(fachada,permisosEmpleado);
        panelCentralClientes.add(obj);
        obj.setSize(794, 478);
        obj.validate();
        obj.setVisible(true);

    }//GEN-LAST:event_bCrearClienteActionPerformed

    private void bConsultarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarClienteActionPerformed
        // TODO add your handling code here:
        panelCentralClientes.removeAll();
        PanelConsultarCliente obj=new PanelConsultarCliente(fachada,permisosEmpleado);
        panelCentralClientes.add(obj);
        obj.setSize(794, 478);
        obj.validate();
        obj.setVisible(true);
    }//GEN-LAST:event_bConsultarClienteActionPerformed

    private void botonListarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarClientesActionPerformed
        // TODO add your handling code here:
        panelCentralClientes.removeAll();
        PanelListadoClientes obj=new PanelListadoClientes(fachada,permisosEmpleado);
        panelCentralClientes.add(obj);
        obj.setSize(794, 478);
        obj.validate();
        obj.setVisible(true);
    }//GEN-LAST:event_botonListarClientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bConsultarCliente;
    private javax.swing.JButton bCrearCliente;
    private javax.swing.JButton botonListarClientes;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelCentralClientes;
    // End of variables declaration//GEN-END:variables
}
