// Listing 3.9
package com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.rules;

import org.junit.Rule;
import org.junit.Test;

public class CustomRuleTester {
	@Rule
	public CustomRule myRule = new CustomRule();

	@Test
	public void myCustomRuleTest() {
		System.out.println("Call of a test method");
	}
}
