/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class conexion {
    public conexion() {
    }

    public Connection getConexion(){
        Connection con=null;
        try{
            /* Carga|Registra el driver JDBC */
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /* Obtener la conexion */
	    con = DriverManager.getConnection("jdbc:mysql://107.180.47.12:3306/bancoUG","josevai","Leave#Jose");
            
        }catch(SQLException ex){
        }catch(Exception e){   
        }
        return con;
    } 
}
