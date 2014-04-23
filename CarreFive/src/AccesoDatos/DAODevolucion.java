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
import modelo.Compra;
import modelo.Devolucion;

public class DAODevolucion {
    FachadaBD fachada;
    ConexionBD conexion;
    
    
    public DAODevolucion(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarDevolucion(Devolucion d) {
        boolean flag;
        String sql_guardar;
        sql_guardar = "INSERT INTO Devolucion VALUES ('"
                + d.getidDevolucion() + "', '"
                + d.getnroItem() + "', '"
                + d.getidVenta() + "', '"
                + d.getmotivo() + "', '"
                + d.getcantidad() + "','"
                + d.getfechaDevolucion() + "')";
        conexion.abrir();
        try {
            flag = conexion.actualizar(sql_guardar);
        } catch (Exception exp) {
            flag = false;
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
        conexion.cerrar();
        return flag;
    }

    /*public boolean actualizarDevolucion(Devolucion d) {
        boolean flag;
        String sql_guardar;
        sql_guardar = "UPDATE Devolucion SET "
                + "motivo = '" + d.getmotivo() + "', '"
                + "cantidad" + d.getcantidad() + "', '"
                + "fechaDevolucion" + d.getfechaDevolucion() + "', '"
                + "where idDevolucion='" + d.getidDevolucion() + 
                         "AND nroItem ='" + d.getnroItem() + 
                         "AND idVenta ='"+ d.getidVenta() + "';";

        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();
        return flag;
    } */ //no veo necesaria la actualizacion de una devolucion pero la dejo aqui por si acaso

    

    public ArrayList<Devolucion> consultarDevolucion(String idDevolucion) {
        ArrayList tupla = new ArrayList<Devolucion>();
        String sql_select;
        sql_select = "SELECT * FROM Devolucion WHERE idDevolucion = '" + idDevolucion + "'";
        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Devolucion d = new Devolucion();
                d.setidDevolucion(tabla.getString(1));
                d.setnroItem(tabla.getString(2));
                d.setidVenta(tabla.getString(3));
                d.setmotivo(tabla.getString(4));
                d.setcantidad(Integer.parseInt(tabla.getString(5)));
                d.setfechaDevolucion(tabla.getString(6));
                tupla.add(d);
            }

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
            Devolucion d = new Devolucion();
            tupla.add(d);
            
        }
        conexion.cerrar();
        return tupla;

    }

    public ArrayList<Devolucion> listarDevoluciones() {
        ArrayList<Devolucion> tupla = new ArrayList<Devolucion>();
        String sql_select;
        sql_select = "SELECT * FROM Devolucion;";
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Devolucion d = new Devolucion();
                d.setidDevolucion(tabla.getString(1));
                d.setnroItem(tabla.getString(2));
                d.setidVenta(tabla.getString(3));
                d.setmotivo(tabla.getString(4));
                d.setcantidad(Integer.parseInt(tabla.getString(5)));
                d.setfechaDevolucion(tabla.getString(6));
                tupla.add(d);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;
    }
    
}
