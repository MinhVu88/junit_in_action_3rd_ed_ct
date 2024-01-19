// Listing 3.5
package com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.Calculator;

public class RuleExceptionTester {
	// We declare an ExpectedException field annotated with @Rule.
	// The @Rule annotation must be applied to a public non-static field/method.
	// The ExpectedException.none() factory method simply creates an unconfigured ExpectedException.
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// We initialize an instance of the Calculator class whose functionality we are testing.
	private Calculator calculator = new Calculator();

	@Test
	public void expectIllegalArgumentException() {
		// ExpectedException is configured to keep the type of exception & message
		// before it is thrown by invoking the sqrt method.
		expectedException.expect(IllegalArgumentException.class);

		expectedException.expectMessage("Cannot extract the square root of a negative value");
		
		calculator.sqrt(-1);
	}

	@Test
	public void expectArithmeticException() {
		// ExpectedException is configured to keep the type of exception & message 
		// before it is thrown by invoking the divide method.
		expectedException.expect(ArithmeticException.class);
		
		expectedException.expectMessage("Cannot divide by zero");
		
		calculator.divide(1, 0);
	}
}
