package com.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
/**
 * The Composite Design Pattern is a structural design pattern that lets you
 * compose objects into tree-like structures to represent part-whole hierarchies.
 * It allows clients to treat individual objects and compositions of objects
 * uniformly. In other words, whether dealing with a single object or a group
 * of objects (composite), clients can use them interchangeably.*/
public class Main {
    public static void main(String[] args) {
        // Creating simple tasks
        Task simpleTask1 = new SimpleTask("Complete Coding");
        Task simpleTask2 = new SimpleTask("Write Documentation");

        // Creating a task list
        TaskList projectTasks = new TaskList("Project Tasks");
        projectTasks.addTask(simpleTask1);
        projectTasks.addTask(simpleTask2);

        // Nested task list
        TaskList phase1Tasks = new TaskList("Phase 1 Tasks");
        phase1Tasks.addTask(new SimpleTask("Design"));
        phase1Tasks.addTask(new SimpleTask("Implementation"));

        projectTasks.addTask(phase1Tasks);

        // Displaying tasks
        projectTasks.display();
    }
}

// Component
interface Task {
    String getTitle();

    void setTitle(String title);

    void display();
}

// Leaf
@Getter
@Setter
@AllArgsConstructor
class SimpleTask implements Task {
    private String title;

    @Override
    public void display() {
        System.out.println("Simple Task: " + title);
    }
}

// Composite
@Getter
@Setter
class TaskList implements Task {
    private String title;
    private List<Task> tasks;

    public TaskList(String title) {
        this.title = title;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    @Override
    public void display() {
        System.out.println("Task List: " + title);
        for (Task task : tasks) {
            task.display();
        }
    }
}
