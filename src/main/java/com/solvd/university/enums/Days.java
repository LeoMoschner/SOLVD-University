package com.solvd.university.enums;

public enum Days {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5);

    final int dayNum;

    public int getDayNum () {
        return dayNum;
    }

    Days (int dayNum) {
        this.dayNum = dayNum;
    }
}
