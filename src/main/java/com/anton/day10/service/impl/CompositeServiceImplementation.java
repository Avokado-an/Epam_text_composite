package com.anton.day10.service.impl;

import com.anton.day10.comparator.AmountOfSentencesParagraphComparator;
import com.anton.day10.comparator.FrequencyOfCharacterAndAlphabetComparator;
import com.anton.day10.comparator.LexemeLengthSentenceComparator;
import com.anton.day10.comparator.WordLengthSentenceComparator;
import com.anton.day10.composite.TextComponent;
import com.anton.day10.parser.BasicParser;
import com.anton.day10.parser.impl.LexemeParser;
import com.anton.day10.parser.impl.ParagraphParser;
import com.anton.day10.parser.impl.SentenceParser;
import com.anton.day10.service.CompositeService;

import java.util.List;

public class CompositeServiceImplementation implements CompositeService {
    @Override
    public List<TextComponent> sortSentencesByMaxLexemeLength(String text) {
        BasicParser parser = new SentenceParser();
        List<TextComponent> sortedSentences = parser.parseData(text);
        sortedSentences.sort(new LexemeLengthSentenceComparator());
        return sortedSentences;
    }

    @Override
    public List<TextComponent> sortSentencesByMaxWordLength(String text) {
        BasicParser parser = new SentenceParser();
        List<TextComponent> sortedSentences = parser.parseData(text);
        sortedSentences.sort(new WordLengthSentenceComparator());
        return sortedSentences;
    }

    @Override
    public List<TextComponent> sortParagraphsBySentencesAmount(String text) {
        BasicParser parser = new ParagraphParser();
        List<TextComponent> sortedParagraphs = parser.parseData(text);
        sortedParagraphs.sort(new AmountOfSentencesParagraphComparator());
        return sortedParagraphs;
    }

    @Override
    public List<TextComponent> sortLexemesByFrequencyOfLetterAndAlphabet(String text) {
        BasicParser parser = new LexemeParser();
        List<TextComponent> sortedLexemes = parser.parseData(text);
        sortedLexemes.sort(new FrequencyOfCharacterAndAlphabetComparator());
        return sortedLexemes;
    }
}
