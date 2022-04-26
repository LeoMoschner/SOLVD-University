package com.solvd.university.universityStructure;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import com.solvd.university.enums.Specialities;
import com.solvd.university.people.Student;

public class Speciality implements IaddStudent, IaddSubject {

    private Specialities name;
    private ArrayList<Subject> subjects = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private int baseCost;

    public Speciality(Specialities name, int baseCost, Subject subject1, Subject subject2, Subject subject3) {

        this.name = name;
        this.baseCost = baseCost;
        this.subjects.add(subject1);
        this.subjects.add(subject2);
        this.subjects.add(subject3);

    }

    public int getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(int baseCost) {
        this.baseCost = baseCost;
    }

    public ArrayList<Student> getStudents() {

        return students;
    }

    public void setStudents(ArrayList<Student> students) {

        this.students = students;
    }

    public ArrayList<Subject> getSubjects() {

        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {

        this.subjects = subjects;
    }

    public String getName() {
        switch (this.name) {
            case MEDICINE:
                return "Medicine";
            case MODERN_ARTS:
                return "Modern Arts";
            case SOFTWARE_ENGINEERING:
                return "Software Engineering";
            default:
                return "Wrong speciality";
        }
    }

    public void setName(Specialities name) {

        this.name = name;
    }

    public int getIndex() {
        return this.name.getValue();
    }

    public String getSubjectsToString() {
        AtomicReference<String> auxString = new AtomicReference<>("");
        AtomicInteger auxInt = new AtomicInteger(1);
        this.getSubjects().stream().forEach(sub -> {
            auxString.set(auxString + "\n\t\t" + auxInt + ". " + sub.getName());
            auxInt.getAndIncrement();
        });
        return auxString.get();
    }

    @Override
    public String toString() {

        StringBuilder string;
        string = new StringBuilder("\nSpeciality: " + this.getName() + "\n\nSubjects: ");

        this.getSubjects().stream().forEach(sub -> string.append((sub.toString())));

        return string.toString();
    }

    @Override
    public void addStudent(Student student) {

        this.getStudents().add(student);
    }

    @Override
    public void addSubject(Subject subject) {

        this.getSubjects().add(subject);
    }


}
