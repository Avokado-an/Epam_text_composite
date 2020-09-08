package com.anton.day10.reader;

import main.java.com.anton.day10.exception.ProgramException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextFileReader {
    private static final Logger LOGGER = LogManager.getLogger(TextFileReader.class);

    public String readFile(String fileName) throws ProgramException {
        if (fileName == null) {
            throw new ProgramException();
        }
        StringBuilder res = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(res::append);
            LOGGER.log(Level.INFO, "File read properly");
        } catch (IOException e) {
            throw new ProgramException("File reader exception");
        }
        return res.toString();
    }

    // TODO: 06.09.2020 add own interpreter + add tests for fileReader + add null wrapper everywhere + add invalid tests for null values and stuff 
}
