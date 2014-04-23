/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Devolucion {
    String idDevolucion;
    String nroItem;
    String idVenta; 
    String motivo;
    int cantidad;
    String fechaDevolucion;
    
    public void setidDevolucion(String idD){
        idDevolucion=idD;
    }
    public String getidDevolucion(){
        return idDevolucion;
    }
    public void setnroItem(String nroI){
        nroItem=nroI;
    }
    public String getnroItem(){
        return nroItem;
    }
    public void setidVenta(String idV){
        idVenta=idV;
    }
    public String getidVenta(){
        return idVenta;
    }
    public void setmotivo(String m){
        motivo=m;
    }
    public String getmotivo(){
        return motivo;
    }
    public void setcantidad(int cant){
        cantidad=cant;
    }
    public int getcantidad(){
        return cantidad;
    }
    public void setfechaDevolucion(String fecha){
        fechaDevolucion = fecha;
    }
    
    public String getfechaDevolucion(){
        return fechaDevolucion;
    }
}
