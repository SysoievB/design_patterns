package com.inversion_of_control;

import lombok.RequiredArgsConstructor;

interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println(message);
    }
}

class SmsService implements MessageService {
    public void sendMessage(String message) {
        System.out.println(message);
    }
}

@RequiredArgsConstructor
class NotificationService {
    private final MessageService messageService;

    void notify(String message) {
        messageService.sendMessage(message);
    }
}

class Main {
    public static void main(String[] args) {
        MessageService emailService = new EmailService();
        MessageService smsService = new SmsService();

        NotificationService emailNotification = new NotificationService(emailService);
        NotificationService smsNotification = new NotificationService(smsService);
        emailNotification.notify("Hello World");
        smsNotification.notify("Hello World");
    }
}