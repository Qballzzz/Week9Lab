/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author qball
 */
public class User {
    String username;
    String password;
    public User(){
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public static User login(String username, String password) {
        if (username.equals("abe") || username.equals("barb") && password.equals("password")) {
            User user = new User(username, password);
            return user;
        }else{
            return null;
        }
    }  
}
