
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
public class EmployeeAttendance extends Employee{
    
      ConnectionToDB conn = new ConnectionToDB();
    Connection con_obj = conn.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    
    
    
    
    private int id;
    private double percentageAttendance;
    private int daysPresent; // Total number of days present in a month
    public int totalWorkingDays=22; // Total number of working days in a month

    public EmployeeAttendance() {
        super(0, null, 0, null, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPercentageAttendance() {
        return percentageAttendance;
    }

    public void setPercentageAttendance(double percentageAttendance) {
        this.percentageAttendance = percentageAttendance;
    }

    public int getDaysPresent() {
        return daysPresent;
    }

    public void setDaysPresent(int daysPresent) {
        this.daysPresent = daysPresent;
    }

    public double calculateAttendance(){
        
        return percentageAttendance = (getDaysPresent() * 100) / totalWorkingDays ;
    }
    
    
    
   
    
    public boolean addAttendance(int id , int Present , double prcnt){
        
                boolean b = false;
        String sql = "Insert into EmployeeAttendance(ID,DaysWorked,PercentageAttendance) values ('"+id+"' , '"+Present+"' , '"+prcnt+"')";
        
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
    
    public boolean searchAttendance(int ID){
        boolean b = false;
        
        String sql = "Select * from EmployeeAttendance where ID = '"+ID+"'";
        
            try {
             pstmt=con_obj.prepareStatement(sql);
             res=pstmt.executeQuery();
             
             while (res.next()) {                
                daysPresent=res.getInt("DaysWorked");
                percentageAttendance=res.getDouble("PercentageAttendance");
                b=true;
             
            }
                 } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        return b;
    }
}
