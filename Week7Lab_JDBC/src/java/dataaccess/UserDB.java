/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;
import java.util.ArrayList;
import models.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author qball
 */
public class UserDB {
    public void UserDB(){
    ArrayList<User> users = new ArrayList<>();
    }
    
    public List<User> getall(){
        RoleDB roledb = new RoleDB();
        List<User> users = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                while(rs.next()){
                    String email = rs.getString(1);
                    String fname = rs.getString(2);
                    String lname = rs.getString(3);
                    String pass = rs.getString(4);
                    int rolenum = rs.getInt(5);
                    Role role = roledb.getRole(rolenum);
                    User user = new User(email,fname,lname,pass,role);
                    users.add(user);
                }
        }
        catch(Exception e){
            
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        return users;
    }
    
    public void add(User user) throws Exception{
        
    }
    
    public User getUser(String user){
        User theUser;
        RoleDB roledb = new RoleDB();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE email = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
                while (rs.next()) {
                    String email = rs.getString(1);
                    String firstname = rs.getString(2);
                    String lastname = rs.getString(3);
                    String password = rs.getString(4);
                    int roleId = rs.getInt(5);
                    Role role = roledb.getRole(roleId);
                    theUser = new User(email, firstname, lastname, password, role);
                    return theUser;
                }
        }
        catch(Exception e){
            
        }
        finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
     return null;
    }
    
    
    public void updateUser(String email, String fname, String lname, String password, int role){
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "UPDATE user SET first_name = ?, last_name = ?, role = ?, password = ? WHERE email = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, role+"");
            ps.setString(4, password);
            ps.setString(5, email);
            ps.executeUpdate();
        } 
        catch(Exception e){
            
        }
            finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }

    
    public void updateUser(String email, String firstname, String lastname, int role){
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "UPDATE user SET first_name = ?, last_name = ?, role = ? WHERE email = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, role + "");
            ps.setString(4, email);
            ps.executeUpdate();
        } 
        catch(Exception e){
            
        }
            finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void delete(String email){
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
         String sql = "DELETE FROM user WHERE email = ?";
         
         try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.executeUpdate();
        } 
        catch(Exception e){
            
        }
            finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void addUser(String email,  String firstname, String lastname, String password, int id){
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        
        String sql = "INSERT INTO user(email, first_name, last_name, password, role) values(?, ?, ?, ?, ?)";
         
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, firstname);
            ps.setString(3, lastname);
            ps.setString(4, password);
            ps.setInt(5, id);
            ps.executeUpdate();
        } 
        catch(Exception e){
            
        }
            finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}