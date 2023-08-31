// Listing 2.20 (@EnumSource annotation)
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class ParameterizedWithEnumSourceTest {
  enum Sentences {
    JUNIT_IN_ACTION("JUnit in Action"),
    SOME_PARAMETERS("Check some parameters"),
    THREE_PARAMETERS("Check three parameters");

    private final String sentence;

    Sentences(String sentence) {
      this.sentence = sentence;
    }

    public String value() {
      return sentence;
    }
  }

  private WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @EnumSource(Sentences.class)
  void testWordsInSentence(Sentences sentences) {
    int expectedResult = 3;
    int actualResult = wordCounter.countWords(sentences.value());

    assertEquals(expectedResult, actualResult);
  }

  @ParameterizedTest
  @EnumSource(
    value = Sentences.class,
    names = {"JUNIT_IN_ACTION", "THREE_PARAMETERS"}
  )
  void testSelectedWordsInSentence(Sentences sentences) {
    assertEquals(3, wordCounter.countWords(sentences.value()));
  }

  @ParameterizedTest
  @EnumSource(
    value = Sentences.class,
    mode = EXCLUDE,
    names = {"THREE_PARAMETERS"}
  )
  void testExcludedWordsInSentence(Sentences sentences) {
    assertEquals(3, wordCounter.countWords(sentences.value()));
  }
}
