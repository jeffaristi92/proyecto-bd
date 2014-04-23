/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Compra;
import modelo.Venta;

/**
 *
 * @author usuario
 */
public class DAOCompra {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOCompra(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarCompra(Compra obj) {
        boolean flag = false;
        String sql_guardar;
        sql_guardar = "INSERT INTO Compra VALUES ('"
                + obj.getidCompra() + "', '"
                + obj.getidProveedor() + "', '"
                + obj.getidEmpleado() + "', '"
                + obj.getfechaCompra() + "', '"
                + obj.getvlrTotal() + "', '"
                + obj.getsaldoCompra() + "')";
        conexion.abrir();
        try {

            flag = conexion.actualizar(sql_guardar);
            System.out.println(sql_guardar);

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
        conexion.cerrar();
        return flag;
    }

    public ArrayList<Compra> consultarCompra(String valor) {
        boolean flag = false;
        ArrayList tupla = new ArrayList<Compra>();
        String sql_select;
        sql_select = "SELECT * FROM Compra WHERE " + "idcompra" + " = '" + valor + "';";
        System.out.println(sql_select);
        conexion.abrir();
        try {

            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Compra p = new Compra();
                p.setidCompra(tabla.getString(1));
                p.setidProveedor(tabla.getString(2));
                p.setidEmpleado(tabla.getString(3));
                p.setfechaCompra(tabla.getString(4));
                p.setvlrTotal(Double.parseDouble(tabla.getString(5)));
                p.setsaldoCompra(tabla.getString(6));
                tupla.add(p);
                flag = true;
            }

            if (flag == false) {
                JOptionPane.showMessageDialog(null, "La compra Nro " + valor
                        + " no se encontro");
                Compra p = new Compra();
                tupla.add(p);
            }

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
            Compra p = new Compra();
            tupla.add(p);
        }
        conexion.cerrar();
        return tupla;

    }
    
    public ArrayList<Compra> consultarComprasXProveedor(String idProveedor) {

        ArrayList<Compra> tupla = new ArrayList<Compra>();
        String sql_select;

        sql_select = "select idCompra, (nombreEmpleado ||' '|| apellidoempleado) as empleado,nombreProveedor,fechaCompra,vlrtotal,saldoCompra "
                + "from compra, proveedor, empleado "
                + "where compra.idProveedor = proveedor.idproveedor and compra.idempleado = empleado.idEmpleado and compra.idProveedor ='"+ idProveedor+"';";

        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Compra c = new Compra();
                c.setidCompra(tabla.getString(1));
                c.setidEmpleado(tabla.getString(2));
                c.setidProveedor(tabla.getString(3));
                c.setfechaCompra(tabla.getString(4));
                c.setvlrTotal(Double.parseDouble(tabla.getString(5)));
                c.setsaldoCompra(tabla.getString(6));
                tupla.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;
    }
    
}
