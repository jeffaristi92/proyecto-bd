/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.Compras;

import AccesoDatos.FachadaBD;
import controlador.controladorCompra;
import controlador.controladorItemCompra;
import controlador.controladorPagoProveedor;
import controlador.controladorProducto;
import controlador.controladorProveedor;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Compra;
import modelo.Empleado;
import modelo.ItemCompra;
import modelo.PagoProveedor;
import modelo.Producto;
import modelo.Proveedor;
import vista.Producto.PanelListadoProductos;
import vista.Proveedor.PanelListadoProveedores;

/**
 *
 * @author usuario
 */
public class PanelRegistroCompra extends javax.swing.JPanel {

    /**
     * Creates new form panelNuevaVenta
     */
    controladorProducto controlProducto;
    controladorItemCompra controlItemCompra;
    controladorCompra controlCompra;
    controladorProveedor controlProveedor;
    controladorPagoProveedor controlPagoProveedor;
    Producto producto;
    Proveedor proveedor;
    DefaultTableModel modeloItems;
    double total;
    FachadaBD fachada;
    Empleado permisosEmpleado;
    boolean pago;

    public PanelRegistroCompra(FachadaBD f, Empleado pE) {
        permisosEmpleado = pE;
        fachada = f;
        controlProducto = new controladorProducto(fachada);
        controlItemCompra = new controladorItemCompra(fachada);
        controlCompra = new controladorCompra(fachada);
        controlProveedor = new controladorProveedor(fachada);
        controlPagoProveedor = new controladorPagoProveedor(fachada);
        producto = new Producto();
        proveedor = new Proveedor();
        modeloItems = new DefaultTableModel();
        modeloItems.addColumn("Producto");
        modeloItems.addColumn("Descripcion");
        modeloItems.addColumn("Cantidad");
        modeloItems.addColumn("Vlr Unitario");
        modeloItems.addColumn("Total");
        total = 0;
        initComponents();
    }

    public void setProducto(Producto p) {
        llenarCamposProducto(p);
    }

    public void setProveedor(Proveedor p) {
        proveedor = p;
        campoProveedor.setText(p.getidProveedor());
        campoNombreProveedor.setText(proveedor.getnombreProveedor());
    }

    private void buscarProveedorCampo() {
        String idPr = campoProveedor.getText();

        if (idPr.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el codigo del proveedor");
        } else {
            proveedor = controlProveedor.consultarProveedor(idPr,0).get(0);
            campoNombreProveedor.setText(proveedor.getnombreProveedor());

        }
    }

    private void buscarProveedorLista() {
        PanelListadoProveedores listado = new PanelListadoProveedores(fachada, permisosEmpleado, 1);
        listado.setPanelRegistroCompra(this);
        JFrame proveedores = new JFrame();
        proveedores.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listado.setFrame(proveedores);
        proveedores.add(listado);
        proveedores.setSize(760, 520);
        proveedores.setLocationRelativeTo(null);
        proveedores.setVisible(true);
        proveedores.setResizable(false);
    }

    private void buscarProductoCampo() {

        String idProduc = campoProducto.getText();
        if (idProduc.equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el codigo de un producto");
        } else {
            Producto p = controlProducto.consultarProducto(idProduc,0).get(0);
            if (p.getidProveedor() == null) {
            } else {               
                llenarCamposProducto(p);
            }
        }

    }
    
    private void llenarCamposProducto(Producto p){
        String idPv1 = p.getidProveedor();
        String idPvP = proveedor.getidProveedor();
                if (idPv1.equalsIgnoreCase(idPvP)) {
                    producto = p;
                    JOptionPane.showMessageDialog(null, "Producto " + producto.getidProducto()
                            + "seleccionado correctamente");
                    campoProducto.setText(producto.getidProducto());
                    campoDescripcionProducto.setText(producto.getdescripcion());
                } else {
                    JOptionPane.showMessageDialog(null, "El producto no es suministrado por el proveedor: "
                            + campoNombreProveedor.getText());
                }
    }

