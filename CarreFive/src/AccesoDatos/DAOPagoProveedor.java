/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

/**
 *
 * @author usuario
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.PagoProveedor;

public class DAOPagoProveedor {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOPagoProveedor(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarPagoProveedor(PagoProveedor pp) {
        boolean flag;
        String sql_guardar;
        sql_guardar = "INSERT INTO PagoProveedor VALUES ('"
                + pp.getnroPago() + "', '"
                + pp.getidCompra() + "', '"
                + pp.getfechaPago() + "', '"
                + pp.getmonto() + "', '"
                + pp.getidEmpleado() + "')";
        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();
        return flag;
    }

    public ArrayList<PagoProveedor> consultarPagoProveedor(String idCompra) {
        ArrayList tupla = new ArrayList<PagoProveedor>();
        String sql_select;
        sql_select = "SELECT * FROM PagoProveedor WHERE idCompra = '" + idCompra + "';";
        System.out.println(sql_select);
        conexion.abrir();
        try {

            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                PagoProveedor pp = new PagoProveedor();
                pp.setnroPago(Integer.parseInt(tabla.getString(1)));
                pp.setidCompra(tabla.getString(2));
                pp.setfechaPago(tabla.getString(3));
                pp.setmonto(Double.parseDouble(tabla.getString(4)));
                pp.setidEmpleado(tabla.getString(5));
                tupla.add(pp);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();
        return tupla;

    }

    public ArrayList<PagoProveedor> listarPagoProveedor() {
        ArrayList<PagoProveedor> tupla = new ArrayList<PagoProveedor>();
        String sql_select;
        sql_select = "SELECT * FROM PagoProveedor;";
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                PagoProveedor pp = new PagoProveedor();
                pp.setnroPago(Integer.parseInt(tabla.getString(1)));
                pp.setidCompra(tabla.getString(2));
                pp.setfechaPago(tabla.getString(3));
                pp.setmonto(Double.parseDouble(tabla.getString(4)));
                pp.setidEmpleado(tabla.getString(5));
                tupla.add(pp);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;

    }

    public int getIndicePagoProveedor(String idCompra) {
        String sql;
        int indice = 0;
        sql = "select max(nropago) from pagoProveedor where idCompra = '" + idCompra + "';";
        conexion.abrir();
        System.out.println(sql);
        try {
            ResultSet consulta = conexion.obtenerSentencia().executeQuery(sql);
            while(consulta.next()){
                indice = Integer.parseInt(consulta.getString(1));
            }

        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        conexion.cerrar();
        return indice;
    }
}
