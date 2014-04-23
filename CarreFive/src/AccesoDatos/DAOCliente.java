/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;

/**
 *
 * @author usuario
 */
public class DAOCliente {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOCliente(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarCliente(Cliente objC) {
        boolean flag = false;
        String sql_guardar;
        sql_guardar = "INSERT INTO Cliente VALUES ('"
                + objC.getidCliente() + "', '"
                + objC.getnombreCliente() + "', '"
                + objC.getapellidoCliente() + "', '"
                + objC.getdireccionCliente() + "', '"
                + objC.gettelefonoCliente() + "', '"
                + objC.getsaldoCliente() + "')";
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

    public ArrayList<Cliente> consultarCliente(String valor, int opcion) {

        boolean flag = false;

        ArrayList<Cliente> tupla = new ArrayList<Cliente>();
        
        String sql_select ="";
        String columna ="";
        
        
        switch(opcion){
            case 0:
                sql_select = "SELECT * FROM Cliente WHERE idCliente = '" + valor + "'";
                columna = "Cedula";
                break;
            case 1:
                sql_select = "SELECT * FROM Cliente WHERE nombreCliente like '%" + valor + "%'";
                columna = "Nombre";
                break;
            case 2:
                sql_select = "SELECT * FROM Cliente WHERE apellidoCliente like'%" + valor + "%'";
                columna = "Apellido";
                break;
        }
        
        System.out.println(sql_select);
        conexion.abrir();
        try {

            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Cliente c = new Cliente();
                c.setidCliente(tabla.getString(1));
                c.setnombreCliente(tabla.getString(2));
                c.setapellidoCliente(tabla.getString(3));
                c.setdireccionCliente(tabla.getString(4));
                c.settelefonoCliente(tabla.getString(5));
                c.setsaldoCliente(Double.parseDouble(tabla.getString(6)));
                tupla.add(c);
                flag = true;
            }

            if (flag == false) {
                JOptionPane.showMessageDialog(null, "No fueron encontrados clientes con " + columna
                        + " que coincida con "+ valor);
            }

        } catch (SQLException exp) {
            flag = false;
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
        conexion.cerrar();
        return tupla;
    }

    public boolean actualizarCliente(Cliente objCliente) {
        boolean flag = false;
        String sql_guardar;
        sql_guardar = "UPDATE Cliente SET "
                +"idCliente = '" + objCliente.getidCliente()
                + "', direccionCliente = '"+ objCliente.getdireccionCliente()
                + "', telefonoCliente = '" + objCliente.gettelefonoCliente()
                + "', saldoCliente = '" + objCliente.getsaldoCliente() + "'"
                + " WHERE idCliente = '" + objCliente.getidCliente() + "';";

        
        try {
            conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();

        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
        
        return flag;
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        String sql_select;
        sql_select = "SELECT * FROM Cliente;";
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Cliente c = new Cliente();
                c.setidCliente(tabla.getString(1));
                c.setnombreCliente(tabla.getString(2));
                c.setapellidoCliente(tabla.getString(3));
                c.setdireccionCliente(tabla.getString(4));
                c.settelefonoCliente(tabla.getString(5));
                c.setsaldoCliente(Double.parseDouble(tabla.getString(6)));
                lista.add(c);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();

        return lista;
    }
}
