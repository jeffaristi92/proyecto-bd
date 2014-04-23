/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DAOVenta;
import AccesoDatos.FachadaBD;
import java.util.ArrayList;
import modelo.Venta;

/**
 *
 * @author usuario
 */
public class controladorVenta {

    DAOVenta accesoVenta;

    public controladorVenta(FachadaBD f) {
        accesoVenta = new DAOVenta(f);
    }

    public Venta consultarVenta(String idVenta) {
        Venta v = new Venta();
        ArrayList<Venta> lista = accesoVenta.consultarVenta(idVenta);
        v = lista.get(0);
        return v;
    }
    
    public ArrayList<Venta> consultarVentasXCliente(String idCliente) {
        
        ArrayList<Venta> lista = accesoVenta.consultarVentasXCliente(idCliente);
        
        return lista;
    }

    public boolean registrarVenta(Venta v) {
        boolean aprobacion;
        aprobacion = accesoVenta.guardarVenta(v);
        return aprobacion;
    }
}
