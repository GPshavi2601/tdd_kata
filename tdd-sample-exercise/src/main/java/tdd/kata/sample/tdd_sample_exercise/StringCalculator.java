package tdd.kata.sample.tdd_sample_exercise;

import tdd.kata.sample.tdd_sample_exercise.exception.InvalidDataException;

public class StringCalculator {

	public static void main(String[] args) {
		System.out.println("String Calculator");
	}

	/**
	 * Method to add numbers
	 * @throws Exception 
	 */
	static int add(String numbers) throws InvalidDataException {
		if (numbers.isEmpty()) {
			return 0;
		}
		if (numbers.startsWith("//")) {
			String[] splitString = numbers.split("\n", 2);
			return sum(splitString[1], splitString[0].charAt(2));
		} else {
			return sum(numbers, ',');
		}
	}
	
	private static int sum(String numbers, char delimitter) throws InvalidDataException{
		int sum = 0;
		StringBuilder negativeNumbers = new StringBuilder("");
		int num = 0;
		for (String number : numbers.split(delimitter + "|\n")) {
			num = Integer.parseInt(number);
			if(num < 0){
				negativeNumbers.append(number).append(" ");
			}
			if(num <= 1000)
				sum += Integer.parseInt(number);
		}
		if(negativeNumbers.length()!=0)
			throw new InvalidDataException("negatives not allowed :"+negativeNumbers);	
		return sum;
	}

}
