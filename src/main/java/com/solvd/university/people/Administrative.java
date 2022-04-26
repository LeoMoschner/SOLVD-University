package com.solvd.university.people;

import com.solvd.university.customExceptions.UserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Administrative extends Employee implements IcheckUser<Administrative, ArrayList<Administrative>> {

    private final Logger LOGGER = LogManager.getLogger(Administrative.class);
    private final int SALARY_MODIFIER = 20;
    private int hoursPerDay;

    public Administrative(String fullName, int age, String phoneNumber, String email, int employeeID, int hoursPerDay) {
        super(fullName, age, phoneNumber, email, employeeID);
        this.hoursPerDay = hoursPerDay;
        this.calculateSalary(() -> {
            this.setSalary(this.getHoursPerDay() * 5 * 4 * this.getSALARY_MODIFIER());
        });
    }

    public Administrative() {
        super();
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(int hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public int getSALARY_MODIFIER() {
        return SALARY_MODIFIER;
    }

    @Override

    public Administrative checkUser(int id, ArrayList<Administrative> admin) {

        Administrative temp = admin.stream().filter(adm -> adm.getEmployeeID() == id)
                        .findAny().get();
            return temp;

    }
}

