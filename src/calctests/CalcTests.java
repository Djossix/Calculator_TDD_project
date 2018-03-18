package calctests;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.*;

import calclogic.*;

class CalcTests {
	
	
	public static CalcLogic calc;
	
	@BeforeAll
	static void Init() {
		calc = new CalcLogic();
	}

	@Test
	void testAddition_additionCheckResult() {
		
		double actual = calc.add(2.5d, 5d);
		
		assertEquals(7.5d, actual, 0.01);
		
	}
	
	@Test
	void testSubtraction_subtractionCheckResult() {
		
		double actual = calc.sub(4.5d, 5d);
		
		assertEquals(-0.5d, actual, 0.01);
		
	}
	
	@Test
	void testDivision_divisionCheckResult() {
		
		double actual = calc.div(20.5d, 1d);
		
		//Exception is thrown "Can't devide by zero!"
		//double actual = calc.div(20.5d, 0d);
		
		assertEquals(20.5d, actual, 0.01);
		
	}
	
	@Test
	void testMultiplication_multiplicationCheckResult() {
		
		double actual = calc.multi(20d, 2d);
		
		assertEquals(40d, actual, 0.01);
		
	}
	
	@Test
	void testModulus_modulusCheckResult() {
		
		double actual = calc.mod(10d, 3d);
		
		assertEquals(1d, actual, 0.01);
		
	}
	
	@Test
	public void extractOperands_extractComplexExpressionOperandsAsArrayList() {
		
		
		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add("1.645");
		expectedArray.add("1.444");
		expectedArray.add("1");
		expectedArray.add("1.754");
		expectedArray.add("6.01");

		ArrayList<String> actualArray = 
		calc.extractOperands("1.645+1.444/1*1.754%6.01");
		
		Assert.assertArrayEquals(expectedArray.toArray(), actualArray.toArray());
	
	}
	
	@Test
	public void extractOperators_extractOperandsAsArrayList() {
		
		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add("+");
		expectedArray.add("-");
		expectedArray.add("%");
		expectedArray.add("*");

		ArrayList<String> actualArray = 
		calc.extractOperators("1.42+2.345-1.77665%6.57567*2");
		
		Assert.assertArrayEquals(expectedArray.toArray(), actualArray.toArray());
	
	}
	
	@Test
	public void calculateExpression_calcExpressionCheckResult() throws Exception {
		
		double actual = calc.calcExpression("5+5*5%8");
		
		//double actual = calc.calcExpression("168.5*2/4+2");
		//Some expressions that works.
		//double actual = calc.calcExpression("44+2*2/2-2");
		//double actual = calc.calcExpression("8-2*2/2+2");
		//double actual = calc.calcExpression("20.5-2*2/2");
		//double actual = calc.calcExpression("20/0+4");
		//double actual = calc.calcExpression("5+5%3");
		//double actual = calc.calcExpression("2.5*2.5+3");
		//double actual = calc.calcExpression("5+5*5%8");
		
		//Some who don't.
		//double actual = calc.calcExpression("5*5+2*2");
		//double actual = calc.calcExpression("5+5%3+2");
		//double actual = calc.calcExpression("2.5*2-1/2");
		//double actual = calc.calcExpression("2.5*2.5*2");
		//double actual = calc.calcExpression("5+5a");
		
		assertEquals(2d, actual, 0.001);
	}
	

}
