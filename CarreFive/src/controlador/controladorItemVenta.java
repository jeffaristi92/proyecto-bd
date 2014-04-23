/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DAOItemVenta;
import AccesoDatos.FachadaBD;
import java.util.ArrayList;
import modelo.ItemVenta;

/**
 *
 * @author usuario
 */
public class controladorItemVenta {
    DAOItemVenta accesoItemVenta;
    
    public controladorItemVenta(FachadaBD f){
        accesoItemVenta = new DAOItemVenta(f);
    }
    
    public void registrarItemVenta(ItemVenta iv) {
        accesoItemVenta.guardarItemVenta(iv);
    }

    public ArrayList<ItemVenta> buscarItemVenta(String idVenta) {
        ArrayList<ItemVenta> lista = accesoItemVenta.consultarItemVenta(idVenta);
        return lista;
    }
}
