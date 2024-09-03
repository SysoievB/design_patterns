package com.adapter;

import lombok.AllArgsConstructor;

/**
 * Adapter allows fitting square pegs into round holes.
 */
@AllArgsConstructor
public class SquarePegAdapter extends RoundPeg {
    private final SquarePeg peg;

    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
