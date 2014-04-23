package AccesoDatos;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionBD {

    FachadaBD fachada;
    Statement sentencia;
    Connection conn;

    public ConexionBD(FachadaBD f) {
        fachada = f;
    }

    public void abrir() {
        
        try {
            conn = fachada.conectar();
            sentencia = conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al abrir: "+e.getMessage());
        }
    }

    public Statement obtenerSentencia() {
        return sentencia;
    }

    public void cerrar() {
        try {
            conn.close();
            fachada.cerrarConexion(conn);
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean actualizar(String sql) {
        try {
            sentencia.executeUpdate(sql);
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,e.getMessage());
            return false;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
