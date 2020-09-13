package com.anton.day10.comparator;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.impl.TextComposite;
import com.anton.day10.composite.type.ComponentType;
import com.anton.day10.parser.BasicParser;
import com.anton.day10.parser.impl.LexemeParser;
import main.java.com.anton.day10.exception.ProgramException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class WordLengthSentenceComparator implements Comparator<TextComponent> {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        TextComponent longestChild1 = findLongestLexeme(o1);
        TextComponent longestChild2 = findLongestLexeme(o2);
        int length1 = getLexemeLengthWithoutPunctuationSign(longestChild1);
        int length2 = getLexemeLengthWithoutPunctuationSign(longestChild2);
        return length1 - length2;
    }

    private TextComponent findLongestLexeme(TextComponent sentence) {
        BasicParser parser = new LexemeParser();
        TextComponent longestLexeme;
        try {
            List<TextComponent> children = parser.parseData(sentence.toString());
            int firstElementPosition = 0;
            longestLexeme = children.get(firstElementPosition);
            for (TextComponent lexeme : children) {
                if (longestLexeme.toString().length() < lexeme.toString().length()) {
                    longestLexeme = lexeme;
                }
            }
        } catch (ProgramException e) {
            LOGGER.log(Level.WARN, "can't find longest lexeme due to inability to parse lexemes");
            longestLexeme = new TextComposite(ComponentType.LEXEME);
        }
        return longestLexeme;
    }

    private int getLexemeLengthWithoutPunctuationSign(TextComponent component) {
        int realLength = component.toString().length() - 1;
        while (isSymbolPunctuationSign(component, realLength)) {
            realLength--;
        }
        return realLength;
    }

    private boolean isSymbolPunctuationSign(TextComponent textComponent, int currentPosition) {
        String punctuationSigns = ",:;!.?";
        char currentCharacter = textComponent.toString().charAt(currentPosition);
        return punctuationSigns.contains(String.valueOf(currentCharacter));
    }
}
