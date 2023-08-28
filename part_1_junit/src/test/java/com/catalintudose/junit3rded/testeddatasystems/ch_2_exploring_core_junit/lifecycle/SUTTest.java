// Listing 2.3
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.lifecycle;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SUTTest {
	private static ResourceForAllTests resourceForAllTests;
	private SUT systemUnderTest;

	@BeforeAll
	static void setUpClass() {
		resourceForAllTests = new ResourceForAllTests("resources for all tests");
	}

	@BeforeEach
	void setUp() {
		systemUnderTest = new SUT("system under tests");
	}

	@AfterEach
	void tearDown() {
		systemUnderTest.close();
	}

	@AfterAll
	static void tearDownClass() {
		resourceForAllTests.close();
	}

	@Test
	void testRegularWork() {
		boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();

		assertTrue(canReceiveRegularWork);
	}

	@Test
	void testAdditionalWork() {
		boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();

		assertFalse(canReceiveAdditionalWork);
	}
}
