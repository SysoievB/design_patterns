package com.facade;

public class Main {
    public static void main(String[] args) {
        HotelKeeper keeper = new HotelKeeperImplementation();

        VegMenu v = keeper.getVegMenu();
        NonVegMenu nv = keeper.getNonVegMenu();
    }
}

interface Menus {
}

class VegMenu implements Menus {
}

class NonVegMenu implements Menus {
}

interface Hotel {
    Menus getMenus();
}

class NonVegRestaurant implements Hotel {

    public Menus getMenus() {
        NonVegMenu nv = new NonVegMenu();
        return nv;
    }
}

class VegRestaurant implements Hotel {

    public Menus getMenus() {
        VegMenu v = new VegMenu();
        return v;
    }
}

interface HotelKeeper {
    VegMenu getVegMenu();

    NonVegMenu getNonVegMenu();
}

class HotelKeeperImplementation implements HotelKeeper {

    public VegMenu getVegMenu() {
        VegRestaurant v = new VegRestaurant();
        VegMenu vegMenu = (VegMenu) v.getMenus();
        return vegMenu;
    }

    public NonVegMenu getNonVegMenu() {
        NonVegRestaurant v = new NonVegRestaurant();
        NonVegMenu NonvegMenu = (NonVegMenu) v.getMenus();
        return NonvegMenu;
    }
}
