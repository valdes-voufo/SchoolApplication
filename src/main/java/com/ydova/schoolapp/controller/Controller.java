package com.ydova.schoolapp.controller;

import javafx.scene.Parent;

import java.io.IOException;

public interface Controller {

  Parent getPane();

  Parent buildPaneRecursive() throws IOException;
}
