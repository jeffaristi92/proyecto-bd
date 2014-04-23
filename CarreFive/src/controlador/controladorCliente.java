/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DAOCliente;
import AccesoDatos.FachadaBD;
import java.text.DecimalFormat;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author usuario
 */
public class controladorCliente {

    DAOCliente accesoCliente;

    public controladorCliente(FachadaBD f) {
        accesoCliente = new DAOCliente(f);
    }

    public ArrayList<Cliente> consultarCliente(String idCli,int opcion) {
        ArrayList<Cliente> c = accesoCliente.consultarCliente(idCli,opcion);
        return c;
    }

    public Object[][] listarClientes() {
        ArrayList<Cliente> lista = accesoCliente.listarClientes();
        Object datos[][] = new Object[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            datos[i][0] = lista.get(i).getidCliente();
            datos[i][1] = lista.get(i).getnombreCliente();
            datos[i][2] = lista.get(i).getapellidoCliente();
            datos[i][3] = lista.get(i).getdireccionCliente();
            datos[i][4] = lista.get(i).gettelefonoCliente();
            DecimalFormat formato = new DecimalFormat("###,###");
            datos[i][5] = formato.format(lista.get(i).getsaldoCliente());
        }
        return datos;
    }

    public boolean actualizarCliente(Cliente e) {
        boolean acutalizado =accesoCliente.actualizarCliente(e);
        return acutalizado;
    }

    public boolean registrarCliente(Cliente e) {
        boolean registrado=accesoCliente.guardarCliente(e);
        return registrado;
    }
}
