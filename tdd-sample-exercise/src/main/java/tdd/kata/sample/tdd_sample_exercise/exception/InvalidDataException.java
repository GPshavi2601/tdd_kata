package tdd.kata.sample.tdd_sample_exercise.exception;

public class InvalidDataException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDataException(String errorMessage) {
        super(errorMessage);
    }

}
