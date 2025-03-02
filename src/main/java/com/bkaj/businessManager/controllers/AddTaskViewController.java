package com.bkaj.businessManager.controllers;

import com.bkaj.businessManager.App;
import com.bkaj.businessManager.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AddTaskViewController {
    @FXML
    private Button addTaskButton;

    @FXML
    private TextField taskNameTextField, deadlineTimeTextField, incomeTextField;
    @FXML
    private DatePicker deadlineDatePicker;

    private LocalDateTime parseDateTime() {
        LocalDate date = deadlineDatePicker.getValue();
        String timeText = deadlineTimeTextField.getText();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(timeText, formatter);

        return LocalDateTime.of(date, time);
    }

    @FXML
    public void handleAddTaskButton() throws IOException {
        String taskName = taskNameTextField.getText();
        LocalDateTime deadline = parseDateTime();
        String incomeText = incomeTextField.getText();

        int income = Integer.parseInt(incomeText);

        Task task = new Task(taskName, deadline, income);
        try {
            task.addTaskToDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        App.changeScene("views/main-view.fxml");
    }
}
