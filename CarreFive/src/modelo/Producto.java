/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Producto {
    String idProducto;
    String descripcion;
    double precioCompra;
    double precioVenta;
    int cantDisponible;
    String idProveedor;

    public Producto() {
    }
    
    public Producto(String idProducto, String descripcion, double precioCompra, double precioVenta, int cantDisponible, String idProveedor) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantDisponible = cantDisponible;
        this.idProveedor = idProveedor;
    }
    
    
    public void setidProducto(String idP){
        idProducto=idP;
    }
    public String getidProducto(){
        return idProducto;
    }
    public void setdescripcion(String desc){
        descripcion=desc;
    }
    public String getdescripcion(){
        return descripcion;
    }
    public void setprecioCompra(double pComp){
        precioCompra=pComp;
    }
    public double getprecioCompra(){
        return precioCompra;
    }
    public void setprecioVenta(double pVen){
        precioVenta=pVen;
    }
    public double getprecioVenta(){
        return precioVenta;
    }
    public void setcantDisponible(int cantD){
        cantDisponible=cantD;
    }
    public int getcantDisponible(){
        return cantDisponible;
    }
    public void setidProveedor(String idP){
        idProveedor=idP;
    }
    public String getidProveedor(){
        return idProveedor;
    }
}
