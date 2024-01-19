// Listing 3.10
package com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.rules;

import org.junit.Rule;
import org.junit.Test;

// This class keeps the CustomRule field private & exposes it through a public getter annotated with @Rule.
// This annotation works only on public & non-static fields & methods.
public class CustomRuleTester2 {
	private CustomRule myRule = new CustomRule();

	@Rule
	public CustomRule getMyRule() {
		return myRule;
	}

	@Test
	public void myCustomRuleTest() {
		System.out.println("Call of a test method");
	}
}
