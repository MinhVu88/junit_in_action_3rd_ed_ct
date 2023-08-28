// Listing 2.16 (TestInfoParameterResolver)
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.dependencyinjection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class TestInfoTest {
  TestInfoTest(TestInfo testInfo) {
    String testedClassName = "TestInfoTest";

    assertEquals(testedClassName, testInfo.getDisplayName());
  }

  @BeforeEach
  void setUp(TestInfo testInfo) {
    String displayedName = testInfo.getDisplayName();

    assertTrue(
      displayedName.equals("display name of the method") ||
      displayedName.equals("testGetNameOfTheMethod(TestInfo)")
    );
  }

  @Test
  void testGetNameOfTheMethod(TestInfo testInfo) {
    assertEquals("testGetNameOfTheMethod(TestInfo)", testInfo.getDisplayName());
  }

  @Test
  @DisplayName("display name of the method")
  void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
    assertEquals("display name of the method", testInfo.getDisplayName());
  }
}
