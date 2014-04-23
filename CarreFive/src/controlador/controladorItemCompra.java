/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DAOItemCompra;
import AccesoDatos.FachadaBD;
import modelo.ItemCompra;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class controladorItemCompra {

    DAOItemCompra accesoItemCompra;

    public controladorItemCompra(FachadaBD f) {
        accesoItemCompra = new DAOItemCompra(f);
    }

    public void registrarItemCompra(ItemCompra c) {
        accesoItemCompra.guardarItemCompra(c);
    }

    public ArrayList<ItemCompra> buscarItemCompra(String idcompra) {
        ArrayList<ItemCompra> lista = accesoItemCompra.buscarItemCompra(idcompra);
        return lista;
    }
}
