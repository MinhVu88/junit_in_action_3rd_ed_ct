// Listing 2.24
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.dynamic;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.Iterator;
import static java.util.Arrays.asList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.predicate.PositiveNumberPredicate;

public class DynamicTestsTest {
  private PositiveNumberPredicate positiveNumberPredicate = new PositiveNumberPredicate();

  @BeforeAll
  static void setUpClass() {
    System.out.println("@BeforeAll");
  }

  @BeforeEach
  void setUp() {
    System.out.println("@BeforeEach");
  }

  @AfterEach
  void tearDown() {
    System.out.println("@AfterEach");
  }

  @AfterAll
  static void tearDownClass() {
    System.out.println("@AfterAll");
  }

  @TestFactory
  Iterator<DynamicTest> positiveNumberPredicateTestCases() {
    return asList(
      dynamicTest("negative number", () -> assertFalse(positiveNumberPredicate.check(-1))),
      dynamicTest("zero", () -> assertFalse(positiveNumberPredicate.check(0))),
      dynamicTest("positive number", () -> assertTrue(positiveNumberPredicate.check(1)))
    ).iterator();
  }
}
