/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author usuario
 */
public class DAOProducto {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOProducto(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarProducto(Producto p) {
        boolean flag=false;
        String sql_guardar;
        sql_guardar = "INSERT INTO Producto VALUES ('"
                + p.getidProducto() + "', '"
                + p.getdescripcion() + "', '"
                + p.getprecioCompra() + "', '"
                + p.getprecioVenta() + "', '"
                + p.getcantDisponible() + "','"
                + p.getidProveedor() + "')";
        System.out.println(sql_guardar);
        conexion.abrir();
        try {
            flag = conexion.actualizar(sql_guardar);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage());
        }
        
        conexion.cerrar();
        return flag;
    }

    public boolean actualizarProducto(Producto p) {
        boolean flag;
        String sql_guardar;
        sql_guardar = "UPDATE Producto SET "
                + "descripcion = '" + p.getdescripcion() + "',"
                + "precioVenta = " + p.getprecioVenta() + " "
                + "where idProducto='" + p.getidProducto() + "';";

        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();
        return flag;
    }

    public boolean eliminarProducto(String p) {
        return true;
    }

    public ArrayList<Producto> consultarProducto(String valor,int op) {
        boolean flag = false;
        ArrayList tupla = new ArrayList<Producto>();
        String columna="";
        String sql_select;
        sql_select = "SELECT * FROM Producto WHERE ";
        switch(op){
            case 0:
                sql_select +="idproducto = '"+valor+"';";
                columna = "Codigo";
                break;
            case 1:
                sql_select +="descripcion like '%"+valor+"%';";
                columna = "Descripcion";
                break;
        }
        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Producto p = new Producto();
                flag = true;
                p.setidProducto(tabla.getString(1));
                p.setdescripcion(tabla.getString(2));
                p.setprecioCompra(Double.parseDouble(tabla.getString(3)));
                p.setprecioVenta(Double.parseDouble(tabla.getString(4)));
                p.setcantDisponible(Integer.parseInt(tabla.getString(5)));
                p.setidProveedor(tabla.getString(6));
                tupla.add(p);
            }

            if (flag == false) {
                Producto p = new Producto();
                tupla.add(p);
                JOptionPane.showMessageDialog(null, "No fueron encontrados productos con " + columna
                        + " que coincida con "+ valor);
            }

        } catch (SQLException e) {
            Producto p = new Producto();
            tupla.add(p);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;

    }

    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> tupla = new ArrayList<Producto>();
        String sql_select;
        sql_select = "SELECT * FROM Producto;";
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                Producto p = new Producto();
                p.setidProducto(tabla.getString(1));
                p.setdescripcion(tabla.getString(2));
                p.setprecioCompra(Double.parseDouble(tabla.getString(3)));
                p.setprecioVenta(Double.parseDouble(tabla.getString(4)));
                p.setcantDisponible(Integer.parseInt(tabla.getString(5)));
                p.setidProveedor(tabla.getString(6));
                tupla.add(p);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;

    }
}
