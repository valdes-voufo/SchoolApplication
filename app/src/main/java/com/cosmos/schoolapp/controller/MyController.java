package com.cosmos.schoolapp.controller;

import javafx.scene.Parent;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public interface MyController {

  Parent getPane();

  Parent buildPaneRecursive() throws IOException;
}
