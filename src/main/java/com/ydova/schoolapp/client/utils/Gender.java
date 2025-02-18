package com.ydova.schoolapp.client.utils;

public enum Gender {
  MALE("MASCULIN"),
  FEMALE("FEMININ");

  private final String name;

  Gender(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
