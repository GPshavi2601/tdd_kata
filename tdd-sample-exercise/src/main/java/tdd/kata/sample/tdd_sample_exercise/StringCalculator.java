package tdd.kata.sample.tdd_sample_exercise;

public class StringCalculator {

	public static void main(String[] args) {
		System.out.println("String Calculator");
	}

	/**
	 * Method to add numbers
	 */
	static int add(String numbers) {
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
	
	private static int sum(String numbers, char delimitter){
		int sum = 0;
		for (String number : numbers.split(delimitter + "|\n")) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}

}
