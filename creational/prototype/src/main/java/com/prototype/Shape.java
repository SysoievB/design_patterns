package com.prototype;

import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@EqualsAndHashCode
public abstract class Shape {
    int x;
    int y;
    String color;

    public abstract Shape clone();
}