    private void buscarProductoLista() {
        PanelListadoProductos listado = new PanelListadoProductos(fachada, permisosEmpleado, 2);
        listado.setComprasNuevas(this);
        JFrame productos = new JFrame();
        productos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listado.setFrame(productos);
        productos.add(listado);
        productos.setSize(760, 520);
        productos.setLocationRelativeTo(null);
        productos.setVisible(true);
        productos.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoProveedor = new javax.swing.JTextField();
        botonBuscarProveedor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoProducto = new javax.swing.JTextField();
        botonBuscarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        campoCantidad = new javax.swing.JTextField();
        botonAgregarProducto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        etiquetaTotal = new javax.swing.JLabel();
        opcionPago = new javax.swing.JRadioButton();
        botonRegistrarCompra = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoIdCompra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoNombreProveedor = new javax.swing.JTextField();
        opcionListaProveedor = new javax.swing.JRadioButton();
        opcionListaProducto = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        campoDescripcionProducto = new javax.swing.JTextField();
        campoFecha = new com.toedter.calendar.JDateChooser();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Nueva Compra"));

        jLabel1.setText("Proveedor");

        botonBuscarProveedor.setText("Buscar");
        botonBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProveedorActionPerformed(evt);
            }
        });

        jLabel2.setText("Producto");

        botonBuscarProducto.setText("Buscar");
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });

        tablaProductos.setModel(modeloItems);
        jScrollPane1.setViewportView(tablaProductos);

        jLabel3.setText("Cantidad");

        botonAgregarProducto.setText("Agregar Producto");
        botonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarProductoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("TOTAL:");

        etiquetaTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etiquetaTotal.setText("0");

        opcionPago.setText("Pagó");
        opcionPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionPagoActionPerformed(evt);
            }
        });

        botonRegistrarCompra.setText("Registrar Compra");
        botonRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarCompraActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha:");

        jLabel6.setText("Nro Compra");

        jLabel7.setText("Nombre");

        campoNombreProveedor.setEditable(false);

        opcionListaProveedor.setText("Lista");

        opcionListaProducto.setText("Lista");

        jLabel8.setText("Descripcion");

        campoDescripcionProducto.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(etiquetaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                        .addComponent(opcionPago)
                        .addGap(38, 38, 38)
                        .addComponent(botonRegistrarCompra))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(campoProducto)
                                    .addComponent(campoProveedor)
                                    .addComponent(campoFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(opcionListaProveedor)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscarProveedor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(opcionListaProducto)
                                .addGap(18, 18, 18)
                                .addComponent(botonBuscarProducto))
                            .addComponent(botonAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoNombreProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(campoIdCompra, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDescripcionProducto))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(campoIdCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(campoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(opcionListaProveedor)
                        .addComponent(botonBuscarProveedor)
                        .addComponent(jLabel7))
                    .addComponent(campoNombreProveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionListaProducto)
                    .addComponent(botonBuscarProducto)
                    .addComponent(jLabel8)
                    .addComponent(campoDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregarProducto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opcionPago)
                    .addComponent(jLabel4)
                    .addComponent(etiquetaTotal)
                    .addComponent(botonRegistrarCompra))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProveedorActionPerformed
        // TODO add your handling code here:
        if (opcionListaProveedor.isSelected() == true) {
            buscarProveedorLista();
        } else {
            buscarProveedorCampo();
        }
    }//GEN-LAST:event_botonBuscarProveedorActionPerformed

    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        // TODO add your handling code here:

        if (proveedor.getidProveedor() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un proveedor");
        } else {
            if(opcionListaProducto.isSelected()==true){
                buscarProductoLista();
            }else{
                buscarProductoCampo();
            }
        }
    }//GEN-LAST:event_botonBuscarProductoActionPerformed

    private void botonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarProductoActionPerformed
        // TODO add your handling code here:
        boolean esta = false;
        if (producto.getidProducto() == null) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
        } else if (campoCantidad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad de articulos a comprar");
        } else {
            for (int i = 0; i < modeloItems.getRowCount(); i++) {
                esta = producto.getidProducto().equals(modeloItems.getValueAt(i, 0));
                if (esta) {
                    break;
                }
            }
            if (esta == true) {
                JOptionPane.showMessageDialog(null, "Ya agrego el producto " + producto.getidProducto());
            } else {
                String fila[] = new String[5];
                int cantidad = 0;
                try {
                    cantidad = Integer.parseInt(campoCantidad.getText());
                } catch (Exception exp) {
                    JOptionPane.showMessageDialog(null, exp.getMessage() + ": " + "Ingrese un valor valido"
                            + " para cantidad");
                }
                if (cantidad <= 0) {
                    JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor que cero");

                } else {
                    double totalItem = producto.getprecioCompra() * cantidad;

                    fila[0] = producto.getidProducto();
                    fila[1] = producto.getdescripcion();
                    fila[2] = campoCantidad.getText();
                    DecimalFormat formato = new DecimalFormat("###,###");
                    fila[3] = formato.format(producto.getprecioCompra());
                    fila[4] = formato.format(totalItem);
                    total += totalItem;
                    etiquetaTotal.setText(formato.format(total));
                    modeloItems.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_botonAgregarProductoActionPerformed

    private void botonRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarCompraActionPerformed
        // TODO add your handling code here:
        boolean registrado;
        if (campoFecha.getDate()==null) {
            JOptionPane.showMessageDialog(null, "Ingrese la fecha");
        } else if (campoIdCompra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese el Nro de compra");
        } else if (total == 0) {
            JOptionPane.showMessageDialog(null, "No ha agregado productos");
        } else {
            Compra c = new Compra();
            c.setidCompra(campoIdCompra.getText());
            c.setfechaCompra(campoFecha.getDate().toString());
            c.setidEmpleado(permisosEmpleado.getidEmpleado());
            c.setidProveedor(campoProveedor.getText());
            c.setvlrTotal(total);
            c.setsaldoCompra(""+total);
            registrado = controlCompra.registrarCompra(c);

            if (registrado == true) {

                if (opcionPago.isSelected()) {
                    PagoProveedor pago = new PagoProveedor();
                    pago.setnroPago(1);
                    pago.setfechaPago(campoFecha.getDate().toString());
                    pago.setidCompra(c.getidCompra());
                    pago.setidEmpleado(permisosEmpleado.getidEmpleado());
                    pago.setmonto(total);
                    controlPagoProveedor.registrarPagoProveedor(pago);
                }
                for (int i = 0; i < modeloItems.getRowCount(); i++) {
                    ItemCompra item = new ItemCompra();
                    item.setnroItem("" + (i + 1));
                    item.setidCompra(c.getidCompra());
                    item.setidProducto("" + modeloItems.getValueAt(i, 0));
                    item.setcantidad(Integer.parseInt("" + modeloItems.getValueAt(i, 2)));
                    item.setvlrTotal(Double.parseDouble("" + modeloItems.getValueAt(i, 4)));
                    controlItemCompra.registrarItemCompra(item);
                }
                JOptionPane.showMessageDialog(null, "La compra" + c.getidCompra()
                        + " se registro con exito");
            } else {
                JOptionPane.showMessageDialog(null, "La compra no se pudo registrar");
            }
        }

    }//GEN-LAST:event_botonRegistrarCompraActionPerformed

    private void opcionPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionPagoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarProducto;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonBuscarProveedor;
    private javax.swing.JButton botonRegistrarCompra;
    private javax.swing.JTextField campoCantidad;
    private javax.swing.JTextField campoDescripcionProducto;
    private com.toedter.calendar.JDateChooser campoFecha;
    private javax.swing.JTextField campoIdCompra;
    private javax.swing.JTextField campoNombreProveedor;
    private javax.swing.JTextField campoProducto;
    private javax.swing.JTextField campoProveedor;
    private javax.swing.JLabel etiquetaTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton opcionListaProducto;
    private javax.swing.JRadioButton opcionListaProveedor;
    private javax.swing.JRadioButton opcionPago;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
