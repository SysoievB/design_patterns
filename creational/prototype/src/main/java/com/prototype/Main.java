package com.prototype;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(10, 20, "Red");
        Triangle cloneTriangle = (Triangle) triangle.clone();

        System.out.println(triangle.toString());
        System.out.println(cloneTriangle.toString());
    }
}