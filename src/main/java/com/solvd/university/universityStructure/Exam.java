package com.solvd.university.universityStructure;

public class Exam {

    private String statement;
    private Integer grade;

    public Exam(String statement) {

        this.statement = statement;
    }

    public String getStatement() {

        return this.statement;

    }

    public void setStatement(String statement) {

        this.statement = statement;
    }

    public Integer getGrade() {

        return this.grade;
    }

    public void setGrade(int grade) {

        this.grade = grade;
    }
}