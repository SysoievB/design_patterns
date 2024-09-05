package com.singleton.multithreaded;

public final class MultithreadedSingleton {
    private static MultithreadedSingleton instance;
    public String value;

    private MultithreadedSingleton(String value) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static MultithreadedSingleton getInstance(String value) {
        if (instance == null) {
            instance = new MultithreadedSingleton(value);
        }
        return instance;
    }
}