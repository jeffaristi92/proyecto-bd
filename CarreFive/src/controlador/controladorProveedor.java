/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DAOProveedor;
import AccesoDatos.FachadaBD;
import java.text.DecimalFormat;
import java.util.ArrayList;
import modelo.Proveedor;
/**
 *
 * @author usuario
 */
public class controladorProveedor {
    DAOProveedor accesoProveedor;
    
    
    public controladorProveedor(FachadaBD f){
        accesoProveedor=new DAOProveedor(f);
    }
    
    public boolean registrarProveedor(Proveedor obj){
        Boolean flag;
        flag= accesoProveedor.guardarProveedor(obj);
        return flag;
    }
    
    public ArrayList<Proveedor> consultarProveedor(String idPro,int op){
        ArrayList<Proveedor> lista= accesoProveedor.consultarProveedor(idPro, op);
        return lista;
    }
    
     public Object[][] listarProductos(){
        ArrayList<Proveedor> lista = new ArrayList();
        lista = accesoProveedor.listarProveedores();
        Object datos[][] = new Object[lista.size()][5];
        for(int i=0;i<lista.size();i++){
            datos[i][0]=lista.get(i).getidProveedor();
            datos[i][1]=lista.get(i).getnombreProveedor();
            datos[i][2]=lista.get(i).getdireccionProveedor();
            datos[i][3]=lista.get(i).gettelefonoProveedor();
            DecimalFormat formato = new DecimalFormat("###,###");
            datos[i][4]=formato.format(lista.get(i).getsaldoProveedor());
        }
        return datos;
    }
     
    public boolean actualizarProveedor(Proveedor p){
        boolean actualizado = accesoProveedor.actualizarProveedor(p);
        return actualizado;
    }
    
    public boolean eliminarProveedor(String idP){
        boolean eliminado = accesoProveedor.eliminarProveedor(idP);
        return eliminado;
    }
}
