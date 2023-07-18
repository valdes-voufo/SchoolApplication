package com.cosmos.schoolapp.util.controller;
/*
 * import com.calendarfx.model.Calendar; import com.calendarfx.model.CalendarSource; import
 * com.calendarfx.view.CalendarView; import java.time.LocalDate; import java.time.LocalTime; import
 * javafx.application.Application; import javafx.application.Platform; import javafx.scene.Scene; import
 * javafx.scene.layout.StackPane; import javafx.stage.Stage;
 *
 * public class CalendarController extends Application { /*
 *
 * @Override public void start(Stage primaryStage) { CalendarView calendarView = new CalendarView(); //
 * calendarView.setEnableTimeZoneSupport(true);
 *
 * Calendar valdes = new Calendar("Valdes"); valdes.setShortName("V"); valdes.setStyle(Calendar.Style.STYLE7);
 *
 * CalendarSource school = new CalendarSource("Family"); school.getCalendars().addAll(valdes);
 *
 * calendarView.getCalendarSources().setAll(school); calendarView.setRequestedTime(LocalTime.now());
 *
 * StackPane stackPane = new StackPane(); stackPane.getChildren().addAll(calendarView); // introPane);
 *
 * Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
 *
 * @Override public void run() { while (true) { Platform.runLater( () -> { calendarView.setToday(LocalDate.now());
 * calendarView.setTime(LocalTime.now()); });
 *
 * try { // update every 10 seconds sleep(10000); } catch (InterruptedException e) { e.printStackTrace(); } } } };
 *
 * updateTimeThread.setPriority(Thread.MIN_PRIORITY); updateTimeThread.setDaemon(true); updateTimeThread.start();
 *
 * Scene scene = new Scene(stackPane); // scene.focusOwnerProperty().addListener(it ->
 * System.out.println("focus owner: " + // scene.getFocusOwner())); primaryStage.setScene(scene); primaryStage.show(); }
 *
 * public static void main(String[] args) { launch(args); }
 */
