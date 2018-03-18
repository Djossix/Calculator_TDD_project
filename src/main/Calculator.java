package main;

import java.util.*;

import calclogic.CalcLogic;

public class Calculator {

	public static void main(String[] args) throws Exception {
		
		CalcLogic cl = new CalcLogic();
		
		System.out.print("Enter your calculation: ");
		
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();
		
		cl.calcExpression(expression);

	}
	
	
}
