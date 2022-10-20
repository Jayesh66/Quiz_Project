package com.mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Result {
	public int  percentage;
	public String performance = "";
	DisplayQue disque=new DisplayQue();
	
	public void ResultDisplay() {
		
		System.out.println(".........Test Ended........ Test Ended ...........Test Ended.......... ");
		System.out.println(".........Test Ended........ Test Ended ...........Test Ended.......... ");
		System.out.println("                                                                       ");
		
		
		
		 System.out.println("--------------You have given "+ disque.rightAns +" right answers!--------------");
	     percentage =disque.rightAns*10 ;
	    System.out.println("                  Your percentage are :"+percentage+"%"                );
	    
	    
	    if(percentage >=70 && percentage <=100)
	    {
	    	System.out.println("xxxxxxxxxxxxx          xxxxxxxxxxxxx           xxxxxxxxxxxxx       ");
			System.out.println("                      Your grade is A                              ");
			System.out.println("xxxxxxxxxxxxx          xxxxxxxxxxxxx           xxxxxxxxxxxxx       ");
			
			performance="A";
	        
	    }
	    else if(percentage >=60 && percentage<70)
	    {
	    	System.out.println("xxxxxxxxxxxxx          xxxxxxxxxxxxx           xxxxxxxxxxxxx       ");
			System.out.println("                      Your grade is B                              ");
			System.out.println("xxxxxxxxxxxxx          xxxxxxxxxxxxx           xxxxxxxxxxxxx       ");
			performance="B";
	    }
	    else if(percentage >=40 && percentage <60) {
	    	System.out.println("xxxxxxxxxxxxx          xxxxxxxxxxxxx           xxxxxxxxxxxxx       ");
			System.out.println("                      Your grade is C                              ");
			System.out.println("xxxxxxxxxxxxx          xxxxxxxxxxxxx           xxxxxxxxxxxxx       ");
			performance="C";
	    }else {
	    	System.out.println("xxxxxxxxxxxxx          xxxxxxxxxxxxx           xxxxxxxxxxxxx       ");
			System.out.println("                      Your grade is D                             ");
			System.out.println("xxxxxxxxxxxxx          xxxxxxxxxxxxx           xxxxxxxxxxxxx       ");
			performance="D";
	    }
	    resultToDB();

	}
// store to database
	
	
	public void resultToDB() {
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project","root","Jay@mysql6");
			Login lg=new Login();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO entries(marks,grade)Values(?,?)");
		//	pst.setString(1,name);
		//	pst.setString(2,userName);
		//	pst.setString(3, password);
			pst.setInt(4, percentage);
			pst.setString(5, performance); 
			
			pst.execute();
			System.out.println("Database updated Succesfully!");
			conn.close();
			pst.close();
			//getting questions:
			
     		
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
	
	
	


}
