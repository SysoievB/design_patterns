package com.singleton.single_threaded;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);//FOO
        System.out.println(anotherSingleton.value);//FOO
    }
}