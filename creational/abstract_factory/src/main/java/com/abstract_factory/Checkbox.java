package com.abstract_factory;

public interface Checkbox {
    void paint();
}
class MacOsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("MacOS Checkbox");
    }
}
class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Windows Checkbox");
    }
}