package com.solvd.university.threads;

import com.solvd.university.people.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Thread implementation is on method showDbWithThreads inside MenuManager class
 * (MenuManager.showDbWithTrheads)
 */

public class User<T extends Person> extends Thread {

    private static final Logger LOGGER = LogManager.getLogger(User.class);
    private Connection dbConnection;

    public User(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void run() {

        dbConnection.getDataBase().stream().forEach(c -> {
            LOGGER.info(c.getClass().toString() + c.toString());
        });
    }
}
