/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class PagoCliente {
    int nroPago;
    String idVenta;
    String fechaPago;
    double monto;
    String idEmpleado;
    
    public void setnroPago(int nP){
        nroPago=nP;
    }
    public int getnroPago(){
        return nroPago;
    }
    public void setidVenta(String idV){
        idVenta=idV;
    }
    public String getidVenta(){
        return idVenta;
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
