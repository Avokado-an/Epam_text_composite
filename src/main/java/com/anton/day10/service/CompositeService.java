package com.anton.day10.service;

import com.anton.day10.composite.TextComponent;

import java.util.List;

public interface CompositeService {
    List<TextComponent> sortSentencesByMaxLexemeLength(String text) throws main.java.com.anton.day10.exception.ProgramException;

    List<TextComponent> sortSentencesByMaxWordLength(String text) throws main.java.com.anton.day10.exception.ProgramException;

    List<TextComponent> sortParagraphsBySentencesAmount(String text) throws main.java.com.anton.day10.exception.ProgramException;

    List<TextComponent> sortLexemesByFrequencyOfSymbolAndAlphabet(char symbol, String text) throws main.java.com.anton.day10.exception.ProgramException;
}
