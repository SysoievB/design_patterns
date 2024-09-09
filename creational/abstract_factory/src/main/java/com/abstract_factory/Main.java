package com.abstract_factory;

public class Main {

    private static Application configureApplication() {
        GUIFactory factory = null;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("windows")) {
            factory = new WindowsFactory();
        } else if(osName.contains("mac")) {
            factory = new MacOSFactory();
        }
        return new Application(factory);
    }

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }
}
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    void paint() {
        button.paint();
        checkbox.paint();
    }
}
