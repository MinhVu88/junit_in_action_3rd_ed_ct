// Listing 2.22 (@CsvFileSource annotation)
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParameterizedWithCsvFileSourceTest {
  private WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @CsvFileSource(resources = "/word_counter.csv")
  void testWordsInSentence(int expectedResult, String sentence) {
    System.out.println("expected result: " + expectedResult + " | sentence: " + sentence);
    
    assertEquals(expectedResult, wordCounter.countWords(sentence));
  }
}
