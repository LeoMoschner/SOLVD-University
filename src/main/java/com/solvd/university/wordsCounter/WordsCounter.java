package com.solvd.university.wordsCounter;

import com.solvd.university.services.ISort;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WordsCounter implements ISort<Map <String, Integer>> {

    private static Logger LOGGER = LogManager.getLogger(WordsCounter.class);
    private static Map<String, Integer> wordsMap = new HashMap<>();

    public void wordCounter(String inputPath, String resultPath) throws IOException {

        File article = new File(inputPath);
        File result = new File(resultPath);
        String articleString = FileUtils.readFileToString(article, StandardCharsets.UTF_8).toUpperCase();
        String[] aux = StringUtils.split(articleString);

        Arrays.stream(aux).forEach((word) -> {
            if (wordsMap.containsKey(word)) {
                wordsMap.replace(word, wordsMap.get(word) + 1);
            } else
                wordsMap.put(word, 1);
        });

        wordsMap = sort(wordsMap);
        FileUtils.write(result, "Final Result.\n\tTotal Words: " + aux.length
                + "\n\tUnique Words: " + wordsMap.size() + "\n\n", StandardCharsets.UTF_8);
        FileUtils.writeLines(result, wordsMap.entrySet(), true);
        LOGGER.info("Count completed successfully check result file on: " + resultPath);

    }

    @Override
    public Map<String, Integer> sort(Map<String, Integer> inputMap) {

        TreeMap<String, Integer> sorted = new TreeMap<>();
        sorted.putAll(inputMap);
        return sorted;

    }

}
