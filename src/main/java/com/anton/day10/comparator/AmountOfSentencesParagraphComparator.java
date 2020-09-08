package com.anton.day10.comparator;

import com.anton.day10.composite.TextComponent;

import java.util.Comparator;

public class AmountOfSentencesParagraphComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int length1 = o1.getChildren().size();
        int length2 = o2.getChildren().size();
        return length1 - length2;
    }
}
