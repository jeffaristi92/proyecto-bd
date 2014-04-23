/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author usuario
 */
import AccesoDatos.DAOEmpleado;
import AccesoDatos.FachadaBD;
import java.util.ArrayList;
import modelo.Empleado;

public class controladorEmpleado {

    DAOEmpleado accesoEmpleado;

    public controladorEmpleado(FachadaBD f) {
        accesoEmpleado = new DAOEmpleado(f);
    }

    public Empleado consultarEmpleado(String idEmp) {
        Empleado e = new Empleado();
        ArrayList<Empleado> lista = accesoEmpleado.consultarEmpleado(idEmp);
        e = lista.get(0);
        return e;
    }

    public Object[][] listarEmpleado() {
        ArrayList<Empleado> lista = new ArrayList();
        lista = accesoEmpleado.listarEmpleados();
        Object datos[][] = new Object[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            datos[i][0] = lista.get(i).getidEmpleado();
            datos[i][1] = lista.get(i).getnombreEmpleado();
            datos[i][2] = lista.get(i).getapellidoEmpleado();
            datos[i][3] = lista.get(i).getdireccionEmpleado();
            datos[i][4] = lista.get(i).gettelefonoEmpleado();
            datos[i][5] = lista.get(i).getcargoEmpleado();
        }
        return datos;
    }

    public boolean actualizarEmpleado(Empleado e) {
        boolean actualizado =accesoEmpleado.actualizarEmpleado(e);
        return actualizado;
    }

    public boolean registrarEmpleado(Empleado e) {
        boolean registrado = accesoEmpleado.guardarEmpleado(e);
        return registrado;
    }
}
