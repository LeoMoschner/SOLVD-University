package com.solvd.university.people;

import com.solvd.university.universityStructure.Subject;
import com.solvd.university.universityStructure.IaddSubject;

public class Professor extends Employee implements IaddSubject {

    private final int SALARY_MODIFIER = 800;
    private int numOfSubjects;

    public Professor(String fullName, int age, String phoneNumber, String email, int employeeID) {
        super(fullName, age, phoneNumber, email, employeeID);
        this.calculateSalary(() -> {
            this.setSalary(this.getNumOfSubjects() * this.getSALARY_MODIFIER());
        });
    }

    public int getSALARY_MODIFIER() {
        return SALARY_MODIFIER;
    }

    public int getNumOfSubjects() {
        return numOfSubjects;
    }

    public void setNumOfSubjects(int numOfSubjects) {
        this.numOfSubjects = numOfSubjects;
    }

    @Override
    public void addSubject(Subject subject) {
        this.numOfSubjects++;
    }

}
