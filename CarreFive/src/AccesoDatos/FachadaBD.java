package AccesoDatos;

import java.sql.*;

public class FachadaBD {

    String url, usuario, password;
    Connection conexion;
    Statement instruccion;
    ResultSet tabla;

    public FachadaBD(String ur, String us, String pw) {

        url = ur;
        usuario = us;
        password = pw;
    }

    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Cargado");
        } catch (Exception e) {
            System.out.println("No se pudo cargar el driver. "+ e.getMessage());
        }

        try {
            ///Crear el objeto de conexion a la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion Abierta");
            return conexion;
            ///Crear objeto Statement para realizar queries a la base de datos
        } catch (Exception e) {
            System.out.println("No se pudo abrir la bd. "+e.getMessage());
            return null;
        }
    }

    public void cerrarConexion(Connection c) {
        try {
            c.close();
            System.out.println("Conexion Cerrada");
        } catch (Exception e) {
            System.out.println("No se pudo cerrar. "+ e.getMessage());
        }
    }
}
