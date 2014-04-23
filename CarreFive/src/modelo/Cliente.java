/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Cliente {

    String idCliente;
    String nombreCliente;
    String apellidoCliente;
    String direccionCliente;
    String telefonoCliente;
    double saldoCliente;

    public Cliente() {
    }
    
    public Cliente(String idCliente, String nombreCliente, String apellidoCliente, String direccionCliente, String telefonoCliente, double saldoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.telefonoCliente = telefonoCliente;
        this.saldoCliente = saldoCliente;
    }
    
    
    public void setidCliente(String idC){
        idCliente=idC;
    }
    public String getidCliente(){
        return idCliente;
    }
    public void setnombreCliente(String nomC){
        nombreCliente=nomC;
    }
    public String getnombreCliente(){
        return nombreCliente;
    }
    public void setapellidoCliente(String apC){
        apellidoCliente=apC;
    }
    public String getapellidoCliente(){
        return apellidoCliente;
    }
    public void setdireccionCliente(String dirC){
        direccionCliente=dirC;
    }
    public String getdireccionCliente(){
        return direccionCliente;
    }
    public void settelefonoCliente(String telC){
        telefonoCliente=telC;
    }
    public String gettelefonoCliente(){
        return telefonoCliente;
    }
    public void setsaldoCliente(double saldo){
        saldoCliente=saldo;
    }
    public double getsaldoCliente(){
        return saldoCliente;
    }
}
