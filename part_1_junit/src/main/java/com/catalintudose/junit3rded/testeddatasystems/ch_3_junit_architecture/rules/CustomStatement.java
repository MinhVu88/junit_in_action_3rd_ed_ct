// Listing 3.8
package com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

// We declare our CustomStatement class that extends the Statement class.
public class CustomStatement extends Statement {
	// We keep references to a Statement field & a Description field.
	private Statement base;
	private Description description;

	// we use the references as arguments of the constructor.
	public CustomStatement(Statement base, Description description) {
		this.base = base;
		this.description = description;
	}

	// We override the inherited evaluate method & call base.evaluate() inside it.
	@Override
	public void evaluate() throws Throwable {
		System.out.println(
			this.getClass().getSimpleName() + 
			" " + 
			description.getMethodName() + 
			" has started"
		);
		
		try {
			base.evaluate();
		} finally {
			System.out.println(
				this.getClass().getSimpleName() + 
				" " + 
				description.getMethodName() + 
				" has finished"
			);
		}
	}
}
