package com.solvd.university.enums;

public enum Specialities {
    MEDICINE(0),
    MODERN_ARTS(1),
    SOFTWARE_ENGINEERING(2);

    final int index;

    public int getValue() {
        return index;
    }

    Specialities(int index) {
        this.index = index;
    }
}
