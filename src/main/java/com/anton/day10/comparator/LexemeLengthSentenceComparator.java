package com.anton.day10.comparator;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.impl.TextComposite;
import com.anton.day10.composite.type.ComponentType;
import com.anton.day10.parser.BasicParser;
import com.anton.day10.parser.impl.LexemeParser;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LexemeLengthSentenceComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int lexemeLength1 = findLongestLexeme(o1).toString().length();
        int lexemeLength2 = findLongestLexeme(o2).toString().length();
        return lexemeLength1 - lexemeLength2;
    }

    private TextComponent findLongestLexeme(TextComponent sentence) {
        TextComponent longestLexeme;
        BasicParser parser = new LexemeParser();
        List<TextComponent> children = parser.parseData(sentence.toString());
        longestLexeme = children.get(0);
        for (TextComponent lexeme : children) {
            if (longestLexeme.toString().length() < lexeme.toString().length()) {
                longestLexeme = lexeme;
            }
        }
        return longestLexeme;
    }
}
