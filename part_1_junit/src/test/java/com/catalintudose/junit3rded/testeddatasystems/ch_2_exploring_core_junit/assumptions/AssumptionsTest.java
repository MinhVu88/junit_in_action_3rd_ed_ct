// Listing 2.15
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assumptions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assumptions.environment.JavaSpecification;
import com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assumptions.environment.OperationSystem;
import com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.assumptions.environment.TestsEnvironment;

public class AssumptionsTest {
  private SUT systemUnderTest = new SUT();
  private static String EXPECTED_JAVA_VERSION = "1.8";
  
  private TestsEnvironment testsEnvironment = new TestsEnvironment(
    new JavaSpecification(System.getProperty("java.vm.specification.version")),
    new OperationSystem(System.getProperty("os.name"), System.getProperty("os.arch"))
  );

  @BeforeEach
  void setUp() {
    assumeTrue(testsEnvironment.isWindows());
  }

  @Test
  void testNoJobToRun() {
    assumingThat(
      () -> testsEnvironment.getJavaVersion().equals(EXPECTED_JAVA_VERSION),
      () -> assertFalse(systemUnderTest.hasJobToRun())
    );
  }

  @Test
  void testJobToRun() {
    assumeTrue(testsEnvironment.isAmd64Architecture());

    systemUnderTest.run(new Job());

    assertTrue(systemUnderTest.hasJobToRun());
  }
}
