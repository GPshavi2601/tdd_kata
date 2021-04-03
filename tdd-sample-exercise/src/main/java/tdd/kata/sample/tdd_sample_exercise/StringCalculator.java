package tdd.kata.sample.tdd_sample_exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

import tdd.kata.sample.tdd_sample_exercise.exception.InvalidDataException;

public class StringCalculator {

	public static void main(String[] args) {
		System.out.println("String Calculator");
	}

	/**
	 * Method to add numbers
	 * 
	 * @throws Exception
	 */
	static int add(String numbers) throws InvalidDataException {
		if (numbers.isEmpty()) {
			return 0;
		}
		if (numbers.startsWith("//")) {
			String[] splitString = numbers.split("\n", 2);
			if (splitString[0].length() == 3)
				return sum(splitString[1], String.valueOf(splitString[0].charAt(2)));
			else {
				return sum(splitString[1], splitString[0].substring(3, splitString[0].length() - 1));
			}

		} else {
			return sum(numbers, ",");
		}
	}

	private static int sum(String numbers, String delimitter) throws InvalidDataException {
		int sum = 0;
		StringBuilder negativeNumbers = new StringBuilder("");
		int num = 0;
		String[] delimitterArray = delimitter.split("");
		delimitter = Arrays.asList(delimitterArray).stream().map(x -> x.replace(x, "\\" + x))
				.collect(Collectors.joining());
		for (String number : numbers.split(delimitter + "|\n")) {
			if (number.charAt(0)=='+')
				throw new InvalidDataException("Invalid pattern");
			num = Integer.parseInt(number);
			if (num < 0) {
				negativeNumbers.append(number).append(" ");
			}
			if (num <= 1000)
				sum += Integer.parseInt(number);
		}
		if (negativeNumbers.length() != 0)
			throw new InvalidDataException("negatives not allowed :" + negativeNumbers);
		return sum;
	}

}
