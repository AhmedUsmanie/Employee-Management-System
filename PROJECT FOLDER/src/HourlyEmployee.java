
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
public class HourlyEmployee extends Employee{
    
    ConnectionToDB conn = new ConnectionToDB();
    Connection con_obj = conn.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    
    // CLASS ATTRIBUTES AND METHODS :-
    private double hourlyWage;
    private int hoursWorked;
    public double totalEarnings;

    public HourlyEmployee() {
        super(0, null, 0, null, null);
    }

    public HourlyEmployee(double hourlyWage, int hoursWorked, int id, String Name, int number, String address, String email) {
        super(id, Name, number, address, email);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    
    public double calculateEarnings(){
        
        return totalEarnings=getHourlyWage()*getHoursWorked();
        
    }
    
    // CRUD OPERATIONS :-
    
    public boolean addEmployee(String empname,String email,double wage,String address,int contact,int hours,double earnings ){
        
        boolean b = false;
        String sql = "Insert into HourlyEmployees(EmpName,Email,Contact,Address,Wage,Hours,Earnings) values ('"+empname+"' , '"+email+"' , '"+contact+"','"+address+"','"+wage+"','"+hours+"','"+earnings+"')";
        
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

    @Override
     public boolean searchEmployee(int id){
        boolean b = false;
        String sql = "Select * from HourlyEmployees Where ID='"+id+"'";
        
        try {
            pstmt = con_obj.prepareStatement(sql);
            res=pstmt.executeQuery();
            
            while (res.next()) {                
                setName(res.getString("EmpName"));
                setNumber(res.getInt("Contact"));
                setEmail(res.getString("Email"));
                setAddress(res.getString("Address"));
                hourlyWage=res.getDouble("Wage");
                hoursWorked = res.getInt("Hours");
                totalEarnings=res.getDouble("Earnings");
                b=true;
            }
        } catch (Exception e) {
        }
        return b;
    }

    public boolean updateEmployee(int id , double wage , int hours,double earnings){
         boolean b = false;
        String sql = "Update HourlyEmployees Set Wage='"+wage+"',Hours='"+hours+"' ,Earnings='"+earnings+"' Where ID='"+id+"' ";
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
    
    @Override
    public boolean deleteEmployee(int id){
        boolean b=false;
        String sql = "Delete From HourlyEmployees Where ID = '"+id+"'";
        try {
            stmt=con_obj.createStatement();
            int res = stmt.executeUpdate(sql);
            if (res > 0) {
                b=true;
            }
            else {
                b=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return b;
    }
}
