/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author usuario
 */
import AccesoDatos.DAOPagoCliente;
import AccesoDatos.FachadaBD;
import java.util.ArrayList;
import modelo.PagoCliente;

public class controladorPagoCliente {

    DAOPagoCliente accesoPagoCliente;

    public controladorPagoCliente(FachadaBD f) {
        accesoPagoCliente = new DAOPagoCliente(f);
    }

    public ArrayList<PagoCliente> consultarPagoCliente(String idVenta) {
        ArrayList<PagoCliente> lista = accesoPagoCliente.consultarPagoCliente(idVenta);
        return lista;
    }
    /*
    public Object[][] listarPagoCliente() {
        ArrayList<PagoCliente> lista = new ArrayList();
        lista = accesoPagoCliente.listarPagoCliente();
        Object datos[][] = new Object[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            datos[i][0] = lista.get(i).getnroPago();
            datos[i][1] = lista.get(i).getidVenta();
            datos[i][2] = lista.get(i).getfechaPago();
            datos[i][3] = lista.get(i).getmonto();
            datos[i][4] = lista.get(i).getidEmpleado();
        }
        return datos;
    }*/

    /*public void actualizarPagoCliente(PagoCliente pc){
     accesoPagoCliente.actualizarPagoCliente(pc);
     }*/
    public boolean registrarPagoCliente(PagoCliente pc) {
        return accesoPagoCliente.guardarPagoCliente(pc);
    }

    public int getIndicePagoCliente(String idVenta) {
        int indice = accesoPagoCliente.getIndicePagoCliente(idVenta);
        return indice;
    }
}
