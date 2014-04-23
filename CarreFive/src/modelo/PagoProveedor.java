/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class PagoProveedor {
    int nroPago;
    String idCompra;
    String fechaPago;
    double monto;
    String idEmpleado;
    
    public void setnroPago(int nroP){
        nroPago=nroP;
    }
    public int getnroPago(){
        return nroPago;
    }
    public void setidCompra(String idC){
        idCompra=idC;
    }
    public String getidCompra(){
        return idCompra;
    }
    public void setfechaPago(String fecha){
        fechaPago=fecha;
    }
    public String getfechaPago(){
        return fechaPago;
    }
    public void setmonto(double m){
        monto=m;
    }
    public double getmonto(){
        return monto;
    }
    public void setidEmpleado(String idE){
        idEmpleado=idE;
    }
    public String getidEmpleado(){
        return idEmpleado;
    }
}
