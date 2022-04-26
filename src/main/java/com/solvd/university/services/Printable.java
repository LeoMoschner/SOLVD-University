package com.solvd.university.services;

public interface Printable <T> {

    default T print() {
       return null;
    }
}
