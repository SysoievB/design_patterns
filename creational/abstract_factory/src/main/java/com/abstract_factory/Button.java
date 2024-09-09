package com.abstract_factory;

interface Button {
    void paint();
}
class MacOsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac OS X Button");
    }
}
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows Button");
    }
}