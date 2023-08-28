// Listing 2.7
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.nested;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedTestsTest {
  private static final String FIRST_NAME = "Albert";
  private static final String LAST_NAME = "Ritter";

  @Nested
  class BuilderTest {
    private String MIDDLE_NAME = "Otto";

    @Test
    void customerBuilder() throws ParseException {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
      
      Date customerDate = simpleDateFormat.parse("08-15-2023");

      Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
                                      .withMiddleName(MIDDLE_NAME)
                                      .withBecomeCustomer(customerDate)
                                      .build();

      assertAll(() -> {
        assertEquals(Gender.MALE, customer.getGender());
        assertEquals(FIRST_NAME, customer.getFirstName());
        assertEquals(MIDDLE_NAME, customer.getMiddleName());
        assertEquals(LAST_NAME, customer.getLastName());
        assertEquals(customerDate, customer.getBecomeCustomer());
      });
    }
  }

  @Nested
  class CustomerEqualsTest {
    private String OTHER_FIRST_NAME = "John";
    private String OTHER_LAST_NAME = "Doe";

    @Test
    void testDifferentCustomers() {
      Customer customer1 = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
      Customer customer2 = new Customer.Builder(Gender.MALE, OTHER_FIRST_NAME, OTHER_LAST_NAME).build();

      assertNotEquals(customer1, customer2);
    }

    @Test
    void testSameCustomers() {
      Customer customer1 = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
      Customer customer2 = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();

      assertAll(() -> {
        assertEquals(customer1, customer2);
        assertNotSame(customer1, customer2);
      });
    }
  }

  @Nested
  class CustomerHashCodeTest {
    private String OTHER_FIRST_NAME = "Jane";
    private String OTHER_LAST_NAME = "Doe";

    @Test
    void testDifferentCustomers() {
      Customer customer1 = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
      Customer customer2 = new Customer.Builder(Gender.FEMALE, OTHER_FIRST_NAME, OTHER_LAST_NAME).build();

      assertNotEquals(customer1.hashCode(), customer2.hashCode());
    }

    @Test
    void testSameCustomer() {
      Customer customer1 = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
      Customer customer2 = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();

      assertEquals(customer1.hashCode(), customer2.hashCode());
    }
  }
}
