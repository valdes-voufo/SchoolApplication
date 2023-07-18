package com.cosmos.schoolapp.util.messages;

public enum FillNotesError {
  ONE_FIELD_EMPTY("ERREUR!!! Un des Champs est vide ou incorrect!");

  private final String name;

  FillNotesError(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
