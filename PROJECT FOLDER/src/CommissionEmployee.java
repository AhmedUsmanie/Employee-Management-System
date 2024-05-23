
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
public class CommissionEmployee extends Employee{
    
      ConnectionToDB conn = new ConnectionToDB();
    Connection con_obj = conn.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    
    
    
    private double baseSalary;
    private double commission;
    private double totalEarnings;


    public CommissionEmployee() {
        super(0, null, 0, null, null);
    }
    
    
    public CommissionEmployee(double baseSalary, double commission, int id, String Name, int number, String address, String email) {
        super(id, Name, number, address, email);
        this.baseSalary = baseSalary;
        this.commission = commission;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
    
    public double totalEarnings(){
        
        return getBaseSalary()+getCommission();
        
    }
    
    
    
    
    // CRUD OPERATIONS :-
    
    public boolean addEmployee(String empname,String email,double salary,String address,int contact,double commission,double earnings ){
        
        boolean b = false;
        String sql = "Insert into CommissionEmployees(EmpName,Email,Contact,Address,BaseSalary,Commission,Earnings) values ('"+empname+"' , '"+email+"' , '"+contact+"','"+address+"','"+salary+"','"+commission+"','"+earnings+"')";
        
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
        String sql = "Select * from CommissionEmployees Where ID='"+id+"'";
        
        try {
            pstmt = con_obj.prepareStatement(sql);
            res=pstmt.executeQuery();
            
            while (res.next()) {                
                setName(res.getString("EmpName"));
                setNumber(res.getInt("Contact"));
                setEmail(res.getString("Email"));
                setAddress(res.getString("Address"));
                baseSalary=res.getDouble("BaseSalary");
                commission = res.getDouble("Commission");
                totalEarnings=res.getDouble("Earnings");
                b=true;
            }
        } catch (Exception e) {
        }
        return b;
    }
    
    public boolean updateEmployee(int id , double salary , double commission , double earnings){
         boolean b = false;
        String sql = "Update CommissionEmployees Set BaseSalary='"+salary+"',Commission='"+commission+"' ,Earnings='"+earnings+"' Where ID='"+id+"' ";
        try {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);
            if (res > 0 ) {
                b=true;
            }
            else{
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        return b;
    }

      @Override
    public boolean deleteEmployee(int id){
        boolean b=false;
        String sql = "Delete From CommissionEmployees Where ID = '"+id+"'";
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
