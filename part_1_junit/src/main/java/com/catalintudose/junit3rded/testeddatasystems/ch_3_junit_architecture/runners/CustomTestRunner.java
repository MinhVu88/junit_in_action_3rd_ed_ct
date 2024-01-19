// Listing 3.2
package com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.runners;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomTestRunner extends Runner {
	// We keep a reference to the tested class, which is initialized inside the constructor.
	private Class<?> testedClass;

	public CustomTestRunner(Class<?> testedClass) {
		this.testedClass = testedClass;
	}

	// We override the abstract getDescription method inherited from the abstract Runner class.
	// This method contains information that is later exported and may be used by various tools.
	@Override
	public Description getDescription() {
		return Description.createTestDescription(
			testedClass, 
			this.getClass().getSimpleName() + " description"
		);
	}

	// We override the abstract run method inherited from the abstract Runner class. 
	@Override
	public void run(RunNotifier notifier) {
		System.out.println(
			"Running tests with " + 
			this.getClass().getSimpleName() + 
			": " + 
			testedClass
		);

		try {
			// Here we create an instance of the tested class.
			Object testObject = testedClass.getDeclaredConstructor().newInstance();

			// We browse all public methods from the tested class and filter the @Test-annotated ones.
			for(Method method : testedClass.getMethods()) {
				if(method.isAnnotationPresent(Test.class)) {
					// We invoke fireTestStarted to tell listeners that an atomic test is about to start.
					notifier.fireTestStarted(
						Description.createTestDescription(
							testedClass, 
							method.getName()
						)
					);

					// We reflectively invoke the original @Test-annotated method.
					method.invoke(testObject);

					// We invoke fireTestFinished to tell listeners that an atomic test has finished.
					notifier.fireTestFinished(
						Description.createTestDescription(
							testedClass, 
							method.getName()
						)
					);
				}
			}
		} catch(
			InstantiationException | 
			IllegalAccessException | 
			InvocationTargetException | 
			IllegalArgumentException | 
			NoSuchMethodException | 
			SecurityException e
		) {
			throw new RuntimeException(e);
		}
	}
}