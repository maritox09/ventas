/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
   
      Connection con; 

    public Connection conexion(){

        try {
              Class.forName("com.mysql.jdbc.Driver");
              con=DriverManager.getConnection("jdbc:mysql://192.168.1.5:3306/main?","root","example");

        } catch (Exception e) {
            
        }
        return con;
    }
}
