/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author usuario
 */
import AccesoDatos.DAOPagoProveedor;
import AccesoDatos.FachadaBD;
import java.util.ArrayList;
import modelo.PagoProveedor;

public class controladorPagoProveedor {

    DAOPagoProveedor accesoPagoProveedor;

    public controladorPagoProveedor(FachadaBD f) {
        accesoPagoProveedor = new DAOPagoProveedor(f);
    }

    public ArrayList<PagoProveedor> consultarPagoCProveedor(String idCompra) {
        ArrayList<PagoProveedor> lista = accesoPagoProveedor.consultarPagoProveedor(idCompra);
        return lista;
    }

    public Object[][] listarPagoProveedor() {
        ArrayList<PagoProveedor> lista = new ArrayList();
        lista = accesoPagoProveedor.listarPagoProveedor();
        Object datos[][] = new Object[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            datos[i][0] = lista.get(i).getnroPago();
            datos[i][1] = lista.get(i).getidCompra();
            datos[i][2] = lista.get(i).getfechaPago();
            datos[i][3] = lista.get(i).getmonto();
            datos[i][4] = lista.get(i).getidEmpleado();
        }
        return datos;
    }

    /*public void actualizarPagoProveedor(PagoProveedor pp){
     accesoPagoProveedor.actualizarPagoProveedor(pp);
     }*/
    public boolean registrarPagoProveedor(PagoProveedor pp) {
        return accesoPagoProveedor.guardarPagoProveedor(pp);
    }

    public int getIndicePagoProveedor(String idCompra) {
        int indice = accesoPagoProveedor.getIndicePagoProveedor(idCompra);
        return indice;
    }
}
