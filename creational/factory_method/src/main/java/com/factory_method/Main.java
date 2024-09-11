package com.factory_method;

public class Main {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    /**
     * Приложение создаёт определённую фабрику в зависимости от конфигурации или
     * окружения.
     */
    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    /**
     * Весь остальной клиентский код работает с фабрикой и продуктами только
     * через общий интерфейс, поэтому для него неважно какая фабрика была
     * создана.
     */
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
/**
 * Базовый класс фабрики. Заметьте, что "фабрика" – это всего лишь
 * дополнительная роль для класса. Он уже имеет какую-то бизнес-логику, в
 * которой требуется создание разнообразных продуктов.
 */
abstract class Dialog {

    public void renderWindow() {
        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Подклассы будут переопределять этот метод, чтобы создавать конкретные
     * объекты продуктов, разные для каждой фабрики.
     */
    public abstract Button createButton();
}

class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}

class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}