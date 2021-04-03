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

		/* Handle empty string */
		if (numbers.isEmpty()) {
			return 0;
		}

		/* Handle string with given delimitters */
		if (numbers.startsWith("//")) {
			String[] splitString = numbers.split("\n", 2);

			/* Handle string with single delimitter */
			if (splitString[0].length() == 3)
				return calculateSum(splitString[1], String.valueOf(splitString[0].charAt(2)).concat("|"));

			/* Handle string with multiple delimitters */
			else {
				StringBuilder delimitter = new StringBuilder();
				String[] delimitters = splitString[0].split("\\[");
				/* Building regex for multiple delimitters */
				for (int i = 1; i < delimitters.length; i++) {
					delimitter = delimitter
							.append(new StringBuilder(
									Arrays.asList(delimitters[i].substring(0, delimitters[i].length() - 1).split(""))
											.stream().map(x -> x.replace(x, "\\" + x)).collect(Collectors.joining())))
							.append("|");
				}
				return calculateSum(splitString[1], delimitter.toString());
			}
		}

		/* Handle string with delimitter as ; */
		else {
			return calculateSum(numbers, ",|");
		}
	}

	private static int calculateSum(String numbers, String delimitter) throws InvalidDataException {
		int sum = 0;
		StringBuilder negativeNumbers = new StringBuilder("");
		int num = 0;
		for (String number : numbers.split(delimitter + "\n")) {
			if (number.charAt(0) == '+')
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
