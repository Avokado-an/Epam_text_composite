package com.anton.day10.comparator;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.exception.ProgramException;
import com.anton.day10.parser.BasicParser;
import com.anton.day10.parser.impl.CharacterParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class FrequencyOfCharacterAndAlphabetComparator implements Comparator<TextComponent> {
    private static final Logger LOGGER = LogManager.getLogger();
    private char symbolToFind;

    public FrequencyOfCharacterAndAlphabetComparator(char symbolToFind) {
        this.symbolToFind = symbolToFind;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int amountOfEntries1 = calculateSymbolEntries(o1);
        int amountOfEntries2 = calculateSymbolEntries(o2);
        return -1 * (amountOfEntries1 - amountOfEntries2);
    }

    private int calculateSymbolEntries(TextComponent component) {
        int amountOfEntries = 0;
        try {
            BasicParser parser = new CharacterParser();
            List<TextComponent> characters = parser.parseData(component.toString());
            for (TextComponent character : characters) {
                if (character.toString().equalsIgnoreCase(String.valueOf(symbolToFind))) {
                    amountOfEntries++;
                }
            }
        } catch (ProgramException e) {
            LOGGER.log(Level.WARN, "can't compare entries of symbol in lexemes due to inability to parse symbols");
            amountOfEntries = 0;
        }
        return amountOfEntries;
    }
}
