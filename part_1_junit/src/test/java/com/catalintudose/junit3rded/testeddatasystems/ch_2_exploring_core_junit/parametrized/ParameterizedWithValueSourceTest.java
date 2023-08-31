// Listing 2.19 (@ValueSource annotation)
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.parametrized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedWithValueSourceTest {
  private WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @ValueSource(strings = {"Check 3 parameters", "JUnit in Action"})
  void testWordsInSentence(String sentence) {
    int expectedResult = 3;
    int actualResult = wordCounter.countWords(sentence);

    System.out.println("actual result: " + actualResult);

    assertEquals(expectedResult, actualResult);
  }
}
