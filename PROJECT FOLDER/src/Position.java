
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Xmart
 */
public class Position extends Employee{
    
        ConnectionToDB conn = new ConnectionToDB();
    Connection con_obj = conn.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    
    
    
    
    
    private int id;
    private String position;

    public Position() {
        super(0, null, 0, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // METHOD OVERLOADING :-
    
    public boolean assignPosition(int id,String position){
         boolean b = false;
        String sql = "Insert into HourlyEmployees(ID,Position) values ('"+id+"','"+position+"')";
        
        try {
            stmt = con_obj.createStatement();
            
            int res = stmt.executeUpdate(sql);
            
            if (res > 0 ) {
                //JOptionPane.showMessageDialog(null, "Inserted");
                b=true;
            }
            else{
                //JOptionPane.showMessageDialog(null, "Error");
            }
            
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        return b;
    }
    
    public boolean assignPosition(String position , int id){
         boolean b = false;
        String sql = "Update CommissionEmployees Set Position='"+position+"' Where ID='"+id+"' ";
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);
            if (res > 0 ) {
                //JOptionPane.showMessageDialog(null, "Inserted");
                b=true;
            }
            else{
                //JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        return b;
    }
    
     public boolean changePosition(int id , String position){
         boolean b = false;
        String sql = "Update PermanentEmployees Set Position='"+position+"' Where ID='"+id+"' ";
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);
            if (res > 0 ) {
                //JOptionPane.showMessageDialog(null, "Inserted");
                b=true;
            }
            else{
                //JOptionPane.showMessageDialog(null, "Error");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        return b;
    }
    
}
