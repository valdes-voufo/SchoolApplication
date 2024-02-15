package com.cosmos.schoolapp;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SchoolApp {

  public static void main(String[] args) {
    Application.launch(
        SchoolGUI.class, args);
  }
}
