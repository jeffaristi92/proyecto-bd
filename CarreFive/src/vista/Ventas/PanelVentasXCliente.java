/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Ventas;

import AccesoDatos.FachadaBD;
import controlador.controladorVenta;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Venta;
import vista.Cliente.PanelListadoClientes;

/**
 *
 * @author usuario
 */
public class PanelVentasXCliente extends javax.swing.JPanel {

    /**
     * Creates new form PanelVentasXCliente
     */
    FachadaBD fachada;
    controladorVenta controlVenta;
    DefaultTableModel modeloVentas;
    Empleado permisosEmpleado;
    Cliente cliente;
    int opcion;
    PanelConsultarVenta panelConsulta;
    PanelRegistroPagoCliente panelRegistroPagoCliente;
    JFrame frame;

    public PanelVentasXCliente(FachadaBD f, Empleado pE) {
        fachada = f;
        permisosEmpleado = pE;
        controlVenta = new controladorVenta(fachada);
        modeloVentas = new DefaultTableModel();
        modeloVentas.addColumn("Nro Venta");
        modeloVentas.addColumn("Empleado");
        modeloVentas.addColumn("Cliente");
        modeloVentas.addColumn("Fecha");
        modeloVentas.addColumn("Total");
        modeloVentas.addColumn("Saldo");
        initComponents();
        botonSeleccionar.setVisible(false);
    }
    /*
     * 1. panelConsultarVenta
     * 2. panelRegistroPagoCliente
     */
    public PanelVentasXCliente(FachadaBD f, Empleado pE, int op) {
        fachada = f;
        permisosEmpleado = pE;
        opcion = op;
        controlVenta = new controladorVenta(fachada);
        modeloVentas = new DefaultTableModel();
        modeloVentas.addColumn("Nro Venta");
        modeloVentas.addColumn("Empleado");
        modeloVentas.addColumn("Cliente");
        modeloVentas.addColumn("Fecha");
        modeloVentas.addColumn("Total");
        modeloVentas.addColumn("Saldo");
        initComponents();
        botonSeleccionar.setEnabled(true);
    }

    public void setFrame(JFrame f) {
        frame = f;
    }

    public void setPanelConsulta(PanelConsultarVenta panelConsulta) {
        this.panelConsulta = panelConsulta;
    }

    public void setPanelRegistroPagoCliente(PanelRegistroPagoCliente panelRegistroPagoCliente) {
        this.panelRegistroPagoCliente = panelRegistroPagoCliente;
    }

    public void setCliente(Cliente c) {
        int filas = modeloVentas.getRowCount();
        for (int i = 0; i < filas; i++) {
            modeloVentas.removeRow(i);
        }
        System.out.println("Va a asignar la lista de ventas");
        cliente = c;
        ArrayList<Venta> listado = controlVenta.consultarVentasXCliente(cliente.getidCliente());

        for (int i = 0; i < listado.size(); i++) {

            System.out.println("venta " + i);
            Object fila[] = new String[6];
            fila[0] = listado.get(i).getidVenta();
            fila[1] = listado.get(i).getidEmpleado();
            fila[2] = listado.get(i).getidCliente();
            fila[3] = listado.get(i).getfechaVenta();
            DecimalFormat formato =  new DecimalFormat("###,###");
            fila[4] = formato.format(listado.get(i).getvlrTotal());
            fila[5] = formato.format(listado.get(i).getsaldoVenta());
            modeloVentas.addRow(fila);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSeleccionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        botonBuscarCliente = new javax.swing.JButton();
        botonAbono = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Listado Ventas Por Cliente"));

        botonSeleccionar.setText("Seleccionar");
        botonSeleccionar.setEnabled(false);
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt);
            }
        });

        tablaVentas.setModel(modeloVentas);
        jScrollPane1.setViewportView(tablaVentas);

        botonBuscarCliente.setText("Buscar");
        botonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarClienteActionPerformed(evt);
            }
        });

        botonAbono.setText("Abono");
        botonAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbonoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonBuscarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAbono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonSeleccionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSeleccionar)
                    .addComponent(botonBuscarCliente)
                    .addComponent(botonAbono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarClienteActionPerformed
        // TODO add your handling code here:
        PanelListadoClientes listado = new PanelListadoClientes(fachada, permisosEmpleado, 3);
        listado.setVentasXcliente(this);
        JFrame clientes = new JFrame();
        clientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listado.setFrame(clientes);
        clientes.add(listado);
        clientes.setSize(760, 520);
        clientes.setLocationRelativeTo(null);
        clientes.setVisible(true);
        clientes.setResizable(false);
    }//GEN-LAST:event_botonBuscarClienteActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        // TODO add your handling code here:
        int fila = tablaVentas.getSelectedRow();

        if (fila != -1) {
            Venta v = new Venta();
            v.setidVenta(tablaVentas.getValueAt(fila, 0) + "");

            switch (opcion) {
                case 1:
                    panelConsulta.setVenta(v);
                    break;
                case 2:
                    panelRegistroPagoCliente.setVenta(v);
                    break;

            }

            frame.dispose();

        }

    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void botonAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbonoActionPerformed
        // TODO add your handling code here:
        int fila = tablaVentas.getSelectedRow();

        if (fila != -1) {
            Venta v = new Venta();
            v.setidVenta(tablaVentas.getValueAt(fila, 0) + "");

            PanelRegistroPagoCliente pago = new PanelRegistroPagoCliente(fachada, permisosEmpleado);
            JFrame abono = new JFrame();
            abono.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            abono.add(pago);
            abono.setSize(760, 520);
            abono.setLocationRelativeTo(null);
            abono.setVisible(true);
            abono.setResizable(false);
            pago.buscarVenta(v.getidVenta());

        }
    }//GEN-LAST:event_botonAbonoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAbono;
    private javax.swing.JButton botonBuscarCliente;
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}