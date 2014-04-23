/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.ItemCompra;
/**
 *
 * @author usuario
 */
public class DAOItemCompra {
    FachadaBD fachada;
    ConexionBD conexion;
    
    public DAOItemCompra(FachadaBD f){
        fachada = f;
        conexion = new ConexionBD(fachada);
    }
    
    public boolean guardarItemCompra(ItemCompra obj) {
        boolean flag;
        String sql_guardar;
        sql_guardar = "INSERT INTO itemCompra VALUES ('"
                + obj.getnroItem() + "', '"
                + obj.getidCompra() + "', '"
                + obj.getidProducto() + "', '"
                + obj.getcantidad() + "', '"
                + obj.getvlrTotal() + "')";
        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        System.out.println(sql_guardar);
        conexion.cerrar();
        return flag;
    }
    
    public ArrayList<ItemCompra> buscarItemCompra( String valor) {
        ArrayList tupla = new ArrayList<ItemCompra>();
        String sql_select;
        sql_select = "SELECT * FROM ItemCompra WHERE " + "idcompra" + " = '" + valor + "';";
        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                ItemCompra p = new ItemCompra();
                p.setnroItem(tabla.getString(1));
                p.setidCompra(tabla.getString(2));
                p.setidProducto(tabla.getString(3));
                p.setcantidad(Integer.parseInt(tabla.getString(4)));
                p.setvlrTotal(Double.parseDouble(tabla.getString(5)));
                tupla.add(p);
            }

        } catch (Exception e) {
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;

    }
}
