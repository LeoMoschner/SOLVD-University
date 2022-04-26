package com.solvd.university.universityStructure;

import java.io.IOException;
import java.util.ArrayList;


import com.solvd.university.people.Professor;
import com.solvd.university.people.Student;

public class Subject implements IaddStudent {

    private String name;
    private ArrayList<Schedule> schedule = new ArrayList<>();
    private ArrayList<Professor> professors = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Exam> exams = new ArrayList<>();

    public Subject(String name, Schedule schedule1, Schedule schedule2, Professor professor) {

        this.name = name;
        this.schedule.add(schedule1);
        this.schedule.add(schedule2);
        this.professors.add(professor);
        professor.addSubject(this);
        professor.calculateSalary(() -> {
            professor.setSalary(professor.getNumOfSubjects() * professor.getSALARY_MODIFIER());
        });

    }

    public String getName() {

        return this.name;

    }

    public void setName(String name) {

        this.name = name;
    }

    public ArrayList<Schedule> getSchedule() {

        return this.schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {

        this.schedule = schedule;
    }

    public ArrayList<Student> getStudents() {

        return this.students;
    }

    public void setStudents(ArrayList<Student> student) {

        this.students = student;

    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {

        StringBuilder string;
        string = new StringBuilder("\n\n" + this.getName() + "\n" + "\n\tSchedule: ");

        this.getSchedule().stream().forEach(sched -> {
            string.append("\n\t").append(sched.toString());
        });

        string.append("\n\tProfessors: ");

        this.getProfessors().stream().forEach(prof -> {
            string.append("\n\t").append(prof.getFullName());
        });

        return string.toString();
    }

    @Override
    public void addStudent(Student student) {

        this.getStudents().add(student);

    }


}
