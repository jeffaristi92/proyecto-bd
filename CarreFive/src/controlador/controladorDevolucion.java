/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author usuario
 */
import AccesoDatos.DAODevolucion;
import AccesoDatos.FachadaBD;
import java.util.ArrayList;
import modelo.Devolucion;

public class controladorDevolucion {
    
    DAODevolucion accesoDevolucion;
    
    public controladorDevolucion(FachadaBD f){
        accesoDevolucion=new DAODevolucion(f);
    }
    
    public Devolucion consultarDevolucion(String idDev){
        Devolucion d = new Devolucion();
        ArrayList<Devolucion> lista= accesoDevolucion.consultarDevolucion(idDev);
        d=lista.get(0);
        return d;
    }
    
    public Object[][] listarDevolucion(){
        ArrayList<Devolucion> lista = new ArrayList();
        lista = accesoDevolucion.listarDevoluciones();
        Object datos[][] = new Object[lista.size()][6];
        for(int i=0;i<lista.size();i++){
            datos[i][0]=lista.get(i).getidDevolucion();
            datos[i][1]=lista.get(i).getnroItem();
            datos[i][2]=lista.get(i).getidVenta();
            datos[i][3]=lista.get(i).getmotivo();
            datos[i][4]=lista.get(i).getcantidad();
            datos[i][5]=lista.get(i).getfechaDevolucion();
        }
        return datos;
    }     
    
    /*public void actualizarDevolucion(Devolucion d){
        accesoDevolucion.actualizarDevolucion(d);
    }*/
    
    public void registrarDevolucion(Devolucion d){
       accesoDevolucion.guardarDevolucion(d);
    }
    
}
