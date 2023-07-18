package com.cosmos.schoolapp.controller.task;

import io.datafx.controller.flow.FlowView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.testfx.api.FxAssert;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.ViewFlowContext;

import org.testfx.framework.junit5.ApplicationTest;

import java.net.URL;

@SpringBootTest
public class InscriptionControllerTest extends ApplicationTest {
  @Autowired
  private InscriptionController
      myController; // Assuming you have a reference to your controller class

  @BeforeEach
  public void init() {
    myController.lastname = new TextField();
    myController.firstname = new TextField();
    myController.address = new TextField();
    myController.maleCheckBox = new CheckBox();
    myController.femaleCheckBox = new CheckBox();
    myController.birthPlace = new TextField();
    myController.dateOfBirth = new DatePicker();
  }

  @Test
  @Disabled
  public void testControllerMethod() {
    Assertions.assertFalse(myController.checkFields());
    myController.lastname = new TextField("Dongmo Voufo");
    Assertions.assertFalse(myController.checkFields());

    myController.firstname = new TextField("Sagesse Valdes");
    Assertions.assertFalse(myController.checkFields());

    myController.maleCheckBox.setSelected(true);
    Assertions.assertFalse(myController.checkFields());
    myController.birthPlace = new TextField("");
    myController.dateOfBirth = new DatePicker();
    Assertions.assertFalse(myController.checkFields());
  }
}
