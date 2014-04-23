/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Venta {

    String idVenta;
    String idEmpleado;
    String idCliente;
    String fechaVenta;
    double vlrTotal;
    double saldoVenta;

    public void setidVenta(String idV) {
        idVenta = idV;
    }

    public String getidVenta() {
        return idVenta;
    }

    public void setidEmpleado(String idE) {
        idEmpleado = idE;
    }

    public String getidEmpleado() {
        return idEmpleado;
    }

    public void setidCliente(String idC) {
        idCliente = idC;
    }

    public String getidCliente() {
        return idCliente;
    }

    public void setfechaVenta(String fecha) {
        fechaVenta = fecha;
    }

    public String getfechaVenta() {
        return fechaVenta;
    }

    public void setvlrTotal(double total) {
        vlrTotal = total;
    }

    public double getvlrTotal() {
        return vlrTotal;
    }

    public void setsaldoVenta(double saldo) {
        saldoVenta = saldo;
    }

    public double getsaldoVenta() {
        return saldoVenta;
    }
}
