module com.ydova.schoolapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;


    opens com.ydova.schoolapp to javafx.fxml;
    exports com.ydova.schoolapp;
    exports com.ydova.schoolapp.entity ;


    exports com.ydova.schoolapp.controller to javafx.fxml;

    opens com.ydova.schoolapp.controller to javafx.fxml;
    opens com.ydova.schoolapp.entity to org.hibernate.orm.core;
}