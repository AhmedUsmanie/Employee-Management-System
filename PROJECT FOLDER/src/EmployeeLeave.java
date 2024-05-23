
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
public class EmployeeLeave extends Employee{
    
     ConnectionToDB conn = new ConnectionToDB();
    Connection con_obj = conn.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    
    
    
    
    
    
    private int id;
    private String EmpName;
    private int leaveDays;
    private String leaveDescription;

    public EmployeeLeave() {
        super(0, null, 0, null, null);
    }

    public EmployeeLeave(String EmpName, int leaveDays, String leaveDescription, int id, String Name, int number, String address, String email) {
        super(id, Name, number, address, email);
        this.EmpName = EmpName;
        this.leaveDays = leaveDays;
        this.leaveDescription = leaveDescription;
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    
    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getLeaveDescription() {
        return leaveDescription;
    }

    public void setLeaveDescription(String leaveDescription) {
        this.leaveDescription = leaveDescription;
    }
    
    
    public boolean addLeave(int id,String EmpName,int leaveDays,String description){
         boolean b = false;
        String sql = "Insert into EmployeeLeave(ID,EmpName,LeaveDays,LeaveDescription) values ('"+id+"' , '"+EmpName+"' , '"+leaveDays+"','"+description+"')";
        
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
    
    public boolean searchLeave(int ID){
        boolean b = false;
        
        String sql = "Select * from EmployeeLeave where ID = '"+ID+"'";
        
            try {
             pstmt=con_obj.prepareStatement(sql);
             res=pstmt.executeQuery();
             
             while (res.next()) {                
                EmpName=res.getString("EmpName");
                leaveDays=res.getInt("LeaveDays");
                leaveDescription =res.getString("LeaveDescription");
                b=true;
             
            }
                 } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        return b;
    }
    
}
