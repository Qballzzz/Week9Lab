/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author qball
 */
public class User implements Serializable{
    
    String email;
    String firstName;
    String lastName;
    String password;
    Role role;
    
    public User(String email, String firstname, String lastname, String password, Role role) {
        this.email = email;
        this.firstName = firstname;
        this.lastName = lastname;
        this. password = password;
        this.role = role;
    }
    
    public String getEmail(){
        return email;
    }
    
     public String getfirstName(){
        return firstName;
    }
     
     public String getlastName(){
        return lastName;
    }
     
     public Role getRole(){
        return role;
    }
}
