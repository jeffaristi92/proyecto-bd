/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class ItemVenta {
    String nroItem;
    String idVenta;
    String idProducto;
    int cantidad;
    double iva;
    double vlrTotal;

    public ItemVenta(String nroItem, String idVenta, String idProducto, int cantidad, double iva, double vlrTotal) {
        this.nroItem = nroItem;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.iva = iva;
        this.vlrTotal = vlrTotal;
    }

    public ItemVenta() {
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
    public void setiva(double i){
        iva=i;
    }
    public double getiva(){
        return iva;
    }
    public void setvlrTotal(double total){
        vlrTotal=total;
    }
    public double getvlrTotal(){
        return vlrTotal;
    }
}
