package com.anton.day10.service.impl;

import com.anton.day10.comparator.*;
import com.anton.day10.composite.TextComponent;
import com.anton.day10.parser.BasicParser;
import com.anton.day10.parser.impl.LexemeParser;
import com.anton.day10.parser.impl.ParagraphParser;
import com.anton.day10.parser.impl.SentenceParser;
import com.anton.day10.service.CompositeService;
import com.anton.day10.exception.ProgramException;

import java.util.List;

public class CompositeServiceImplementation implements CompositeService {
    @Override
    public List<TextComponent> sortSentencesByMaxLexemeLength(String text) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Null values");
        }
        BasicParser parser = new SentenceParser();
        List<TextComponent> sortedSentences = parser.parseData(text);
        sortedSentences.sort(new LexemeLengthSentenceComparator());
        return sortedSentences;
    }

    @Override
    public List<TextComponent> sortSentencesByMaxWordLength(String text) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Null values");
        }
        BasicParser parser = new SentenceParser();
        List<TextComponent> sortedSentences = parser.parseData(text);
        sortedSentences.sort(new WordLengthSentenceComparator());
        return sortedSentences;
    }

    @Override
    public List<TextComponent> sortParagraphsBySentencesAmount(String text) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Null values");
        }
        BasicParser parser = new ParagraphParser();
        List<TextComponent> sortedParagraphs = parser.parseData(text);
        sortedParagraphs.sort(new AmountOfSentencesParagraphComparator());
        return sortedParagraphs;
    }

    @Override
    public List<TextComponent> sortLexemesByFrequencyOfSymbolAndAlphabet(char symbol, String text) throws ProgramException {
        if(text == null) {
            throw new ProgramException("Null values");
        }
        BasicParser parser = new LexemeParser();
        List<TextComponent> sortedLexemes = parser.parseData(text);
        sortedLexemes.sort(new FrequencyOfCharacterAndAlphabetComparator(symbol).
                thenComparing(new AlphabeticalOrderComparator()));
        return sortedLexemes;
    }
}
