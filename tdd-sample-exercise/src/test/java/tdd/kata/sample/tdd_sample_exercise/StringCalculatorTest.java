package tdd.kata.sample.tdd_sample_exercise;

import org.junit.Test;

import tdd.kata.sample.tdd_sample_exercise.exception.InvalidDataException;

import static org.junit.Assert.assertEquals;
import static tdd.kata.sample.tdd_sample_exercise.StringCalculator.add;

/**
 * Unit test for String Calculator
 */
public class StringCalculatorTest {

	@Test
	public void addTestEmptyString() throws InvalidDataException {
		int sum = add("");
		assertEquals(0, sum);
	}

	@Test
	public void addTestOneNumber() throws InvalidDataException {
		int sum = add("1");
		assertEquals(1, sum);
	}

	@Test
	public void addTestTwoNumbers() throws InvalidDataException {
		int sum = add("1,2");
		assertEquals(3, sum);
	}

	@Test
	public void addTestThreeNumbers() throws InvalidDataException {
		int sum = add("1,2,3");
		assertEquals(6, sum);
	}

	@Test
	public void addTestTenNumbers() throws InvalidDataException {
		int sum = add("1,2,3,4,5,6,7,8,9,10");
		assertEquals(55, sum);
	}

	@Test
	public void addTestNumbersSeparatedByNewlineAndComma() throws InvalidDataException {
		int sum = add("1\n2,3");
		assertEquals(6, sum);
	}

	@Test
	public void addTestNumbersSeparatedByDiffDelimiters() throws InvalidDataException {
		int sum = add("//;\n1;2");
		assertEquals(3, sum);
	}

	@Test
	public void addTestNumbersSeparatedByDiffDelimitersWithNewLine() throws InvalidDataException {
		int sum = add("//;\n1\n2;3");
		assertEquals(6, sum);
	}

	@Test
	public void addTestOneNegativeNumber() {
		String exceptionMessage = "";
		try {
			add("//;\n1\n2;-3");
		} catch (Exception e) {
			exceptionMessage = e.getMessage();
		}
		assertEquals("negatives not allowed :-3 ", exceptionMessage);
	}
	
	@Test
	public void addTestMoreThanOneNegativeNumbers() {
		String exceptionMessage = "";
		try {
			add("//;\n1\n2;-3;-5;-10");
		} catch (Exception e) {
			exceptionMessage = e.getMessage();
		}
		assertEquals("negatives not allowed :-3 -5 -10 ", exceptionMessage);
	}


}
