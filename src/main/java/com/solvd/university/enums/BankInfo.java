package com.solvd.university.enums;

public enum BankInfo {

    ACC_NAME("Leo.University.SOLVD"),
    ACC_NUM("123456798");
    private final String value;

    public String getValue() {
        return value;
    }

    BankInfo(String value) {
        this.value = value;
    }

}
