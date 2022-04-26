package com.solvd.university.people;

import java.util.ArrayList;
import java.util.LinkedList;

import com.solvd.university.services.Printable;
import com.solvd.university.universityStructure.Speciality;
import com.solvd.university.universityStructure.Subject;
import com.solvd.university.universityStructure.IaddSubject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Student extends Person implements IaddSubject, IcheckUser<Student, LinkedList<Student>>, Printable {

    private final static Logger LOGGER = LogManager.getLogger(Student.class);
    private int UniversityID;
    private Speciality speciality;
    private int schoolGrade;
    private ArrayList<Subject> approvedSubjects = new ArrayList<>();
    private int semesterCost;
    private boolean payment;

    public Student(int UniversityID, String fullName, int age, int schoolGrade, Speciality speciality, String phoneNumber, String email) {
        super(fullName, age, phoneNumber, email);
        this.UniversityID = UniversityID;
        this.schoolGrade = schoolGrade;
        this.speciality = speciality;
        this.speciality.getStudents().add(this);
        this.calculateCost(() -> {
            this.semesterCost = (this.speciality.getBaseCost() * this.speciality.getSubjects().size() / this.schoolGrade);
        });

    }

    public Student() {
    }

    public void setUniversityID(int UniversityID) {
        this.UniversityID = UniversityID;
    }

    public int getUniversityID() {
        return this.UniversityID;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public int getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(int schoolGrade) {
        this.schoolGrade = schoolGrade;
    }

    public int getSemesterCost() {
        return this.semesterCost;
    }

    public void setSemesterCost(int semesterCost) {
        this.semesterCost = semesterCost;
    }

    public ArrayList<Subject> getApprovedSubjects() {
        return this.approvedSubjects;
    }

    public void setApprovedSubjects(ArrayList<Subject> subjects) {
        this.approvedSubjects = subjects;
    }

    public boolean getPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        String string;
        string = "\n\tFull name: " + this.getFullName() + "\n\tUniversity ID: " + this.getUniversityID()
                + "\n\tSpeciality: " + this.getSpeciality().getName()
                + "\n\tCost this semester: $" + this.getSemesterCost()
                + "\n\tAge: " + this.getAge() + "\n\tPhone number: " + this.getPhoneNumber()
                + "\n\tE-mail: " + this.getEmail();
        return string;
    }

    @Override
    public void addSubject(Subject subject) {
        this.getApprovedSubjects().add(subject);

    }

    @Override
    public Student checkUser(int id, LinkedList<Student> students) {

        Student temp = students.stream().filter(std -> std.getUniversityID() == id)
                .findAny().get();
        return temp;
    }

    @Override
    public void print() {
        LOGGER.info(this.toString());
    }

    public void calculateCost(ICalculateCost cost) {
        cost.calculateCost();
    }

}








