/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;
import java.sql.*;

/**
 *
 * @author 50369
 */
public class ConnectionSQL {
    public static Connection getConexion(){
    String conexionUrl  = "jdbc:sqlserver://localhost:1433;" // <- Editar por su puerto de SQL
                            + "databaseName=dbMindLink;" // <- Editar por su base de datos
                            + "user=user1;"
                            + "password=user1;" 
                            + "encrypt=true;trustServerCertificate=true";
        
        //Retornamos la conexion
        try{
            //Creamos una variable de tipo Connection, al que le pasamos nuestra cadena de conexion
            Connection conn = DriverManager.getConnection(conexionUrl) ;
            //SI funciona, retornamos la conexion
            return conn;
        }catch(SQLException ex){
            //Si no funciona, imprimimos en consola el error y retornamos un valor nulo
            System.out.println(ex.toString());
            return null;
        }
    }
}
