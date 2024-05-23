
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
public class Salary {
    
      ConnectionToDB conn = new ConnectionToDB();
    Connection con_obj = conn.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    
    
    private int id;
    private PermanentEmployee salary;
    double newSalary;
    
    
    public Salary() {
    }

    public Salary(PermanentEmployee salary) {
        this.salary = salary;
    }
    
    
    public Salary(int id, PermanentEmployee salary) {
        this.id = id;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PermanentEmployee getSalary() {
        return salary;
    }

    public void setSalary(PermanentEmployee salary) {
        this.salary = salary;
    }
    
    
    
    public double getsalary1(){
        
        return getSalary().getMonthlySalary();
    }
    
    
    public boolean viewSalary(int id){
                boolean b = false;
                
                String sql =  "Select * from PermanentEmployees where ID='"+id+"' ";
                
                try {
                    
             pstmt=con_obj.prepareStatement(sql);
             res=pstmt.executeQuery();
             
             while (res.next()) {   
                 
             // double s = getsalary1();
             newSalary=res.getDouble("Salary");
             
             
                b=true;
             
             }       
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }     
                return b;
    }
    
    
    public boolean changeSalary(int id,double salary){
                boolean b = false;
                
             String sql = "Update PermanentEmployees set Salary='"+salary+"' Where ID ='"+id+"'";
                          
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
