package com.solvd.university.payment;

import com.solvd.university.services.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CreditCard implements IPay {

    private final static Logger LOGGER = LogManager.getLogger(CreditCard.class);
    private String numbers;
    private String fullName;
    private String expDate;
    private String secNum;

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getSecNum() {
        return secNum;
    }

    public void setSecNum(String secNum) {
        this.secNum = secNum;
    }

    @Override
    public void pay() {

        LOGGER.info("Please enter the 16 numbers of your credit card.");
        this.setNumbers(UserInput.userInput());
        LOGGER.info("Please enter your name as it appears in your credit card.");
        this.setFullName(UserInput.userInput());
        LOGGER.info("Please enter the expiration date (MM/YY)");
        this.setExpDate(UserInput.userInput());
        LOGGER.info("Please enter the three numbers on the back of your card");
        this.setSecNum(UserInput.userInput());

    }

}

