// Listing 2.9
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.tags;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("repository")
public class CustomersRepositoryTest {
  private String CUSTOMER_NAME = "Edward Snowden";
  private CustomersRepository customersRepository = new CustomersRepository();

  @Test
  void testNonExistence() {
    boolean exists = customersRepository.contains("Edward Snowden");

    assertFalse(exists);
  }

  @Test
  void testCustomerPersistence() {
    customersRepository.persist(new Customer(CUSTOMER_NAME));

    assertTrue(customersRepository.contains("Edward Snowden"));
  }
}
