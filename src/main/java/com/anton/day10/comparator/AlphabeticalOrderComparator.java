package com.anton.day10.comparator;

import com.anton.day10.composite.TextComponent;

import java.util.Comparator;

public class AlphabeticalOrderComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        String lexeme1 = o1.toString();
        String lexeme2 = o2.toString();
        return lexeme1.compareTo(lexeme2);
    }
}
