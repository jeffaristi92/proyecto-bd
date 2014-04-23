/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Empleado {
    String idEmpleado;
    String nombreEmpleado;
    String apellidoEmpleado;
    String direccionEmpleado;
    String telefonoEmpleado;
    String cargoEmpleado;
    
    public void setidEmpleado(String idE){
        idEmpleado=idE;
    }
    public String getidEmpleado(){
        return idEmpleado;
    }
    public void setnombreEmpleado(String nomE){
        nombreEmpleado=nomE;
    }
    public String getnombreEmpleado(){
        return nombreEmpleado;
    }
    public void setapellidoEmpleado(String apE){
        apellidoEmpleado=apE;
    }
    public String getapellidoEmpleado(){
        return apellidoEmpleado;
    }
    public void setdireccionEmpleado(String dirE){
        direccionEmpleado=dirE;
    }
    public String getdireccionEmpleado(){
        return direccionEmpleado;
    }
    public void settelefonoEmpleado(String telE){
        telefonoEmpleado=telE;
    }
    public String gettelefonoEmpleado(){
        return telefonoEmpleado;
    }
    public void setcargoEmpleado(String cargoE){
        cargoEmpleado=cargoE;
    }
    public String getcargoEmpleado(){
        return cargoEmpleado;
    }
}
