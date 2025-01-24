package com.ydova.schoolapp.views;

import com.ydova.schoolapp.controller.SchoolController;
import com.ydova.schoolapp.controller.ControllerFactory;
import com.ydova.schoolapp.controller.MainController;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class ViewsFactory {

   private static   final Map<Views,Object> views = new HashMap<>();



    public  static  Object getInstance(Views view){

        if (views.containsKey(view)){
            return views.get(view);
        }

        switch (view){
            case MAIN:
                BorderPane main = ControllerUtils.loadPane("views/main/main-view.fxml");
                views.put(view,main);
                return  main;

            case SCHOOL:
                AnchorPane school = ControllerUtils.loadPane("views/school/school-view.fxml");
                views.put(view,school);
                return  school;


            default:
                throw new IllegalArgumentException("Unknown view");

        }

    }
}
