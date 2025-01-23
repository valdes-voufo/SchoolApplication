package com.ydova.schoolapp.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
  private static final Map<Class<?>, Object> instances = new HashMap<>();

  // Generic method to get an instance of a class
  @SuppressWarnings("unchecked")
  public static <T> T getInstance(Class<T> clazz) {
    // Check if an instance of the class already exists
    if (!instances.containsKey(clazz)) {
      try {
        // Create a new instance and store it
        T instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);
      } catch (Exception e) {
        throw new RuntimeException("Unable to create instance of " + clazz.getName(), e);
      }
    }
    // Return the existing or newly created instance
    return (T) instances.get(clazz);
  }
}
