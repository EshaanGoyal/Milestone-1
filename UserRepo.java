package com.global.repository;
import com.global.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepo {
	String status = "failed";
    Connection connection  = DBConnection.getConnection();
    public void login(String username, String password){
        try {
	    	PreparedStatement statement = connection.prepareStatement("select username, password, role from user where username = ?");
	        statement.setString(1, username);
	        ResultSet resultset = statement.executeQuery();
	        String user = resultset.getString(1);
	        String pass = resultset.getString(2);
	        String role = resultset.getString(3);
	        System.out.println(user);
	        System.out.println(pass);
	        System.out.println(role);
	        if (username.equals(user) && password.equals(pass) && role.equals("admin")){
	            status = "admin";
	        }
	        else if (username.equals(user) && password.equals(pass) && role.equals("user")){
	            status = "user";
	        }
	        else{
	            status = "Login Failed";
	        }
        }
        catch(Exception e) {
        	
        }
        System.out.println(status);
    }

    public Boolean register(String username, String password, String firstname, String lastname, String role){
        try {
            PreparedStatement statement = connection.prepareStatement("insert into user values (?,?,?,?,?)");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstname);
            statement.setString(4, lastname);
            statement.setString(5, role);
            statement.executeQuery();
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
