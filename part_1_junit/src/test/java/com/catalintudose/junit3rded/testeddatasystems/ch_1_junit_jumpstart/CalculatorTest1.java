// Listing 1.3
package com.catalintudose.junit3rded.testeddatasystems.ch_1_junit_jumpstart;

public class CalculatorTest1 {
  private int numberOfErrors = 0;

  public void testAdd() {
    Calculator calculator = new Calculator();

    double expectedResult = 60;
    double actualResult = calculator.add(-10, 50);

    if(actualResult != expectedResult) {
      throw new IllegalStateException(
        "expected result: " + expectedResult +
        " | actual result: " + actualResult
      );
    }
  }

  public static void main(String[] args) {
    CalculatorTest1 calculatorTest1 = new CalculatorTest1();

    try {
      calculatorTest1.testAdd();
    } catch(Throwable e) {
      calculatorTest1.numberOfErrors++;
      e.printStackTrace();
    }

    if(calculatorTest1.numberOfErrors > 0) {
      throw new IllegalStateException("number of errors: " + calculatorTest1.numberOfErrors);
    }
  }
}
