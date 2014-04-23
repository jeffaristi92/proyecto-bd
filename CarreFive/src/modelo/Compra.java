/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Compra {
    String idCompra;
    String idProveedor;
    String idEmpleado;
    String fechaCompra;
    double vlrTotal;  
    String saldoCompra;
    
    public void setidCompra(String idC){
        idCompra=idC;
    }
    public String getidCompra(){
        return idCompra;
    }
    public void setidProveedor(String idP){
        idProveedor=idP;
    }
    public String getidProveedor(){
        return idProveedor;
    }
    public void setidEmpleado(String idE){
        idEmpleado=idE;
    }
    public String getidEmpleado(){
        return idEmpleado;
    }
    public void setfechaCompra(String fecha){
        fechaCompra=fecha;
    }
    public String getfechaCompra(){
        return fechaCompra;
    }
    public void setvlrTotal(double total){
        vlrTotal=total;
    }
    public double getvlrTotal(){
        return vlrTotal;
    }
    public void setsaldoCompra(String saldo){
        saldoCompra=saldo;
    }
    public String getsaldoCompra(){
        return saldoCompra;
    }
}
