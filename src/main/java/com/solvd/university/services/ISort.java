package com.solvd.university.services;


public interface ISort <T> {

        default T sort(T collection) {

            return null;
        }


}
