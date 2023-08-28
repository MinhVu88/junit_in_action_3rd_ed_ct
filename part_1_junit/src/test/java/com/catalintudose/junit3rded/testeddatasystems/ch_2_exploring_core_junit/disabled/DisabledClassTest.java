// Listing 2.5
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.disabled;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.lifecycle.SUT;

@Disabled("Feature is still under construction")
public class DisabledClassTest {
	private SUT systemUnderTest = new SUT("Our system under test");

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
