// Listing 1.6
package com.catalintudose.junit3rded.testeddatasystems.ch_1_junit_jumpstart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest2 {
	@Test
	public void testAdd() {
		double expectedResult = 60;

		Calculator calculator = new Calculator();

		double actualResult = calculator.add(10, 50);

		// zero is passed as delta because no floating-point errors occur when combining 10 & 50,
		// as the decimal part of these numbers is zero.
		assertEquals(expectedResult, actualResult, 0);
	}
}
