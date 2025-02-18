package com.ydova.schoolapp.client.utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class AlertBuilder {
  static boolean testing = false;

  private static Alert createAlert(String title, String message, Alert.AlertType type) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);

    // Center-align text
    Label contentLabel = new Label(message);
    contentLabel.setFont(Font.font("Arial", 14));
    contentLabel.setTextAlignment(TextAlignment.CENTER);

    StackPane stackPane = new StackPane(contentLabel);
    alert.getDialogPane().setContent(stackPane);

    return alert;
  }

  public static Alert alert(String title, String message, Alert.AlertType type) {
    return createAlert(title, message, type);
  }

  public static void error(String message) {
    Alert alert = createAlert("ERREUR", message, Alert.AlertType.ERROR);
    if (!testing) {
      alert.showAndWait();
    }
  }

  public static void info(String message) {
    Alert alert = createAlert("Info", message, Alert.AlertType.INFORMATION);
    // Create a timeline to close the alert after a certain duration
    Duration duration = Duration.seconds(0.5);
    KeyFrame keyFrame = new KeyFrame(duration, event -> alert.close());
    Timeline timeline = new Timeline(keyFrame);
    timeline.setDelay(duration);
    timeline.setOnFinished(event -> alert.close());
    timeline.play();

    alert.showAndWait();
  }
}
