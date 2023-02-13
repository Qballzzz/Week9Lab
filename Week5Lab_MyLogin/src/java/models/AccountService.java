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
public class AccountService {
    
    public class User implements Serializable{
        String username;
        String password;
        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public User login(String username, String password) {
            if (username.equals("abe") || username.equals("barb") && password.equals("password")) {
                User newUser = new User(username, password);
                return newUser;
            }else{
                return null;
            }
        }
    }  
}
