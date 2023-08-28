// Listing 2.6
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.disabled;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.lifecycle.SUT;

public class DisabledMethodsTest {
	private SUT systemUnderTest = new SUT("Our system under test");

	@Test
	@Disabled
	void testRegularWork() {
		boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
		assertTrue(canReceiveRegularWork);
	}

	@Test
	@Disabled("Feature still under construction")
	void testAdditionalWork() {
		boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
		assertFalse(canReceiveAdditionalWork);
	}
}
