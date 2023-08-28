// Listing 2.14
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertThrowsTest {
  private SUT systemUnderTest = new SUT("Our system under test");

  @Test
  @DisplayName("An exception is expected")
  void testExpectedException() {
    assertThrows(
      NoJobException.class,
      systemUnderTest::run
    );
  }

  @Test
  @DisplayName("An exception is caught")
  void testCaughtException() {
    Throwable throwable = assertThrows(
      NoJobException.class,
      () -> systemUnderTest.run(1000)
    );

    assertEquals("No jobs on the execution list!", throwable.getMessage());
  }
}
