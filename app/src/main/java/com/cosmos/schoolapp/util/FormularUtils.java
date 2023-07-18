package com.cosmos.schoolapp.util;

import javafx.scene.control.TextFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.UnaryOperator;

public class FormularUtils {
  public static UnaryOperator<TextFormatter.Change> amountsFilter4TextField() {
    return change -> {
      String newText = change.getControlNewText();
      if (newText.matches("[0-9]*")) {
        return change;
      }
      return null;
    };
  }

  public static UnaryOperator<TextFormatter.Change> dateFilter4TextField() {
    return change -> {
      String newText = change.getControlNewText();
      DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

      try {
        LocalDate.parse(newText, dateFormatter);
        return change;
      } catch (Exception e) {
        return null;
      }
    };
  }
}
