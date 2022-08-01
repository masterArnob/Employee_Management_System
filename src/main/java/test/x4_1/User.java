/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.x4_1;

/**
 *
 * @author Asus
 */
public class User 
{
    Integer ID;
    String  Name, Address, Phone, Email ;

 

  

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    

    public User(Integer ID, String Name, String Address, String Phone, String Email, String Dept) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
        
    }

  

    
    
}
