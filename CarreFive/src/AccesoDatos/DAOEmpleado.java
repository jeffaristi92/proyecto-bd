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
import modelo.Empleado;

public class DAOEmpleado {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOEmpleado(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarEmpleado(Empleado e) {
        boolean flag = false;
        String sql_guardar = "INSERT INTO Empleado Values('"
                + e.getidEmpleado() + "','"
                + e.getnombreEmpleado() + "','"
                + e.getapellidoEmpleado() + "','"
                + e.getdireccionEmpleado() + "','"
                + e.gettelefonoEmpleado() + "','"
                + e.getcargoEmpleado() + "');";

        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();

        return flag;
    }

    public ArrayList<Empleado> consultarEmpleado(String cedula) {
        boolean flag= false;
        ArrayList<Empleado> tupla = new ArrayList<Empleado>();
        
        String sql_select;
        sql_select = "SELECT * FROM Empleado WHERE idEmpleado = '" + cedula + "'";
        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
            Empleado e = new Empleado();
            e.setidEmpleado(tabla.getString(1));
            e.setnombreEmpleado(tabla.getString(2));
            e.setapellidoEmpleado(tabla.getString(3));
            e.setdireccionEmpleado(tabla.getString(4));
            e.settelefonoEmpleado(tabla.getString(5));
            e.setcargoEmpleado(tabla.getString(6));
            tupla.add(e);
            flag = true;
            }
            
            if(flag==false){
                Empleado e = new Empleado();
                tupla.add(e);
                JOptionPane.showMessageDialog(null,"El empleado "+ cedula+
                        "no fue encontrado");
            }
        } catch (Exception ex) {
             Empleado e = new Empleado();
                tupla.add(e);
                JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        conexion.cerrar();
        //System.out.println(e);
        return tupla;
    }

    public boolean actualizarEmpleado(Empleado e) {
        boolean flag = false;
        String sql_guardar;
        sql_guardar = "UPDATE Empleado SET direccionEmpleado = '"
                + e.getdireccionEmpleado()
                + "', telefonoEmpleado = '" + e.gettelefonoEmpleado()
                + "', cargoEmpleado = '" + e.getcargoEmpleado() + "'"
                + " WHERE idEmpleado = '" + e.getidEmpleado() + "';";
        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();
        return flag;
    }

    public ArrayList<Empleado> listarEmpleados() {
        ArrayList<Empleado> tupla = new ArrayList<Empleado>();
        String sql_select;
        sql_select = "SELECT * FROM Empleado;";
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Empleado e = new Empleado();
                e.setidEmpleado(tabla.getString(1));
                e.setnombreEmpleado(tabla.getString(2));
                e.setapellidoEmpleado(tabla.getString(3));
                e.setdireccionEmpleado(tabla.getString(4));
                e.settelefonoEmpleado(tabla.getString(5));
                e.setcargoEmpleado(tabla.getString(6));
                tupla.add(e);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;

    }
}
