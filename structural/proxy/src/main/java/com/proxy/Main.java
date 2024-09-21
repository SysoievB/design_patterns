package com.proxy;

import lombok.val;
/**
 * The Proxy Design Pattern is a structural design pattern that provides a surrogate
 * or placeholder for another object to control access to it. This pattern is useful
 * when you want to add an extra layer of control over access to an object. The proxy
 * acts as an intermediary, controlling access to the real object.*/
public class Main {
    public static void main(String[] args) {
        val image = new ProxyImage("image.jpg");
        //Image will be loaded from disc only when display() is called
        image.display();
        //Image will not be loaded again, as it has been cached in the proxy
        image.display();
    }
}

//Subject
interface Image {
    void display();
}

//RealSubject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
    }

    private void loadImageFromDisc() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying realImage: " + filename);
    }
}

//Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}