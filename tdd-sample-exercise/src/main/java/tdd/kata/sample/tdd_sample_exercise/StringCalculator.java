package tdd.kata.sample.tdd_sample_exercise;

public class StringCalculator {
	
	public static void main(String[] args) {
		System.out.println("String Calculator");
	}
	
	/**
	 * Method to add numbers
	 */
	static int add(String numbers) {
		String[] numberArray = numbers.split(",");
		if (numberArray.length == 2)
			return Integer.parseInt(numberArray[0]) + Integer.parseInt(numberArray[1]);
		else if (numberArray.length == 1 && !numberArray[0].equals(""))
			return Integer.parseInt(numberArray[0]);
		else
			return 0;
	}

}
