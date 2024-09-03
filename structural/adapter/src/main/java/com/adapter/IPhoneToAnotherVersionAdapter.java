package com.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IPhoneToAnotherVersionAdapter implements Charger {
    private final IPhoneCharger iPhoneCharger;

    @Override
    public void charge() {
        iPhoneCharger.charge();
    }
}
