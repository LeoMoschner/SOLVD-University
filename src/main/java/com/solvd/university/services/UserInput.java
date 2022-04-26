package com.solvd.university.services;

import com.solvd.university.menu.Menu;
import com.solvd.university.people.Student;
import com.solvd.university.universityStructure.Speciality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;


public class UserInput extends CheckInfo {

    private final static Logger LOGGER = LogManager.getLogger(UserInput.class);
    private static Scanner input = new Scanner(System.in);


    public static String userInput() {

        if (input.hasNextLine()) {
            String scannerSelection = input.nextLine();
            return scannerSelection;
        }
        input.close();
        return null;
    }

    public static Student newStudent(Speciality speciality) {

        String fullName = nameInput();

        int age = ageInput();

        Menu schoolGradeMenu = new Menu("Please enter your overall school grade.\n", 500);
        schoolGradeMenu.print();
        int schoolGrade = schoolGradeMenu.getselection();
        String phoneNumber = phoneNumberInput();
        String email = emailInput();
        // Generating the UniversityID
        final int[] largest = {0};

        speciality.getStudents().stream()
                .filter(std -> std.getUniversityID() > largest[0])
                .forEach(std -> largest[0] = std.getUniversityID());

        int UniversityID = largest[0] + 1;

        Student newStudent = new Student(UniversityID, fullName, age, schoolGrade, speciality, phoneNumber, email);
        speciality.addStudent(newStudent);
        LOGGER.info("Your register completed successfully. Your personal info:");
        LOGGER.info(newStudent.toString());
        LOGGER.info("\nYour speciality info for this semester:");
        LOGGER.info(speciality.toString());
        return newStudent;
    }

    public static int ageInput() {
        LOGGER.info("Please enter your age. You must be over 18 to enroll to this college.");
        String age = userInput();
        return checkAge(age);
    }

    public static String emailInput() {

        LOGGER.info("Please enter your email address");
        String email = userInput();
        return checkEmail(email);
    }

    public static String nameInput() {
        LOGGER.info("Please enter your full name in the following format: \n" +
                "\tSURNAME, Name\n" +
                "\tExample: MESSI, Lionel\n");
        String name = userInput();
        return checkName(name);
    }

    public static String phoneNumberInput() {
        LOGGER.info("Please enter your phone number.\n");
        String phoneNumber = userInput();
        return checkPhoneNumber(phoneNumber);

    }
}
