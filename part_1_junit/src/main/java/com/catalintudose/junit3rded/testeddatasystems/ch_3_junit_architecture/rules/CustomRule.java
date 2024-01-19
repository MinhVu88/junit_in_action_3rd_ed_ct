/*
- Now we would like to write a custom rule, which is useful for providing 
  our own behavior before and after a test is run.
- We might like to start a process before executing a test and stop it after that 
  or connect to a database before executing a test and tear it down afterward.
- To write a rule, we’ll have to create a class that implements the TestRule interface (listing 3.7).
- Consequently, we’ll override the apply(Statement, Description) method, 
  which must return an instance of Statement (listing 3.8).
- Such an object represents the tests within the JUnit runtime & Statement#evaluate() runs them.
- The Description object describes the individual test (listing 3.9); we can use this object to 
  read information about the test through reflection.	
*/
// Listing 3.7
package com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

// We declare a CustomRule class that implements the TestRule interface.
public class CustomRule implements TestRule {
	// We keep references to a Statement field & a Description field.
	private Statement base;
	private Description description;

	// Use the references in the apply method that returns a CustomStatement.
	@Override
	public Statement apply(Statement base, Description description) {
		this.base = base;
		this.description = description;
		return new CustomStatement(base, description);
	}
}
