package com.mini_project;

public class Questions   {
	private String Que;
	private String Opt_A;
	private String Opt_B;
	private String Opt_C;
	private String Opt_D;
	private String Correct_Ans;

	public Questions() {
		super();
	}

	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Questions [Que=" + Que + ", Opt_A=" + Opt_A + ", Opt_B=" + Opt_B + ", Opt_C=" + Opt_C + ", Opt_D="
				+ Opt_D + ", Correct_Ans=" + Correct_Ans + "]";
	}








	public Questions(String que, String opt_A, String opt_B, String opt_C, String opt_D, String correct_Ans) {
		super();
		Que = que;
		Opt_A = opt_A;
		Opt_B = opt_B;
		Opt_C = opt_C;
		Opt_D = opt_D;
		Correct_Ans = correct_Ans;
	}








	public String getQue() {
		return Que;
	}

	public void setQue(String que) {
		Que = que;
	}

	public String getOpt_A() {
		return Opt_A;
	}

	public void setOpt_A(String opt_A) {
		Opt_A = opt_A;
	}

	public String getOpt_B() {
		return Opt_B;
	}

	public void setOpt_B(String opt_B) {
		Opt_B = opt_B;
	}

	public String getOpt_C() {
		return Opt_C;
	}

	public void setOpt_C(String opt_C) {
		Opt_C = opt_C;
	}

	public String getOpt_D() {
		return Opt_D;
	}

	public void setOpt_D(String opt_D) {
		Opt_D = opt_D;
	}

	public String getCorrect_Ans() {
		return Correct_Ans;
	}

	public void setCorrect_Ans(String correct_Ans) {
		Correct_Ans = correct_Ans;
	}
	
	
}
