package com.adapter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IPhoneWithAnotherVersion implements IPhone {
    private final IPhoneToAnotherVersionAdapter adapter;

    @Override
    public void onCharge() {
        adapter.charge();
    }
}
