// Listing 2.25 & 2.26
package com.catalintudose.junit3rded.testeddatasystems.ch_2_exploring_core_junit.hamcrest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.CoreMatchers.anyOf; 
import static org.hamcrest.CoreMatchers.equalTo; 
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamcrestListTest {
  private List<String> values;

  @BeforeEach
  void setUp() {
    values = new ArrayList<>();
    values.add("Michael");
    values.add("John");
    values.add("Edwin");
  }

  @Test
  @DisplayName("List without Hamcrest")
  void testWithoutHamcrest() {
    int expectedResult = 3;
    int actualResult = values.size();

    assertEquals(expectedResult, actualResult);

    assertTrue(
      values.contains("Oliver") || 
      values.contains("Jack") || 
      values.contains("Harry")
    );
  }

  @Test
  @DisplayName("List with Hamcrest")
  void testListWithHamcrest() {
    assertThat(values, hasSize(3));

    assertThat(
      values,
      hasItem(anyOf(
        equalTo("Oliver"),
        equalTo("Jack"),
        equalTo("Harry")
      ))
    );
  }
}
