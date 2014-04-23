/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class ItemCompra {
    String nroItem;
    String idCompra;
    String idProducto;
    int cantidad;
    double vlrTotal;
    
    public void setnroItem(String nroI){
        nroItem=nroI;
    }
    public String getnroItem(){
        return nroItem;
    }
    public void setidCompra(String idC){
        idCompra=idC;
    }
    public String getidCompra(){
        return idCompra;
    }
    public void setidProducto(String idP){
        idProducto=idP;
    }
    public String getidProducto(){
        return idProducto;
    }
    public void setcantidad(int cant){
        cantidad=cant;
    }
    public int getcantidad(){
        return cantidad;
    }
    public void setvlrTotal(double total){
        vlrTotal=total;
    }
    public double getvlrTotal(){
        return vlrTotal;
    }
}
