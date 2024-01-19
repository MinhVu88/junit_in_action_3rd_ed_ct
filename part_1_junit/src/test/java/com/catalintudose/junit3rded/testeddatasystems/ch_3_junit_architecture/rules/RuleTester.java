// Listing 3.6
package com.catalintudose.junit3rded.testeddatasystems.ch_3_junit_architecture.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTester {
	// We declare a TemporaryFolder field annotated with @Rule and initialize it.
	// The @Rule annotation must be applied to a public field or a public method.
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	// We declare the static fields createdFolder & createdFile.
	private static File createdFolder;
	private static File createdFile;

	@Test
	public void testTemporaryFolder() throws IOException {
		// We use the TemporaryFolder field to create a folder & a file, 
		// which are located in the Temp folder of our user profile in the operating system.
		createdFolder = folder.newFolder("createdFolder");
		createdFile = folder.newFile("createdFile.txt");

		// We check the existence of the temporary folder & of the temporary file.
		assertTrue(createdFolder.exists());
		assertTrue(createdFile.exists());
	}

	@AfterClass
	public static void cleanUpAfterAllTestsRan() {
		// At the end of executing the tests, we check that the temporary resources do not exist any longer.
		assertFalse(createdFolder.exists());
		assertFalse(createdFile.exists());
	}
}
