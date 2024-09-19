package com.composite;

public class Main {
    public static void main(String[] args) {
    }
}

// Component
interface Task {
    String getTitle();

    void setTitle(String title);

    void display();
}

// Leaf
class SimpleTask implements Task {
    private String title;

    public SimpleTask(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Simple Task: " + title);
    }
}

