package com.ydova.schoolapp.utils;

public class StudentID {
  private static StudentID last;
  private final String charValue;
  private final int intValue;

  private StudentID(String x, int intValue) {
    this.charValue = x;
    this.intValue = intValue;
  }

  @Override
  public String toString() {
    return this.charValue + String.format("%04d", this.intValue);
  }

  public static String generateIdNumber() {
    if (last == null) {
      last = new StudentID("A", 1);
      return last.toString();
    }

    int c = last.charValue.charAt(0);
    StudentID newId;

    if (last.intValue % 10000 == 9999) {
      newId = new StudentID(String.valueOf((char) (c + 1)), 1);
    } else {
      newId = new StudentID(last.charValue, last.intValue + 1);
    }
    last = newId;

    return newId.toString();
  }

  protected static void setLast(String x, int value) {
    last = new StudentID(x, value);
  }
}
