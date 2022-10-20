package com.mini_project;
//forgit1111
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Faltu {
	public static void main(String[] args) {
		String name="JK";
		String userName="JNK";
		String password="123";
		

		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Jay@mysql6");
			//Statement stmt=conn.createStatement();
			//ResultSet rs=stmt.executeQuery("Select * from entries");
			PreparedStatement pst=conn.prepareStatement("insert into entries(name,userName,password)values(?,?,?)");
			pst.setString(1, name); 
			pst.setString(2, userName); 
			pst.setString(3, password); 
			
			System.out.println("Database updated Succesfully!");
			conn.close();
			pst.close();
		
     		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
 
	}
	
	
  
	
		
	}	
		
		
	
	
	

