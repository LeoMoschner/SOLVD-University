package com.solvd.university.universityStructure;


import com.solvd.university.enums.Days;

public class Schedule {

    private Days day;
    private String startHour;
    private String endHour;

    public Schedule(Days day, String startHour, String endHour) {

        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public void setDay(Days day) {

        this.day = day;
    }

    public String getDay() {
        switch (this.day) {
            case MONDAY:
                return "Mondays";
            case TUESDAY:
                return "Tuesdays";
            case WEDNESDAY:
                return "Wednesdays";
            case THURSDAY:
                return "Thursdays";
            case FRIDAY:
                return "Fridays";
            default:
                return "Invalid day";
        }

    }

    public void setStartHour(String startHour) {

        this.startHour = startHour;
    }

    public String getStartHour() {

        return this.startHour;
    }

    public void setEndHour(String EndHour) {

        this.endHour = EndHour;
    }

    public String getEndHour() {

        return this.endHour;
    }

    @Override
    public String toString() {

        String string;
        string = "\t\t" + this.getDay() + " from " + this.getStartHour() + " to " + this.getEndHour();
        return string;
    }

}
