package com.solvd.university.threads;

import java.util.Collection;

public class Connection {

    private Collection<?> dataBase;

    public Connection (Collection<?> dataBase) {
        this.dataBase = dataBase;
    }

    public Collection<?> getDataBase () {
        return dataBase;
    }
}
