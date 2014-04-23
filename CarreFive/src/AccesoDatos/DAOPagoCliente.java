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
import modelo.PagoCliente;

public class DAOPagoCliente {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOPagoCliente(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarPagoCliente(PagoCliente pc) {
        boolean flag;
        String sql_guardar;
        sql_guardar = "INSERT INTO PagoCliente VALUES ('"
                + pc.getnroPago() + "', '"
                + pc.getidVenta() + "', '"
                + pc.getfechaPago() + "', '"
                + pc.getmonto() + "', '"
                + pc.getidEmpleado() + "')";
        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();
        return flag;
    }

    public ArrayList<PagoCliente> consultarPagoCliente(String idVenta) {
        ArrayList tupla = new ArrayList<PagoCliente>();
        String sql_select;
        sql_select = "SELECT * FROM PagoCliente WHERE idVenta = '" + idVenta + "';";
        System.out.println(sql_select);
        conexion.abrir();
        try {

            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                PagoCliente pc = new PagoCliente();
                pc.setnroPago(Integer.parseInt(tabla.getString(1)));
                pc.setidVenta(tabla.getString(2));
                pc.setfechaPago(tabla.getString(3));
                pc.setmonto(Double.parseDouble(tabla.getString(4)));
                pc.setidEmpleado(tabla.getString(5));
                tupla.add(pc);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();
        return tupla;

    }

    public ArrayList<PagoCliente> listarPagoCliente() {
        ArrayList<PagoCliente> tupla = new ArrayList<PagoCliente>();
        String sql_select;
        sql_select = "SELECT * FROM PagoCliente;";
        conexion.abrir();
        try {

            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                PagoCliente pc = new PagoCliente();
                pc.setnroPago(Integer.parseInt(tabla.getString(1)));
                pc.setidVenta(tabla.getString(2));
                pc.setfechaPago(tabla.getString(3));
                pc.setmonto(Double.parseDouble(tabla.getString(4)));
                pc.setidEmpleado(tabla.getString(5));
                tupla.add(pc);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();
        return tupla;

    }

    public int getIndicePagoCliente(String idVenta) {
        String sql;
        int indice = 0;
        sql = "select max(nropago) from pagoCliente where idVenta = '" + idVenta + "';";
        conexion.abrir();
        try {
            ResultSet consulta = conexion.obtenerSentencia().executeQuery(sql);
            
            while(consulta.next()){
                indice = Integer.parseInt(consulta.getString(1));
            }
        } catch (NumberFormatException | SQLException e ) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        conexion.cerrar();
        return indice;
    }
}
