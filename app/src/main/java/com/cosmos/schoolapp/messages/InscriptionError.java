package com.cosmos.schoolapp.messages;

public class InscriptionError {

  public String fieldEmpty(String fieldName) {
    return String.format("remplir la case %s", fieldName);
  }

  enum Msg {
    DUPLICATE_STUDENT("l'eleve est deja inscrit");

    private final String name;

    Msg(String s) {
      this.name = s;
    }

    public String getName() {
      return name;
    }
  }
}
