/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Venta;

/**
 *
 * @author usuario
 */
public class DAOVenta {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOVenta(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarVenta(Venta objV) {
        boolean flag = false;
        String sql_guardar;
        sql_guardar = "INSERT INTO Venta VALUES ('"
                + objV.getidVenta() + "','"
                + objV.getidEmpleado() + "', '"
                + objV.getidCliente() + "', '"
                + objV.getfechaVenta() + "', '"
                + objV.getvlrTotal() + "', '"
                + objV.getsaldoVenta() + " ')";
        try {
            conexion.abrir();
            flag = conexion.actualizar(sql_guardar);
            conexion.cerrar();
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, "Venta " + objV.getidVenta() + " ya realizada");
            flag = false;
        }
        return flag;
    }

    public ArrayList<Venta> consultarVenta(String cod) {

        ArrayList<Venta> tupla = new ArrayList<Venta>();
        String sql_select;

        sql_select = "SELECT * FROM Venta WHERE idVenta = '" + cod+"';";

        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Venta v = new Venta();
                v.setidVenta(tabla.getString(1));
                v.setidEmpleado(tabla.getString(2));
                v.setidCliente(tabla.getString(3));
                v.setfechaVenta(tabla.getString(4));
                v.setvlrTotal(Double.parseDouble(tabla.getString(5)));
                v.setsaldoVenta(Double.parseDouble(tabla.getString(6)));
                tupla.add(v);
            }
        } catch (Exception e) {
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;
    }
    
    public ArrayList<Venta> consultarVentasXCliente(String idCliente) {

        ArrayList<Venta> tupla = new ArrayList<Venta>();
        String sql_select;

        sql_select = "select idVenta, (nombreEmpleado ||' '|| apellidoempleado) as empleado, (nombrecliente ||' '||apellidocliente)as cliente,fechaventa,vlrtotal,saldoventa "
                + "from venta, cliente, empleado "
                + "where venta.idcliente = cliente.idcliente and venta.idempleado = empleado.idEmpleado and venta.idCliente ='"+ idCliente+"';";

        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Venta v = new Venta();
                v.setidVenta(tabla.getString(1));
                v.setidEmpleado(tabla.getString(2));
                v.setidCliente(tabla.getString(3));
                v.setfechaVenta(tabla.getString(4));
                v.setvlrTotal(Double.parseDouble(tabla.getString(5)));
                v.setsaldoVenta(Double.parseDouble(tabla.getString(6)));
                tupla.add(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;
    }
    
    public ArrayList<String> poblar_combobox(String tabla, String nombrecol, String sql) {
        int registros = 0;
        String sql_select;
        sql_select = "SELECT count(*) as total FROM " + tabla;
        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tab = conexion.obtenerSentencia().executeQuery(sql_select);
            tab.next();
            registros = tab.getInt("total");

        } catch (SQLException e) {
            conexion.cerrar();
            System.out.println(e);
        }
        return null;
    }
}
