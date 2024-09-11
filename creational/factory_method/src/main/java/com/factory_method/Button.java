package com.factory_method;

interface Button {
    void render();

    void onClick();
}
class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>Html Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Html Button says - 'Hello World!'");
    }
}
class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>Windows Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Windows Button says - 'Hello World!'");
    }
}