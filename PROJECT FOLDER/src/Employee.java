
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author F I ENTERPRISES
 */
public abstract class Employee {
    
    private int id;
    private String Name;
    private int number;
    private String address;
    private String email;

    public Employee(int id, String Name, int number, String address, String email) {
        this.id = id;
        this.Name = Name;
        this.number = number;
        this.address = address;
        this.email = email;
    }
    
//    JFrame frame = new JFrame();
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public boolean addEmployee(String empname,String email,double salary,String address,int contact,int prcntBonus){
        return false;
    }
      
    public boolean searchEmployee(int id){
        return false;
    }
    
    public boolean deleteEmployee(int id){
        return false;
    }
        
    public boolean updateEmployee(int id ,int Bonus, String address){
        return false;
    }
        
}
