/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bdconexionjdbc;

/**
 *
 * @author Jmendoti
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BDconexionJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/pruebaconexionjdbc";
        Connection  conexion;
        Statement   statement;
        ResultSet result;
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BDconexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIOS (user, password) VALUE ('Naty', 'n19911')");
            result = statement.executeQuery("SELECT * FROM USUARIOS");
            result.next();
            do {
                System.out.println(result.getInt("id_user")+" : "+result.getString("user")+" : "+result.getString("password"));
            }while(result.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(BDconexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
