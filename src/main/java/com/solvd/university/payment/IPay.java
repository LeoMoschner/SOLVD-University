package com.solvd.university.payment;

import com.solvd.university.enums.BankInfo;

@FunctionalInterface
public interface IPay {
    BankInfo accountName = BankInfo.ACC_NAME;
    BankInfo accountNum = BankInfo.ACC_NUM;

    void pay();
}
