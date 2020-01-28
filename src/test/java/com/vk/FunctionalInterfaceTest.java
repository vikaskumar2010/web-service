package com.vk;

import org.testng.annotations.Test;

import com.vk.functional.Multiplier;

public class FunctionalInterfaceTest {

  @Test
  public void test1() {
    Multiplier m5 = y -> 5 * y; // implementation of Multiplier interface

    Multiplier m7 = y -> 7 * y; // implementation of Multiplier interface

    Multiplier m9 = y -> { // another implementation of Multiplier with multi-line code block
      y = y * 3;
      return y + 9;
    };

    double result = m5.multiply(6);
    System.out.println(result);

    result = m7.multiply(6);
    System.out.println(result);

    result = m9.multiply(6);
    System.out.println(result);

  }
}
