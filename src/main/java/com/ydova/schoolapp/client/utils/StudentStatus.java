package com.ydova.schoolapp.client.utils;

public enum StudentStatus {
  REDOUBLANT("REDOUBLANT"),
  NONREDOUBLANT("NONREDOUBLANT");

  private final String value;

  StudentStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
