/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoser;

/**
 *
 * @author usuario
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Joss
 */
public class bancoDAO {
    conexion conexion;
    
    public bancoDAO(){
        conexion = new conexion();
    }
    public String verificaUsuario(int ctabancaria){        
        Connection accesoDB = conexion.getConexion();
        try {            
            PreparedStatement ps = accesoDB.prepareStatement("select * from cuentas where ctabancaria=?");
            ps.setInt(1, ctabancaria);              
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               int ax = rs.getInt("saldo");
               if (ax > 60)
               {                   
                   ax = ax - 60;
                    PreparedStatement dd = accesoDB.prepareStatement("update cuentas set saldo= ? where ctabancaria=?");
                    dd.setInt(1, ax);
                    dd.setInt(2, ctabancaria);
                    int  ds = dd.executeUpdate();
                    return "si";
               }               
            }               
            }
         catch (Exception e) {
           
        }
        return "no conexion";
        
}}