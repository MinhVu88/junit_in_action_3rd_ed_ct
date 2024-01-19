// Listing 3.3 (run the test class via this cmd from the root directory: mvn -Dtest=CalculatorTest test)
package com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.runners;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.Calculator;

import static org.junit.Assert.assertEquals;

@RunWith(CustomTestRunner.class)
public class CalculatorTest {
	@Test
	public void testAdd() {
		Calculator calculator = new Calculator();

		double result = calculator.add(10, 50);

		assertEquals(60, result, 0);
	}
}
