package com.anton.day10.service;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.exception.ProgramException;

import java.util.List;

public interface CompositeService {
    List<TextComponent> sortSentencesByMaxLexemeLength(String text) throws ProgramException;

    List<TextComponent> sortSentencesByMaxWordLength(String text) throws ProgramException;

    List<TextComponent> sortParagraphsBySentencesAmount(String text) throws ProgramException;

    List<TextComponent> sortLexemesByFrequencyOfSymbolAndAlphabet(char symbol, String text) throws ProgramException;
}
