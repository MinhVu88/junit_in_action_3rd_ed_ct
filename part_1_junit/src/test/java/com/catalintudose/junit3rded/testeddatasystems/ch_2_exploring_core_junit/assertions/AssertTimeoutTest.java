// Listing 2.13
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assertions;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertTimeoutTest {
  private SUT systemUnderTest = new SUT("Our system under test");

  @Test
  @DisplayName("A job is executed within a timeout")
  void testTimeout() throws InterruptedException {
    systemUnderTest.addJob(new Job("job 1"));

    assertTimeout(
      ofMillis(500), 
      () -> systemUnderTest.run(200)
    );
  }

  @Test
  @DisplayName("A job is executed preemptively within a timeout")
  void testTimeoutPreemptively() throws InterruptedException {
    systemUnderTest.addJob(new Job("job 1"));

    assertTimeoutPreemptively(
      ofMillis(500),
      () -> systemUnderTest.run(200)
    );
  }
}
