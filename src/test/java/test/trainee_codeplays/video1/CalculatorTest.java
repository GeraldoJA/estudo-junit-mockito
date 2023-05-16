package test.trainee_codeplays.video1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void shouldReturnZeroWhenNoValueWereGiven() {
		Calculator calculator = new Calculator();
		
		double sum = calculator.sum();
		
		Assertions.assertEquals(0, sum);
	}
	
	@Test
	public void shouldReturnTheSumOfGivenValues() {
		Calculator calculator = new Calculator();
		
		double sum = calculator.sum(3, 6);
		
		Assertions.assertEquals(9, sum);
	}
	
	@Test
	public void shouldThrowsAnExceptionWhenTheGivenNumberWereLassThanZero() {
		Calculator calculator = new Calculator();
		
		IllegalArgumentException exception = Assertions.assertThrows( IllegalArgumentException.class, () -> calculator.squareRoot(-1) );
		
		Assertions.assertEquals( "Não existe raíz quadrada real para números negativos", exception.getMessage() );
	}

	
	@Test
	public void shouldReturnTheSquareRootOfGivenNumber() {
		Calculator calculator = new Calculator();
		
		double result = calculator.squareRoot(4);
		
		Assertions.assertEquals(2, result);
	}
	
	@Test
	public void shouldReturnTrueWhenTheGivenNumberIsOdd() {
		Calculator calculator = new Calculator();
		
		boolean isOdd = calculator.isOdd(3);
		
		Assertions.assertTrue( isOdd );
	}
	
	@Test
	public void shouldReturnFalseWhenTheGivenNumberIsEven() {
		Calculator calculator = new Calculator();
		
		boolean isOdd = calculator.isOdd(3);
		
		Assertions.assertFalse( isOdd );
	}
	
	
	
}
