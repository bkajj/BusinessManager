package com.bkaj.businessManager;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.time.LocalDateTime;

public class Task {

    String name;
    LocalDateTime deadline;
    Boolean completed;
    Integer income;
    Integer priority;

    public Task(String name, LocalDateTime deadline, Integer income, Integer priority) {
        this.name = name;
        this.deadline = deadline;
        this.completed = false;
        this.income = income;
        this.priority = priority;
    }

    public Task(String name, LocalDateTime deadline, Integer income) {
        this.name = name;
        this.deadline = deadline;
        this.completed = false;
        this.income = income;
        this.priority = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Duration timeToDeadline() {
        return Duration.between(deadline, LocalDateTime.now());
    }

    public void addTaskToDatabase() throws SQLException {
        String query = "INSERT INTO tasks (TaskName, Deadline, Completed, Income, Priority) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = App.getDbConnection().prepareStatement(query)) {

            preparedStatement.setString(1, name);
            preparedStatement.setObject(2, deadline);
            preparedStatement.setBoolean(3, completed);
            preparedStatement.setInt(4, income);
            preparedStatement.setInt(5, priority);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
