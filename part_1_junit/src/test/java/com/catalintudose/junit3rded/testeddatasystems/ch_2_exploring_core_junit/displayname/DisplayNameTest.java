// Listing 2.4
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.displayname;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test class showing the @DisplayName annotation")
public class DisplayNameTest {
  private SUT systemUnderTest = new SUT();

  @Test
  @DisplayName("SUT says hello")
  void testHello() {
    assertEquals("Hello", systemUnderTest.hello());
  }

  @Test
  @DisplayName("😱")
  void testTalking() {
    assertEquals("How are you?", systemUnderTest.talk());
  }

  @Test
  void testBye() {
    assertEquals("Bye", systemUnderTest.bye());
  }
}
