package tdd.kata.sample.tdd_sample_exercise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static tdd.kata.sample.tdd_sample_exercise.StringCalculator.add;

/**
 * Unit test for String Calculator
 */
public class StringCalculatorTest
{
	
	@Test
    void addTestEmptyString()
    {
		int sum = add("");
		assertEquals(0, sum);
    }
	
	@Test
    void addTestOneNumber()
    {
		int sum = add("1");
		assertEquals(1, sum);
    }
	
	@Test
    void addTestTwoNumbers()
    {
		int sum = add("1,2");
		assertEquals(3, sum);
    }

}
