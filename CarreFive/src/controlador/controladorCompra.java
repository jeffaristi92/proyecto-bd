/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DAOCompra;
import AccesoDatos.FachadaBD;
import java.util.ArrayList;
import modelo.Compra;
/**
 *
 * @author usuario
 */
public class controladorCompra {
    DAOCompra accesoCompra;
    
    public controladorCompra(FachadaBD f){
        accesoCompra=new DAOCompra(f);
    }
    
    public Compra consultarCompra(String idCompra){
        Compra p = new Compra();
        ArrayList<Compra> lista= accesoCompra.consultarCompra(idCompra);
        p=lista.get(0);
        return p;
    }
    
    public boolean registrarCompra(Compra c){
       boolean registrado=accesoCompra.guardarCompra(c);
        return registrado;
    }
    
    public ArrayList<Compra> consultarComprasXProveedor(String idProveedor) {
        ArrayList<Compra> lista = accesoCompra.consultarComprasXProveedor(idProveedor);
        return lista;
    }
}
