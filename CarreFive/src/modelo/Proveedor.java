/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Proveedor {
    String idProveedor;
    String nombreProveedor;
    String direccionProveedor;
    String telefonoProveedor;
    double saldoProveedor;

    public Proveedor() {
    }

    public Proveedor(String idProveedor, String nombreProveedor, String direccionProveedor, String telefonoProveedor, double saldoProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.saldoProveedor = saldoProveedor;
    }
    
    public void setidProveedor(String idP){
        idProveedor=idP;
    }
    public String getidProveedor(){
        return idProveedor;
    }
    public void setnombreProveedor(String nomP){
        nombreProveedor=nomP;
    }
    public String getnombreProveedor(){
        return nombreProveedor;
    }
    public void setdireccionProveedor(String dirP){
        direccionProveedor=dirP;
    }
    public String getdireccionProveedor(){
        return direccionProveedor;
    }
    public void settelefonoProveedor(String telP){
        telefonoProveedor=telP;
    }
    public String gettelefonoProveedor(){
        return telefonoProveedor;
    }
    public void setsaldoProveedor(double saldo){
        saldoProveedor=saldo;
    }
    public double getsaldoProveedor(){
        return saldoProveedor;
    }
}
