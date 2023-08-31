// Listing 2.21 (@CsvSource annotation)
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedWithCsvSourceTest {
  private WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @CsvSource({
    "2, Unit testing", 
    "3, JUnit in Action",
    "4, Write solid Java code"
  })
  void testWordsInSentence(int expectedResult, String sentence) {
    System.out.println("expected result: " + expectedResult + " | sentence: " + sentence);
    
    assertEquals(expectedResult, wordCounter.countWords(sentence));
  }
}
