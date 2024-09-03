package com.adapter;

public class Main {
    public static void main(String[] args) {
        IPhoneWithAnotherVersion iPhone = new IPhoneWithAnotherVersion(new IPhoneToAnotherVersionAdapter(new IPhoneCharger()));
        iPhone.onCharge();
    }
}