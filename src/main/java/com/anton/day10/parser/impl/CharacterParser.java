package com.anton.day10.parser.impl;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.impl.SymbolComponent;
import com.anton.day10.composite.type.CharacterType;
import com.anton.day10.parser.BasicParser;
import main.java.com.anton.day10.exception.ProgramException;

import java.util.ArrayList;
import java.util.List;

public class CharacterParser implements BasicParser {
    private static final String CHARACTER_REGEX = "";
    private static final String PUNCTUATION_REGEX = "[.]{3}|[.!,?]";

    @Override
    public List<TextComponent> parseData(String text) throws ProgramException {
        if (text == null) {
            throw new ProgramException();
        }
        List<TextComponent> symbolComponents = new ArrayList<>();
        String[] symbols = text.split(CHARACTER_REGEX);
        for (String symbol : symbols) {
            if (symbol.matches(PUNCTUATION_REGEX)) {
                symbolComponents.add(new SymbolComponent(symbol, CharacterType.PUNCTUATION));
            } else {
                symbolComponents.add(new SymbolComponent(symbol, CharacterType.SYMBOL));
            }
        }
        return symbolComponents;
    }
}
