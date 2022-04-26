package com.solvd.university.services;

import com.solvd.university.menu.Menu;
import com.solvd.university.people.Administrative;
import com.solvd.university.people.Student;
import com.solvd.university.threads.Connection;
import com.solvd.university.threads.User;
import com.solvd.university.universityStructure.Speciality;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.reflect.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MenuManager {
    private static final Logger LOGGER = LogManager.getLogger(MenuManager.class);

    //Collections used as dataBase.
    private static final Speciality[] specialities = DataBase.startSpecialityDB();
    private static final ArrayList<Administrative> admins = DataBase.startAdminEmplDB();
    private static final LinkedList<Student> students = DataBase.startStudentDB(specialities);

    private static void showDbWithThreads() {
        Connection connect1 = new Connection(students);
        Connection connect2 = new Connection(admins);
        User<Student> stu = new User<>(connect1);
        User<Administrative> adm = new User<>(connect2);
        ThreadPoolExecutor tp = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        tp.execute(stu);
        tp.execute(adm);
        try {
            tp.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tp.shutdown();

    }

    public static boolean menuManagement() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {


        Menu startMenu = new Menu(
                "Welcome to Leo University."
                        + "\n\t Please select an option:"
                        + "\n\t\t 1. I want to start studying in here."
                        + "\n\t\t 2. I am already a student."
                        + "\n\t\t 3. I am an administrative employee", 3);

        Menu specialitiesMenu = new Menu("Please select one speciality:\n" +
                "\t 1. Medicine.\n" +
                "\t 2. Modern Arts.\n" +
                "\t 3. Software Engineering.", 3);


        Constructor[] constructors = Menu.class.getDeclaredConstructors();
        Parameter[] consPar = constructors[0].getParameters();
        Menu studentIdMenu = (Menu) constructors[0].newInstance("Please enter a student ID. (Valid ID = 10)", 100000);
        Field[] fields = studentIdMenu.getClass().getDeclaredFields();
        Method selectionGetter = studentIdMenu.getClass().getDeclaredMethod("get" + fields[3].getName());

        Menu exitMenu = new Menu("Dou you want to exit the program? \n" +
                "\t1. Yes.\n" +
                "\t2. No, take me back to the beginning.", 2);

        startMenu.print();

        switch (startMenu.getselection()) {
            case 1:
                specialitiesMenu.print();
                UserInput.newStudent(specialities[specialitiesMenu.getselection() - 1]);
                break;
            case 2:
                studentIdMenu.print();
                Student auxStudent = new Student();
                auxStudent = auxStudent.checkUser(studentIdMenu.getselection(), students);
                Menu studentMenu = new Menu("\tPlease select an option:\n" +
                        "\t\t1. Check my info.\n" +
                        "\t\t2. Check my speciality info.\n" +
                        "\t\t3. Make Payment", 3);
                studentMenu.print();
                switch (studentMenu.getselection()) {
                    case 1:
                        auxStudent.print();
                        break;
                    case 2:
                        int specialityIndex = auxStudent.getSpeciality().getIndex();
                        LOGGER.info(specialities[specialityIndex].toString());
                        break;
                    case 3:
                        Payment.doPayment(auxStudent);
                        break;
                }
                break;
            case 3:
                Menu adminIdMenu = new Menu("Please enter your employee ID. (Valid ID: 12345)", 100000);
                adminIdMenu.print();
                Administrative admin = new Administrative();
                admin = admin.checkUser(adminIdMenu.getselection(), admins);
                Menu adminMenu = new Menu("\tPlease select an option:\n" +
                        "\t\t1. Check my info.\n" +
                        "\t\t2. Add approved subject to a student."
                        + "\n\t\t3. Check data base.", 3);
                adminMenu.print();

                switch (adminMenu.getselection()) {
                    case 1:
                        LOGGER.info(admin.toString());
                        break;
                    case 2: {
                        studentIdMenu.print();
                        Student tempStudent = new Student();
                        tempStudent = tempStudent.checkUser(studentIdMenu.getselection(), students);
                        int specialityIndex = tempStudent.getSpeciality().getIndex();
                        Speciality tempSpeciality = specialities[specialityIndex];
                        String subjectString = tempSpeciality.getSubjectsToString();
                        int subjectAmount = tempSpeciality.getSubjects().size();
                        Menu subjectMenu = new Menu("Please select a subject:" + subjectString,
                                subjectAmount);
                        subjectMenu.print();
                        tempStudent.addSubject(tempSpeciality.getSubjects().get(subjectMenu.getselection() - 1));
                        LOGGER.info("Approved subject added successfully");
                        break;
                    }
                    case 3: {
                        LOGGER.info("Students and admin data base using threads: ");
                        showDbWithThreads();
                        break;
                    }
                }
                break;
        }
        exitMenu.print();
        return exitMenu.getselection() != 1;

    }
}
