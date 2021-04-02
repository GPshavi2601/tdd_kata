package tdd.kata.sample.tdd_sample_exercise;

public class StringCalculator {
	
	public static void main(String[] args) {
		System.out.println("String Calculator");
	}
	
	/**
	 * Method to add numbers
	 */
	static int add(String numbers) {
		int sum=0;
		if(numbers.isEmpty()){
			return 0;
		}
		for(String number : numbers.split(",")){
			sum+=Integer.parseInt(number);
		}
		return sum;
	}

}
