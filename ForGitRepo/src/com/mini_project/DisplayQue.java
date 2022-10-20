package com.mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DisplayQue  {
	public static int rightAns;
	public int wrongAns;
	
	
	
	
	
	
	
		//public ArrayList<D>
	public ArrayList<Questions> getQueDB(){
		ArrayList<Questions> quearraylist =new ArrayList<Questions>();
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mini_Project","root","Jay@mysql6");
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("Select * from questions");	
			
			
			while (rs.next())
            {
                Questions p = new Questions();
                p.setQue(rs.getString("Que"));
                p.setOpt_A(rs.getString("Opt_A"));
                p.setOpt_B(rs.getString("Opt_B"));
                p.setOpt_C(rs.getString("Opt_C"));
                p.setOpt_D(rs.getString("Opt_D"));
                p.setCorrect_Ans(rs.getString("Correct_Ans"));
                quearraylist.add(p);
                Collections.shuffle(quearraylist);
            }
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return quearraylist;
		
		
		
	}
	 
	
	
	
	
public void quizStart() {
	
	
	DisplayQue d= new DisplayQue();
	ArrayList <Questions> qq=getQueDB();
	
	
	for(Questions ques:qq)
	{
		System.out.println(ques.getQue());
		System.out.println(ques.getOpt_A());
		System.out.println(ques.getOpt_B());
		System.out.println(ques.getOpt_C());
		System.out.println(ques.getOpt_D());
		
		String useranswer="";
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter your answer:");
		char answer=scan.next().charAt(0);
		
		
		switch(answer)
		{
		case 'A'|'a':
		useranswer=ques.getOpt_A();	
		break;	
		case 'B'|'b':
		useranswer=ques.getOpt_B();
		break;	
		case 'C'|'c':
		useranswer=ques.getOpt_C();	
		break;	
			
		case 'D'|'d':
		useranswer=ques.getOpt_D();	
		break;	
		
		default:
			System.out.println("Invalid Answer");
		break;		
		
		}
		
		
	//answer validation
		if(useranswer.equals(ques.getCorrect_Ans()))
				{
		/*	System.out.println("                   -------------                       ");
			System.out.println("                    Right Answer                       ");
			System.out.println("                   -------------                       ");
			System.out.println("============================================================================");
			*/
			System.out.println("==================================================================================================================================================");
			rightAns++;
		}
		else
		{
			/*
			System.out.println("                   xxxxxxxxxxxxx                      ");
			System.out.println("                   Wrong Answer                      ");
			System.out.println("                   xxxxxxxxxxxxx                      ");
			System.out.println("============================================================================");
			*/
			System.out.println("============================================================================================================================");
			wrongAns++;
		}
		
		

		
	}
	
	
}






	
}	
	
	
	
	

