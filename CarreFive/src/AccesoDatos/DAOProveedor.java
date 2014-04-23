/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Proveedor;

/**
 *
 * @author usuario
 */
public class DAOProveedor {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOProveedor(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarProveedor(Proveedor obj) {
        boolean flag;
        String sql_guardar;
        sql_guardar = "INSERT INTO Proveedor VALUES ('"
                + obj.getidProveedor() + "', '"
                + obj.getnombreProveedor() + "', '"
                + obj.getdireccionProveedor() + "', '"
                + obj.gettelefonoProveedor() + "', '"
                + obj.getsaldoProveedor() + "')";
        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();
        return flag;
    }

    public ArrayList<Proveedor> consultarProveedor(String valor,int op) {
        boolean flag = false;
        ArrayList<Proveedor> tupla = new ArrayList<Proveedor>();
        String columna="";
        String sql_select;
        sql_select = "SELECT * FROM Proveedor ";
        switch(op){
            case 0:
                sql_select+="WHERE idProveedor = '" + valor + "'";
                columna = "NIT";
                break;
            case 1:
                sql_select+="WHERE nombreProveedor = '" + valor + "'";
                columna = "Nombre";
                break;
        }
        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {

                Proveedor p = new Proveedor();
                p.setidProveedor(tabla.getString(1));
                p.setnombreProveedor(tabla.getString(2));
                p.setdireccionProveedor(tabla.getString(3));
                p.settelefonoProveedor(tabla.getString(4));
                p.setsaldoProveedor(Double.parseDouble(tabla.getString(5)));
                tupla.add(p);
                flag = true;
            }

            if (flag == false) {
                Proveedor p = new Proveedor();
                tupla.add(p);
                JOptionPane.showMessageDialog(null, "No fueron encontrados proveedorores con " +columna + " que coincida con "+valor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            Proveedor p = new Proveedor();
            tupla.add(p);
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;
    }

    public boolean actualizarProveedor(Proveedor obj) {
        boolean flag = false;
        String sql_guardar;
        sql_guardar = "UPDATE Proveedor SET idproveedor = '"
                + obj.getidProveedor()
                + "', nombreProveedor = '" + obj.getnombreProveedor()
                + "', telefonoProveedor = '" + obj.gettelefonoProveedor()
                + "', direccionProveedor = '" + obj.getdireccionProveedor() + "'"
                + " WHERE idProveedor = '" + obj.getidProveedor() + "';";
        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();
        return flag;
    }

    public boolean eliminarProveedor(String nit) {
        boolean flag = false;
        String query = "DELETE FROM Proveedor WHERE idProveedor = '" + nit + "'";

        conexion.abrir();
        try {
            flag = conexion.actualizar(query);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
        conexion.cerrar();
        return flag;
    }

    public ArrayList<Proveedor> listarProveedores() {
        ArrayList<Proveedor> tupla = new ArrayList<Proveedor>();
        String sql_select;
        sql_select = "SELECT * FROM Proveedor;";
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Proveedor p = new Proveedor();
                p.setidProveedor(tabla.getString(1));
                p.setnombreProveedor(tabla.getString(2));
                p.setdireccionProveedor(tabla.getString(3));
                p.settelefonoProveedor(tabla.getString(4));
                p.setsaldoProveedor(Double.parseDouble(tabla.getString(5)));
                tupla.add(p);
            }

        } catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;

    }
}
