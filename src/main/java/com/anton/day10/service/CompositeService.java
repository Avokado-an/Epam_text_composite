package com.anton.day10.service;

import com.anton.day10.composite.TextComponent;

import java.util.List;

public interface CompositeService {
    List<TextComponent> sortSentencesByMaxLexemeLength(String text);
    List<TextComponent> sortSentencesByMaxWordLength(String text);
    List<TextComponent> sortParagraphsBySentencesAmount(String text);
    List<TextComponent> sortLexemesByFrequencyOfSymbolAndAlphabet(char symbol, String text);
}
