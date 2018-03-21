package calclogic;

import java.util.*;

public class CalcLogic {
	
	//Creating ArrayLists for operators and operands.
	ArrayList<String> operators = new ArrayList<String>();
	ArrayList<String> operands = new ArrayList<String>();
	
	private enum calculate {plus, minus, division, multi, modulus}

	public double add(double first, double second) {
		
		return first+second;
	}

	public double sub(double first, double second) {
		
		return first-second;
	}

	public double div(double first, double second) {
		
		//If divided by 0, exception is thrown.
		if(second==0)
			throw new ArithmeticException("Can't devide by zero!");
		
		return first/second;
	}

	public double multi(double first, double second) {
		
		return first*second;
	}

	public double mod(double first, double second) {
		
		return first%second;
	}
	
	//Method to set arithmetic.
	public calculate setArithmetic(String str) {
		
		calculate rs;
		
		switch(str) {
		case "+":
			rs = calculate.plus;
			return rs;
		case "-":
			rs = calculate.minus;
			return rs;
		case "/":
			rs = calculate.division;
			return rs;
		case "*":
			rs = calculate.multi;
			return rs;
		case "%":
			rs = calculate.modulus;
			return rs;
		}
		
		return null;
	}
	
	//Split input and put operands into correct ArrayList.
	public ArrayList<String> extractOperands(String expression) {
		expression = expression.replaceAll(" ", "");
		operands = new ArrayList<String>(
				Arrays.asList(expression.split("[^0-9\\.]+")));
		
		return operands;
	}

	//Split input and put operators into correct ArrayList.
	public ArrayList<String> extractOperators(String expression) {
		expression = expression.replaceAll(" ", "");
		
		operators = new ArrayList<String>(
				Arrays.asList(expression.split("[0-9\\.]+")));
		
		operators.removeIf(p->p.equals(""));
		
		
		return operators;
	}
	
	
	//Method for checking which arithmetic to use depending on rs.
	private double calc(double first, calculate rs, double second) {
		
		double result = 0;
		
		if (rs.equals(calculate.plus)) {
			result = add(first, second);
			
		} else if (rs.equals(calculate.minus)) {
			result = sub(first, second);
			
		} else if (rs.equals(calculate.division)) {
			result = div(first, second);
			
		} else if (rs.equals(calculate.multi)) {
			result = multi(first, second);
		
		} else if (rs.equals(calculate.modulus)) {
			result = mod(first, second);
			
		} else {
			System.out.println("Error.");
			return 0;
		}
		return result;

	}
	
	//Method for calculating the expression.
	//Goes through the ArrayList with operators.
	//First calculation needs two values from the ArrayList with operands.
	//Calculations after that uses result with the next value from operands.
	//Returns result when finished.
	public double calcExpression(String input) throws Exception {
		
		double result = 0;
		
		operands = extractOperands(input);
		operators = extractOperators(input);
		
		boolean first = true;
		
		for (String s : operators) {

				if(first) {
					result = calc(firstValue(), setArithmetic(s), secondValue());
					//After the first calculation, first and second value from operands list is removed.
					operands.remove(0);
					operands.remove(0);
					
					first = false;
					
				} else {
					result = calc(result, setArithmetic(s), firstValue());
					//After every calculation, first value from operands list is removed.
					operands.remove(0);
				}	
			
		}
		
		System.out.println("Result: " + result);
		return result;
		
	}
	
	//Gets the first value from the ArrayList with operands.
	public double firstValue() {
		
		String first = operands.get(0);	
		double f = Double.parseDouble(first);
		
		return f;
	}
	
	//Gets the second value from the ArrayList with operands.
	public double secondValue() {

		String second = operands.get(1);
		double s = Double.parseDouble(second);
		
		return s;
	}
	

}
