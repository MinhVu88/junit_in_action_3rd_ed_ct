// Listing 2.28
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.anyOf; 
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {
  private static String FIRST_NAME = "Albert";
  private static String LAST_NAME = "Ritter";
  private static Customer customer = new Customer(FIRST_NAME, LAST_NAME);

  @Test
  @DisplayName("is, anyOf & allOf")
  void testHamcrestIs() {
    int price1 = 1, price2 = 1, price3 = 2;

    assertThat(1, is(price1));

    assertThat(1, anyOf(is(price2), is(price3)));

    assertThat(1, allOf(is(price1), is(price2)));
  }

  @Test
  @DisplayName("Null expected")
  void testNull() {
    assertThat(null, nullValue());
  }

  @Test
  @DisplayName("Object expected")
  void testNotNull() {
    assertThat(customer, notNullValue());
  }

  @Test
  @DisplayName("check correct customer properties")
  void checkCorrectCustomerProperties() {
    assertThat(customer, allOf(
      hasProperty("firstName", is(FIRST_NAME)),
      hasProperty("lastName", is(LAST_NAME))
    ));
  }
}
