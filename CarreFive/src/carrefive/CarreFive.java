/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package carrefive;

import AccesoDatos.FachadaBD;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vista.InterfazPrincipal;
import vista.Login;

/**
 *
 * @author usuario
 */
public class CarreFive {

    /**
     * @param args the command line arguments
     */
    FachadaBD fachada;
    public Login login;
    public InterfazPrincipal principal;
    public CarreFive(){
        String url="jdbc:postgresql://localhost:5432/CarreFive";
	String	usuario="admin";
	String	password="admin";
        fachada = new FachadaBD(url,usuario,password);
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {

            JOptionPane.showMessageDialog(null, "Imposible modificar el tema visual" + ex.getMessage(), "", JOptionPane.ERROR_MESSAGE);
        }
        
        login = new Login(fachada);
        login.setVisible(true);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        CarreFive programa = new CarreFive();
    }
}
