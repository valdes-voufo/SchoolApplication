package com.cosmos.schoolapp.messages;

public class NoteMessage {

  public static String getFicheCharger(String sale, String seq, String matiere) {
    return "Fiche de Notes des élèves de la "
        + sale
        + " pour le compte de la "
        + seq
        + " en "
        + matiere;
  }

  public static String getChampMalRemplis() {
    return "ERREUR!!! Un des Champs est vide ou incorrect!";
  }
}
