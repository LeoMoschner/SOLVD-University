package com.solvd.university.people;

import java.util.Collection;

public interface IcheckUser<T extends Person, K extends Collection> {

    default T checkUser(int id, K peopleList) {
        return null;
    }
}
