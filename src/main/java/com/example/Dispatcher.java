package com.example;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;

public class Dispatcher {
    private final Spinner<Integer> spinner;
    private final ComboBox<Month> comboBox;
    private final Calendar calendar;
    private final Label labelYear;
    private final VBox calendarBody;

    public Dispatcher(Spinner<Integer> spinner, ComboBox<Month> comboBox, Label labelYear, VBox calendarBody) {
        this.spinner = spinner;
        this.comboBox = comboBox;
        this.labelYear = labelYear;
        this.calendar = new Calendar();
        this.calendarBody = calendarBody;
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
        calendar.setCurrentMonth(month);
        calendar.setCurrentYear(year);
        labelYear.setText(month.name() + " " + year);
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
