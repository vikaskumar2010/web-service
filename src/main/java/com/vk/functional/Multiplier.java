package com.vk.functional;

/*
 * 
 * Note - annotation is not mandatory.
 * 
 * 
 * @FunctionalInterface annotation is used to ensure that the functional interface can’t have more
 * than one abstract method. In case more than one abstract methods are present, the compiler flags
 * an ‘Unexpected @FunctionalInterface annotation’ message. However, it is not mandatory to use this
 * annotation.
 * 
 * 
 */


@FunctionalInterface
public interface Multiplier {
  double multiply(int y);
}
