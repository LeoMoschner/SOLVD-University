package com.solvd.university.people;

public abstract class Employee extends Person {

    private int salary;
    private int employeeID;

    public Employee(String fullName, int age, String phoneNumber, String email, int employeeID) {
        super(fullName, age, phoneNumber, email);
        this.employeeID = employeeID;
    }

    public Employee() {
        super();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String toString() {
        String string = "\n\tFull name: " + this.getFullName() + "\n\tEmployee ID: " + this.getEmployeeID()
                + "\n\tAge: " + this.getAge() + "\n\tPhone number: " + this.getPhoneNumber()
                + "\n\tE-mail: " + this.getEmail() + "\n\tSalary: $" + this.salary;

        return string;
    }

    public void calculateSalary (ICalculateSalary salary) {
        salary.calculateSalary();
    }
}