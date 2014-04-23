/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Empleado;

import AccesoDatos.FachadaBD;
import javax.swing.JOptionPane;
import modelo.Empleado;

/**
 *
 * @author usuario
 */
public class PanelEmpleados extends javax.swing.JPanel {

    /**
     * Creates new form PanelEmpleado
     */
    FachadaBD fachada;
    Empleado permisosEmpleado;

    public PanelEmpleados(FachadaBD f, Empleado pE) {
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

        panelBotones = new javax.swing.JPanel();
        botonCrearEmpleado = new javax.swing.JButton();
        botonConsultarEmpleado = new javax.swing.JButton();
        botonListarEmpleados = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();

        panelBotones.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestionar Empleados"));

        botonCrearEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleado agregar.png"))); // NOI18N
        botonCrearEmpleado.setText("Nuevo");
        botonCrearEmpleado.setToolTipText("Crear Empleado");
        botonCrearEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearEmpleadoActionPerformed(evt);
            }
        });

        botonConsultarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleado consultar.png"))); // NOI18N
        botonConsultarEmpleado.setText("Consultar");
        botonConsultarEmpleado.setToolTipText("Consultar Empleado");
        botonConsultarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarEmpleadoActionPerformed(evt);
            }
        });

        botonListarEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/empleado listar.png"))); // NOI18N
        botonListarEmpleados.setText("Lista");
        botonListarEmpleados.setToolTipText("Listar Empleados");
        botonListarEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarEmpleadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonListarEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonConsultarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(botonCrearEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonCrearEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonConsultarEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonListarEmpleados)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearEmpleadoActionPerformed
        // TODO add your handling code here:
        if (permisosEmpleado.getcargoEmpleado().equalsIgnoreCase("administrador")) {
            panelCentral.removeAll();
            PanelRegistroEmpleado obj = new PanelRegistroEmpleado(fachada, permisosEmpleado);
            panelCentral.add(obj);
            obj.setSize(794, 478);
            obj.validate();
            obj.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,"No tiene permisos para realizar esta accion");
        }
    }//GEN-LAST:event_botonCrearEmpleadoActionPerformed
    
    private void botonConsultarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarEmpleadoActionPerformed
        // TODO add your handling code here:
        panelCentral.removeAll();
        PanelConsultarEmpleado obj = new PanelConsultarEmpleado(fachada, permisosEmpleado);
        panelCentral.add(obj);
        obj.setSize(794, 478);
        obj.validate();
        obj.setVisible(true);
    }//GEN-LAST:event_botonConsultarEmpleadoActionPerformed
    
    private void botonListarEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarEmpleadosActionPerformed
        // TODO add your handling code here
        panelCentral.removeAll();
        PanelListadoEmpleados obj = new PanelListadoEmpleados(fachada, permisosEmpleado);
        panelCentral.add(obj);
        obj.setSize(794, 478);
        obj.validate();
        obj.setVisible(true);
    }//GEN-LAST:event_botonListarEmpleadosActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonConsultarEmpleado;
    private javax.swing.JButton botonCrearEmpleado;
    private javax.swing.JButton botonListarEmpleados;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentral;
    // End of variables declaration//GEN-END:variables
}