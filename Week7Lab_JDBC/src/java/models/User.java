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
    Role role;
    
}
