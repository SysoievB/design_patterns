package com.mediator;

/**
 * Mediator is a behavioral design pattern that lets you reduce chaotic dependencies
 * between objects. The pattern restricts direct communications between the objects
 * and forces them to collaborate only via a mediator object.
 */
public class Main {
    public static void main(String[] args) {
        AirTrafficControlTower controlTower = new AirportControlTower();

        Airplane airplane1 = new CommercialAirplane(controlTower);
        Airplane airplane2 = new CommercialAirplane(controlTower);

        airplane1.requestTakeoff();
        airplane2.requestLanding();

        // Output:
        // Commercial Airplane: Requesting takeoff clearance.
        // Commercial Airplane: Requesting landing clearance.
    }
}

// Colleague Interface
interface Airplane {
    void requestTakeoff();

    void requestLanding();

    void notifyAirTrafficControl(String message);
}

// Concrete Colleague
class CommercialAirplane implements Airplane {
    private AirTrafficControlTower mediator;

    public CommercialAirplane(AirTrafficControlTower mediator) {
        this.mediator = mediator;
    }

    @Override
    public void requestTakeoff() {
        mediator.requestTakeoff(this);
    }

    @Override
    public void requestLanding() {
        mediator.requestLanding(this);
    }

    @Override
    public void notifyAirTrafficControl(String message) {
        System.out.println("Commercial Airplane: " + message);
    }
}

// Mediator Interface
interface AirTrafficControlTower {
    void requestTakeoff(Airplane airplane);

    void requestLanding(Airplane airplane);
}

// Concrete Mediator
class AirportControlTower implements AirTrafficControlTower {
    @Override
    public void requestTakeoff(Airplane airplane) {
        // Logic for coordinating takeoff
        airplane.notifyAirTrafficControl("Requesting takeoff clearance.");
    }

    @Override
    public void requestLanding(Airplane airplane) {
        // Logic for coordinating landing
        airplane.notifyAirTrafficControl("Requesting landing clearance.");
    }
}
