package com.callback;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.onClick(new ClickHandler());

        Button lambdaButton = new Button();
        lambdaButton.onClick(() -> System.out.println("Lambda"));
    }
}

interface ClickEventHandler {
    void handleClick();
}

class ClickHandler implements ClickEventHandler {
    @Override
    public void handleClick() {
        System.out.println("Clicked");
    }
}

class Button {
    void onClick(ClickEventHandler handler) {
        handler.handleClick();
    }
}