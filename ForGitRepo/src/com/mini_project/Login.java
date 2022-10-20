package com.mini_project;
//forgit
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
public class Login {
	public void firstpage() {
		
		DisplayQue ddq=new DisplayQue();
		
		Scanner sc=new Scanner(System.in);
		
		 {
		 String name;
    	 String userName;
	     String password;	
			 		
		System.out.println("======================================================================================================\n");
		System.out.println("------------------------------------Welcome to the Quiz ----------------------------------------------\n");
		System.out.println("______________________________Press 1 for existing student____________________________________________\n");	
		System.out.println("________________________________Press 2 for Signing Up__________________________________________________");	
		
		int Userchoice=sc.nextInt();
		
		switch(Userchoice) {
		
		
		case 1:
			// call DB 
			
			System.out.print("Enter your USERNAME :");
			userName=sc.next();
			System.out.print("Enter your PASSWORD :");
			password=sc.next();
			getDatabase();
			for(Students stud:al) {
				if(userName.equals( stud.getUserName()) && password.equals(stud.getPassword()) ){
				
					ddq.quizStart();
					break;
				}
				else {
					System.out.println("Access Denied Enter Valid Details");
					System.exit(0);
					firstpage();
					
				}
			}
			
			
		
			break;
			
		case 2:	
			System.out.print("Enter your Name:");
		    name=sc.next();
		    System.out.println("");
			System.out.print("Create an USERNAME for you:");
			userName=sc.next();
			System.out.println("");
			System.out.print("Create a PASSWORD for you:");
			password=sc.next();
			

			try {	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Jay@mysql6");
				
				PreparedStatement pst=conn.prepareStatement("INSERT INTO entries(name,userName,password)values(?,?,?)");
				pst.setString(1, name); 
				pst.setString(2, userName); 
				pst.setString(3, password); 
				pst.execute();
				System.out.println("Database updated Succesfully!");
				conn.close();
				pst.close();
				
				
	     		
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				ddq.quizStart(); 
			}
			
	    break;
		}
		
		
	  }
		
			
	
		
		
	}
	ArrayList<Students> al =new ArrayList<Students>();
	public ArrayList<Students> getDatabase() {
		
		
		 

			try {	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Jay@mysql6");
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery("Select * from entries");			
				 while (rs.next())
		            {
					 	Students s=new Students();
					 	s.setName(rs.getString("name"));
						s.setUserName(rs.getString("userName"));
						s.setPassword(rs.getString("password"));
		                al.add(s);
		            }			
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
	return al;
	
}
	
}	

		
		
		
		
		
	
	
	
	
	
	
