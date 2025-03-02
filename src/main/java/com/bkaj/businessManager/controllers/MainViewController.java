package com.bkaj.businessManager.controllers;

import com.bkaj.businessManager.App;
import com.bkaj.businessManager.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MainViewController {

    @FXML
    private Button addTaskButton;
    public List<Task> tasks = new LinkedList<>();

    @FXML
    public void handleAddTaskButton() throws IOException {
        App.changeScene("views/add-task-view.fxml");
    }
    @FXML
    public void initialize() {

    }
}
