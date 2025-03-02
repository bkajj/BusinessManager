package com.bkaj.businessManager;

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
}
