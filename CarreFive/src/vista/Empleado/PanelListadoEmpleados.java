/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Empleado;

import AccesoDatos.FachadaBD;
import controlador.controladorEmpleado;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import vista.Cliente.PanelRegistroCliente;

/**
 *
 * @author usuario
 */
public class PanelListadoEmpleados extends javax.swing.JPanel {

    /**
     * Creates new form panelListadoEmpleados
     */
    controladorEmpleado controlador;
    FachadaBD fachada;
    Empleado permisosEmpleado;
    
    public PanelListadoEmpleados(FachadaBD f,Empleado pE) {
        permisosEmpleado = pE;
        fachada=f;
        controlador = new controladorEmpleado(fachada);
        initComponents();
        Object[][] datos = controlador.listarEmpleado();
        Object[] nCol= {"Cedula","Nombre","Apellido","Direccion","Telefono","Cargo"};
        listaEmpleados.setModel(new DefaultTableModel(datos,nCol));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaEmpleados = new javax.swing.JTable();
        botonAgregar = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Listado Empleados"));

        listaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(listaEmpleados);

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAgregar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(botonAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        PanelRegistroEmpleado empleadoNuevo = new PanelRegistroEmpleado(fachada, permisosEmpleado);
        JFrame registro = new JFrame();
        registro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registro.add(empleadoNuevo);
        registro.setSize(760, 520);
        registro.setLocationRelativeTo(null);
        registro.setVisible(true);
        registro.setResizable(false);
    }//GEN-LAST:event_botonAgregarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaEmpleados;
    // End of variables declaration//GEN-END:variables
}
