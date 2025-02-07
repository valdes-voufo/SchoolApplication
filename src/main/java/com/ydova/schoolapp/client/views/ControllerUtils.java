package com.ydova.schoolapp.client.views;



import com.ydova.schoolapp.SchoolApp;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class ControllerUtils {
  public static <T> T loadPane(String file) {
    System.out.println(file);
    FXMLLoader loader = new FXMLLoader(SchoolApp.class.getResource(file));

      T res;
      try {
        res = loader.load();
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      return res;

  }
}
