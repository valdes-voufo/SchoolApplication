package com.cosmos.schoolapp.schoolModel.people.student;

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
