
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
 * @author F I ENTERPRISES
 */
public class PermanentEmployee extends Employee{
    
     ConnectionToDB conn = new ConnectionToDB();
    Connection con_obj = conn.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    
    // CLASS ATTRIBUTES AND METHODS :-
    private double monthlySalary;
    private int percentageBonus;

    public PermanentEmployee() {
        super(0, null, 0, null, null);
    }


    public PermanentEmployee(double monthlySalary, int percentageBonus, int id, String Name, int number, String address, String email) {
        super(id, Name, number, address, email);
        this.monthlySalary = monthlySalary;
        this.percentageBonus = percentageBonus;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public int getPercentageBonus() {
        return percentageBonus;
    }

    public void setPercentageBonus(int percentageBonus) {
        this.percentageBonus = percentageBonus;
    }

        // CRUD OPERATIONS :-
    
     @Override
     public boolean addEmployee(String empname,String email,double salary,String address,int contact,int prcntBonus){
        
        boolean b = false;
        String sql = "Insert into PermanentEmployees(EmpName,Email,Contact,Address,salary,PercentageBonus) values ('"+empname+"' , '"+email+"' , '"+contact+"','"+address+"','"+salary+"','"+prcntBonus+"')";
        
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
        String sql = "Select * from PermanentEmployees Where ID='"+id+"'";
        
        try {
            pstmt = con_obj.prepareStatement(sql);
            res=pstmt.executeQuery();
            
            while (res.next()) {                
                setName(res.getString("EmpName"));
                setNumber(res.getInt("Contact"));
                setEmail(res.getString("Email"));
                setAddress(res.getString("Address"));
                monthlySalary=res.getDouble("Salary");
                percentageBonus = res.getInt("PercentageBonus");
                b=true;
            }
        } catch (Exception e) {
        }
        return b;
      }
      
     @Override
      public boolean updateEmployee(int id ,int Bonus, String address){
         boolean b = false;
        String sql = "Update PermanentEmployees Set Address='"+address+"' , PercentageBonus ='"+Bonus+"' Where ID='"+id+"' ";
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
        String sql = "Delete From PermanentEmployees Where ID = '"+id+"'";
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
