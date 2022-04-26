package com.solvd.university.wordsCounter;

import com.solvd.university.menu.Menu;
import com.solvd.university.services.UserInput;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Runner {

    private static Logger LOGGER = LogManager.getLogger(Runner.class);
    private static String inputPath = "src/main/resources/article.txt";
    private static String resultPath = "src/main/resources/result.txt";

    public static void main(String args[]) throws IOException {

        Menu inputPathMenu = new Menu("Welcome to the ultimate words counter. Please select an option:" +
                "\n\t1. Choose particular input path." +
                "\n\t2. Use default input path (resources/article.txt)", 2);
        Menu outputPathMenu = new Menu("Please select an option:" +
                "\n\t1. Choose particular output path." +
                "\n\t2. Use default output path (resources/result.txt)", 2);

        inputPathMenu.print();
        if (inputPathMenu.getselection() == 1) {
            LOGGER.info("Please enter a path.");
            inputPath = UserInput.userInput();
        }

        outputPathMenu.print();
        if (outputPathMenu.getselection() == 1) {
            LOGGER.info("Please enter a path.");
            resultPath = UserInput.userInput();
        }

        WordsCounter aux = new WordsCounter();
        aux.wordCounter(inputPath, resultPath);

    }
}
