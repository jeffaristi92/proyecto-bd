/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.ItemVenta;

/**
 *
 * @author usuario
 */
public class DAOItemVenta {

    FachadaBD fachada;
    ConexionBD conexion;

    public DAOItemVenta(FachadaBD f) {
        fachada = f;
        conexion = new ConexionBD(fachada);
    }

    public boolean guardarItemVenta(ItemVenta objV) {
        boolean flag = false;
        String sql_guardar;
        sql_guardar = "INSERT INTO ItemVenta VALUES ('"
                + objV.getnroItem() + "','"
                + objV.getidVenta() + "', '"
                + objV.getidProducto() + "', '"
                + objV.getcantidad() + "', '"
                + objV.getiva() + "', '"
                + objV.getvlrTotal() + " ')";
        conexion.abrir();
        flag = conexion.actualizar(sql_guardar);
        conexion.cerrar();

        return flag;
    }

    public void eliminarItemEnVenta(String nroItem, String idVenta) {
        conexion.abrir();
        String query = "DELETE FROM ItemVenta WHERE nroitem = '" + nroItem + "' AND idVenta = " + idVenta + "'";
        conexion.actualizar(query);
        conexion.cerrar();
        return;
    }

    public void editarCantidadProducto(int cantNueva, String codVenta, String codProduc) {
        String sql_editar;
        sql_editar = "UPDATE Vehiculo SET cantidad = '" + cantNueva + "' WHERE idVenta = '" + codVenta + "' AND idproducto = '" + codProduc + "'";
        conexion.abrir();
        conexion.actualizar(sql_editar);
        conexion.cerrar();
    }

    public ArrayList<ItemVenta> consultarItemVenta(String idVenta) {

        ArrayList<ItemVenta> tupla = new ArrayList<ItemVenta>();
        String sql_select;

        sql_select = "SELECT * FROM ItemVenta WHERE idVenta = '" + idVenta+"';";

        System.out.println(sql_select);
        try {
            conexion.abrir();
            ResultSet tabla = conexion.obtenerSentencia().executeQuery(sql_select);

            while (tabla.next()) {
                ItemVenta v = new ItemVenta();
                v.setnroItem(tabla.getString(1));
                v.setidVenta(tabla.getString(2));
                v.setidProducto(tabla.getString(3));
                v.setcantidad(Integer.parseInt(tabla.getString(4)));
                v.setiva(Double.parseDouble(tabla.getString(5)));
                v.setvlrTotal(Double.parseDouble(tabla.getString(6)));
                tupla.add(v);
            }
        } catch (Exception e) {
        }
        conexion.cerrar();
        System.out.println(tupla);
        return tupla;
    }
}
