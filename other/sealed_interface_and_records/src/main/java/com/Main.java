package com;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW");
        System.out.println(car.commonMethod());
    }
}

sealed interface CommonSealedInterface permits Car, Truck{
    String commonMethod();
}

record Car(String param) implements CommonSealedInterface {
    @Override
    public String commonMethod() {
        return param;
    }
}
record Truck(String param) implements CommonSealedInterface {
    @Override
    public String commonMethod() {
        return param;
    }
}