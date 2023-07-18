package com.cosmos.schoolapp.util;

public class Vanol {

  public static final String[] sequences = {
    "1ère Séquence", "2e Séquence", "3ème Séquence", "4e Séquence", "5e Séquence", "6e Séquence"
  };
  public static final String[] matieres = {"Mathématiques", "Français", "Informatique", "Histoire"};
  public static final String[] classes = {"SIL", "CP", "CE1", "CE2", "CM1", "CM2"};

  public static String[] academicYear = {
    "2022-2023", "2023-2024", "2024-2025", "2025-2026", "2026-2027"
  };

  /*
      public static ClassRoom findFirstAvailableClassroom(Level level) {
      for (ClassRoom classroom : ClassRoom.allClasRoomsList) {
        if (classroom.getLevel() == level && !classroom.isFull()) {
          return classroom;
        }
      }
      return null; // Retourne null si aucune Classroom correspondante n'est trouvée
    }

  public static ObservableList<Level> extractLevels(List<ClassRoom> classrooms) {
    List<Level> levels = classrooms.stream()
            .map(ClassRoom::getLevel) // Récupère le niveau de chaque Classroom
            .collect(Collectors.toList());

    return FXCollections.observableArrayList(levels);
  }

  public String classLeveltoString(){
    return this.level.toString();
  }
   */
}
