// Listing 2.17 (TestReporterParameterResolver)
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.dependencyinjection;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class TestReporterTest {
  @Test
  void testReportSingleValue(TestReporter testReporter) {
    testReporter.publishEntry("Single value");
  }

  @Test
  void testReportKeyValuePair(TestReporter testReporter) {
    testReporter.publishEntry("Key", "Value");
  }

  @Test
  void testReportMultipleKeyValuePairs(TestReporter testReporter) {
    Map<String, String> values = new HashMap<>();

    values.put("user", "Albert");
    values.put("password", "secret");

    testReporter.publishEntry(values);
  }
}
