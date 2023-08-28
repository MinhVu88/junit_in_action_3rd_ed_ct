// Listing 1.2
package com.catalintudose.junit3rded.testeddatasystems.ch_1_junit_jumpstart;

public class CalculatorTest0 {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();

    double expectedResult = 60;
    double actualResult = calculator.add(10, 50);

    if(actualResult != expectedResult) {
      System.out.println("actual result: " + actualResult);
    } else {
      System.out.println("actual result == expected result -> " + actualResult);
    }
  }
}
