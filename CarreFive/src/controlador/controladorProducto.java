/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import AccesoDatos.DAOProducto;
import AccesoDatos.FachadaBD;
import java.text.DecimalFormat;
import java.util.ArrayList;
import modelo.Producto;

/**
 *
 * @author usuario
 */
public class controladorProducto {
    DAOProducto accesoProducto;
    
    public controladorProducto(FachadaBD f){
        accesoProducto=new DAOProducto(f);
    }
    
    public ArrayList<Producto> consultarProducto(String idPro,int op){
        ArrayList<Producto> lista= accesoProducto.consultarProducto(idPro,op);

        return lista;
    }
    
    public Object[][] listarProductos(){
        ArrayList<Producto> lista = new ArrayList();
        lista = accesoProducto.listarProductos();
        Object datos[][] = new Object[lista.size()][6];
        for(int i=0;i<lista.size();i++){
            datos[i][0]=lista.get(i).getidProducto();
            datos[i][1]=lista.get(i).getdescripcion();
            DecimalFormat formato = new DecimalFormat("###,###");
            datos[i][2]=formato.format(lista.get(i).getprecioCompra());
            datos[i][3]=formato.format(lista.get(i).getprecioVenta());
            datos[i][4]=lista.get(i).getcantDisponible();
            datos[i][5]=lista.get(i).getidProveedor();
        }
        return datos;
    } 
    
    public boolean actualizarProducto(Producto p){
        boolean actualizado = accesoProducto.actualizarProducto(p);
        return actualizado;
    }
    
    public boolean registrarProducto(Producto p){
       boolean registrado = accesoProducto.guardarProducto(p);
       return registrado;
    }
}
