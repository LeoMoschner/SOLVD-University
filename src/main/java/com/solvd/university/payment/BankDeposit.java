package com.solvd.university.payment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BankDeposit implements IPay {

    private final static Logger LOGGER = LogManager.getLogger(BankDeposit.class);

    @Override
    public void pay() {
        LOGGER.info("Please deposit your payment to this account:"
                + "\n\tAccount name: " + accountName.getValue()
                + "\n\tAccount number: " + accountNum.getValue()
                + "\n\n Or come to the institution to be personally attended.");
    }
}
