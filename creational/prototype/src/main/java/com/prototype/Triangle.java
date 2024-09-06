package com.prototype;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Triangle extends Shape {

    public Triangle(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public Shape clone() {
        return new Triangle(this.x, this.y, this.color);
    }
}
