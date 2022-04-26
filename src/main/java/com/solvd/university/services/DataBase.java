package com.solvd.university.services;

import com.solvd.university.enums.Days;
import com.solvd.university.enums.Specialities;
import com.solvd.university.people.Administrative;
import com.solvd.university.people.Professor;
import com.solvd.university.people.Student;
import com.solvd.university.threads.User;
import com.solvd.university.universityStructure.Schedule;
import com.solvd.university.universityStructure.Speciality;
import com.solvd.university.universityStructure.Subject;

import java.util.*;


public class DataBase implements ISort<LinkedList> {


    public static Speciality[] startSpecialityDB() {

        Speciality[] dataBase = new Speciality[3];

        dataBase[0] = startMedicineDB();
        dataBase[1] = startArtsDB();
        dataBase[2] = startSoftEngDB();

        return dataBase;

    }

    public static ArrayList<Administrative> startAdminEmplDB() {

        Administrative titorJohn = new Administrative("TITOR, John", 32, "2312154",
                "johntitor@gmail.com", 12345, 4);
        Administrative sainzCarlos = new Administrative("SAINZ, Carlos", 26, "879454",
                "carlitosf1@gmail.com", 4545, 6);
        Administrative norrisLando = new Administrative("NORRIS, Lando", 20, "546452",
                "norrisbutnotchuck@gmail.com", 7892, 8);

        ArrayList<Administrative> admins = new ArrayList<>();
        admins.add(titorJohn);
        admins.add(sainzCarlos);
        admins.add(norrisLando);
        return admins;
    }

    public static LinkedList<Student> startStudentDB(Speciality[] specialities) {

        LinkedList<Student> students = new LinkedList<>();

        Arrays.stream(specialities)
                .forEach(spe -> spe.getStudents().stream()
                        .forEach(std -> students.add(std)));

        return students;
    }

    public static HashSet<Professor> startProfessorDB(Speciality[] specialities) {

        HashSet<Professor> professors = new HashSet<>();

        Arrays.stream(specialities).forEach(spe -> spe.getSubjects().stream()
                .forEach(sub -> sub.getProfessors().stream()
                        .forEach(prof -> professors.add(prof))));
        return professors;
    }

    private static Speciality startMedicineDB() {

        Schedule mondayMorning = new Schedule(Days.MONDAY, "8:00", "12:00");
        Schedule tuesdayMorning = new Schedule(Days.TUESDAY, "8:00", "12:00");
        Schedule wednesdayMorning = new Schedule(Days.WEDNESDAY, "8:00", "12:00");
        Schedule thursdayMorning = new Schedule(Days.THURSDAY, "8:00", "12:00");
        Schedule fridayMorning = new Schedule(Days.FRIDAY, "8:00", "12:00");
        Schedule fridayAfternoon = new Schedule(Days.FRIDAY, "16:00", "20:00");

        Professor perezJuan = new Professor("PEREZ, Juan", 40, "2345872",
                "	juan_perez21@gmail.com", 123);
        Professor drHouse = new Professor("Dr Gregory House", 40, "45664", "drgregoryHouse@hotmail.com", 321);
        Professor familyGuy = new Professor("HARTMAN, Elmer", 46, "21548", "elmerHartman@gmail.com", 4564);

        Subject anatomy = new Subject("Anatomy", mondayMorning, wednesdayMorning, perezJuan);

        Subject notARealSubject1 = new Subject("How to perform a tracheotomy with a spoon I", tuesdayMorning,
                thursdayMorning, familyGuy);
        Subject notARealSubject2 = new Subject("How to perform a tracheotomy with a spoon II", fridayMorning,
                fridayAfternoon, drHouse);

        Speciality medicine = new Speciality(Specialities.MEDICINE, 720000, anatomy, notARealSubject1, notARealSubject2);
        Student messiLionel = new Student(10, "MESSI, Lionel", 33, 350, medicine, "54541267", "thegoat10@gmail.com");

        return medicine;

    }

    private static Speciality startArtsDB() {

        Schedule tuesdayMorning = new Schedule(Days.TUESDAY, "8:00", "12:00");
        Schedule thursdayMorning = new Schedule(Days.THURSDAY, "8:00", "12:00");
        Schedule mondayAfternoon = new Schedule(Days.MONDAY, "16:00", "20:00");
        Schedule wednesdayAfternoon = new Schedule(Days.WEDNESDAY, "16:00", "20:00");

        Professor drJonOsterman = new Professor("Dr Manhattan", 152, "00056", "imactuallygod@gmail.com", 546);

        Professor familyGuy = new Professor("HARTMAN, Elmer", 46, "21548", "elmerHartman@gmail.com", 785);
        Professor theSimpsons = new Professor("KRABAPPEL, Edna", 38, "45125", "bartfangirl@gmail.com", 5649);

        Subject notARealSubject3 = new Subject("How to paint like Miguel Angel", mondayAfternoon, wednesdayAfternoon,
                familyGuy);
        Subject notARealSubject4 = new Subject("How to recreate the monalisa with a single pencil", tuesdayMorning,
                thursdayMorning, drJonOsterman);
        Subject notARealSubject5 = new Subject("How to clean your brushes", tuesdayMorning, thursdayMorning,
                theSimpsons);

        Speciality arts = new Speciality(Specialities.MODERN_ARTS, 300000, notARealSubject3, notARealSubject4, notARealSubject5);

        Student ronaldoCristiano = new Student(7, "RONALDO, Cristiano", 35, 320, arts, "875643",
                "cr7_thebest@gmail.com");
        return arts;

    }

    private static Speciality startSoftEngDB() {

        Schedule tuesdayMorning = new Schedule(Days.TUESDAY, "8:00", "12:00");
        Schedule thursdayMorning = new Schedule(Days.THURSDAY, "8:00", "12:00");
        Schedule fridayMorning = new Schedule(Days.FRIDAY, "8:00", "12:00");
        Schedule mondayAfternoon = new Schedule(Days.MONDAY, "16:00", "20:00");
        Schedule wednesdayAfternoon = new Schedule(Days.WEDNESDAY, "16:00", "20:00");
        Schedule fridayAfternoon = new Schedule(Days.FRIDAY, "16:00", "20:00");

        Professor bezosJeff = new Professor("BEZOS, Jeff", 76, "478135", "primevideo@gmail.com", 5624);
        Professor muskElon = new Professor("ELON, Musk", 50, "456987", "space_XD@gmail.com", 2213);
        Professor zuckerbergMark = new Professor("ZUCKERBERG, Mark", 76, "115456", "markatack@gmail.com", 7852);

        Subject notARealSubject6 = new Subject("How to hack the NASA", fridayMorning, fridayAfternoon, muskElon);
        Subject notARealSubject7 = new Subject("How to make Facebook", mondayAfternoon, wednesdayAfternoon,
                zuckerbergMark);
        Subject notARealSubject8 = new Subject("How to make Amazon", tuesdayMorning, thursdayMorning, bezosJeff);

        Speciality softwareEngineering = new Speciality(Specialities.SOFTWARE_ENGINEERING, 700000, notARealSubject6,
                notARealSubject7, notARealSubject8);

        Student ronaldoCristiano = new Student(23842, "MOSCHNER, Leandro", 23, 350, softwareEngineering, "54561",
                "L.espindolamoschner@gmail.com");
        return softwareEngineering;
    }

    @Override

    public LinkedList sort(LinkedList inputList) {

        Collections.sort(inputList);
        return inputList;
    }

}
