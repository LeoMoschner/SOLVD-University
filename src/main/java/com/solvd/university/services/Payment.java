package com.solvd.university.services;

import com.solvd.university.menu.Menu;
import com.solvd.university.payment.CreditCard;
import com.solvd.university.payment.IPay;
import com.solvd.university.people.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.university.payment.IPay.accountName;
import static com.solvd.university.payment.IPay.accountNum;


public class Payment {

    private static final Logger LOGGER = LogManager.getLogger(Payment.class);

    public static void pay (IPay pay) {
        pay.pay();
    }

    public static void doPayment(Student student) {

        if (student.getPayment()) {

            LOGGER.info("Your payment has been already made");

        } else {

            Menu payMenu = new Menu("\nHello! " + student.getFullName() +
                    ". The amount you have to pay is: $" + student.getSemesterCost() +
                    "\n\tPlease select a payment option:" +
                    "\n\t\t1. Bank Deposit." +
                    "\n\t\t2. Credit card.", 2);

            payMenu.print();
            if (payMenu.getselection() == 1) {

                Payment.pay(() -> LOGGER.info("Please deposit your payment to this account:"
                        + "\n\tAccount name: " + accountName.getValue()
                        + "\n\tAccount number: " + accountNum.getValue()
                        + "\n\n Or come to the institution to be personally attended."));

            } else {

                Payment.pay(() -> {
                    CreditCard cd = new CreditCard();
                    LOGGER.info("Please enter the 16 numbers of your credit card.");
                    cd.setNumbers(UserInput.userInput());
                    LOGGER.info("Please enter your name as it appears in your credit card.");
                    cd.setFullName(UserInput.userInput());
                    LOGGER.info("Please enter the expiration date (MM/YY)");
                    cd.setExpDate(UserInput.userInput());
                    LOGGER.info("Please enter the three numbers on the back of your card");
                    cd.setSecNum(UserInput.userInput());
                    student.setPayment(true);
                    LOGGER.info("Your payment has been registered successfully.");
                });

            }
        }
    }
}
