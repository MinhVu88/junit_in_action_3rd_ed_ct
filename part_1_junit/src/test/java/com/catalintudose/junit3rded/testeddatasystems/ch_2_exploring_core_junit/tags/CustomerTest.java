// Listing 2.8
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.tags;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("individual")
public class CustomerTest {
	private String CUSTOMER_NAME = "Albert Ritter";

	@Test
	void testCustomer() {
		Customer customer = new Customer(CUSTOMER_NAME);

		assertEquals("Albert Ritter", customer.getName());
	}
}
