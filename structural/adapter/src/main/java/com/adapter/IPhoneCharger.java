package com.adapter;

public class IPhoneCharger implements Charger{
    @Override
    public void charge() {
        System.out.println("IPhone charging now...");
    }
}
