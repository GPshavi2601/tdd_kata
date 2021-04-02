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
    public void addTestEmptyString()
    {
		int sum = add("");
		assertEquals(0, sum);
    }
	
	@Test
    public void addTestOneNumber()
    {
		int sum = add("1");
		assertEquals(1, sum);
    }
	
	@Test
    public void addTestTwoNumbers()
    {
		int sum = add("1,2");
		assertEquals(3, sum);
    }
	
	@Test
	public void addThreeNumbers(){
		int sum = add("1,2,3");
		assertEquals(6, sum);
	}
	
	@Test
	public void addTenNumbers(){
		int sum = add("1,2,3,4,5,6,7,8,9,10");
		assertEquals(55, sum);
	}

}
