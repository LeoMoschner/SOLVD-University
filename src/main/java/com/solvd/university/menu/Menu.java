package com.solvd.university.menu;

import com.solvd.university.services.CheckInfo;
import com.solvd.university.services.Printable;
import com.solvd.university.services.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Menu extends CheckInfo implements Printable<Integer> {

    private final static Logger LOGGER = LogManager.getLogger(Menu.class);
    private String statement;
    private int options;
    private int selection;
    private UserInput util = new UserInput();


    public Menu(String statement, int options) {
        this.statement = statement;
        this.options = options;
    }

    public int getselection() {
        return this.selection;
    }

    @Override
    public String toString() {
        return this.statement;
    }

    @Override
    public Integer print () {
        LOGGER.info(this.toString());
        String userInput = UserInput.userInput();
        this.selection = Integer.parseInt(checkSelections(userInput, this.options));
        return this.selection;

    }
}
