package com.example;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;

public class Dispatcher {
    private final VBox calendarBody;
    private final Spinner<Integer> spinner;
    private final ComboBox<Month> comboBox;
    private final Calendar calendar;
    private final Label labelYear;

    public Dispatcher(VBox calendarBody, Spinner<Integer> spinner, ComboBox<Month> comboBox, Label labelYear) {
        this.calendarBody = calendarBody;
        this.spinner = spinner;
        this.comboBox = comboBox;
        this.labelYear = labelYear;
        this.calendar = new Calendar();
    }

    public void initialize() {
        comboBox.getItems().addAll(Month.values());
        comboBox.setOnAction(event -> handler());
        comboBox.getSelectionModel().selectFirst();
        spinner.valueProperty().addListener((event) -> handler());
        spinner.setEditable(true);
    }

    private void handler() {
        Month month = comboBox.getValue();
        int year = spinner.getValue();
        labelYear.setText(month.name() + " " + year);
        calendar.setCurrentMonth(month);
        calendar.setCurrentYear(year);
        labelFactory();
    }

    private void labelFactory() {
        calendarBody.getChildren().clear();
        WeekFactory weekFactory = new WeekFactory(calendar);
        for (int i = 0; i < 6; i++) {
            Label label = new Label(weekFactory.nextWeek());
            calendarBody.getChildren().add(label);
        }
    }
}
