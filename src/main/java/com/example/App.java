package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {

        HBox parent = new HBox(20);
        VBox leftSide = new VBox(2);
        VBox rightSide = new VBox(30);
        Label labelYear = new Label("Month Year");
        String line = "=====================================";
        String week = "  Sun  Mon  Tue  Wed  Thu  Fri  Sat";
        Label labelLineOne = new Label(line);
        Label labelWeekDays = new Label(week);
        Label labelLineTwo = new Label(line);
        VBox calendarBody = new VBox(2);
        Spinner<Integer> spinner = new Spinner<>(0, 5000, 2022);
        ComboBox<Month> comboBox = new ComboBox<>();
        leftSide.getChildren().addAll(labelYear, labelLineOne, labelWeekDays, labelLineTwo, calendarBody);
        rightSide.getChildren().addAll(comboBox, spinner);
        parent.getChildren().addAll(leftSide, rightSide);
        Scene scene = new Scene(parent, 1200, 400);
        stage.setTitle("Calendar");
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add("styles.css");
        Dispatcher dispatcher = new Dispatcher(spinner, comboBox, labelYear, calendarBody);
        dispatcher.initialize();

        leftSide.setMinWidth(700);
        rightSide.setPadding(new Insets(50, 0, 0, 0));
        comboBox.setMinWidth(300);
        spinner.setMinWidth(300);
        labelYear.setMinWidth(550);
        labelYear.setAlignment(Pos.CENTER);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
