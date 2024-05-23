/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author F I ENTERPRISES
 */

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectionToDB {
    
    Connection conn = null;
    
    public Connection EstablishConnection(){
    
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn=DriverManager.getConnection("jdbc:ucanaccess://D:\\LOGIN FINAL\\LOGIN\\src\\Database.accdb");
            //JOptionPane.showMessageDialog(null, "Connected");

        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        return conn;
    }
}


