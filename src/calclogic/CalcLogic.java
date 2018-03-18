package calclogic;

import java.util.*;

public class CalcLogic {
	
	ArrayList<String> operators = new ArrayList<String>();
	ArrayList<String> operands = new ArrayList<String>();
	ArrayList<String> letters = new ArrayList<String>();
	
	private enum calculate {plus, minus, division, multi, modulus}

	public double add(double first, double second) {
		
		return first+second;
	}

	public double sub(double first, double second) {
		
		return first-second;
	}

	public double div(double first, double second) {
		
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
	
	public ArrayList<String> extractOperands(String expression) {
		expression = expression.replaceAll(" ", "");
		operands = new ArrayList<String>(
				Arrays.asList(expression.split("[^0-9\\.]+")));
		
		return operands;
	}

	public ArrayList<String> extractOperators(String expression) {
		expression = expression.replaceAll(" ", "");
		
		operators = new ArrayList<String>(
				Arrays.asList(expression.split("[0-9\\.]+")));
		
		operators.removeIf(p->p.equals(""));
		
		
		return operators;
	}
	
	
	
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
	
	public double calcExpression(String input) throws Exception {
		
		double result = 0;
		
		operands = extractOperands(input);
		operators = extractOperators(input);
		
		
		for (String s : operators) {
			
			if(s.equals(operators.get(0))) {
				result = calc(firstValue(), setArithmetic(s), secondValue());
				operands.remove(0);
				operands.remove(0);
				
			} else {
				result = calc(result, setArithmetic(s), firstValue());
				
			}
			
		}
		
		System.out.println(result);
		return result;
		
	}
	
	public double firstValue() {
		
		String first = operands.get(0);
		
		double f = Double.parseDouble(first);
		
		
		return f;
	}
	
	public double secondValue() {

		String second = operands.get(1);

		double s = Double.parseDouble(second);
		
		
		return s;
	}
	

}
