package com.cosmos.schoolapp.schoolModel.people.person;

public enum Gender {
  MASCULIN("MASCULIN"),
  FEMININ("FEMININ");

  private final String name;

  Gender(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
