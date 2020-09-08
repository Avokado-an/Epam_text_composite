package com.anton.day10.parser.impl;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.impl.TextComposite;
import com.anton.day10.composite.type.ComponentType;
import com.anton.day10.parser.BasicParser;

import java.util.ArrayList;
import java.util.List;

public class SentenceParser implements BasicParser {
    private static final String SENTENCE_REGEX = "[.]{3}|[.!?]";
    private static final String REGEX_FOR_SPLITTING_WITH_DELIMITER = "(?<=%s)";
    private static final BasicParser nextParser = new LexemeParser();

    @Override
    public List<TextComponent> parseData(String text) {
        List<TextComponent> componentSentences = new ArrayList<>();
        String[] sentences = text.split(String.format(REGEX_FOR_SPLITTING_WITH_DELIMITER, SENTENCE_REGEX));
        for (String sentence : sentences) {
            TextComponent componentSentence = new TextComposite(ComponentType.SENTENCE);
            List<TextComponent> componentLexemes = nextParser.parseData(sentence);
            for (TextComponent componentLexeme : componentLexemes) {
                componentSentence.add(componentLexeme);
            }
            componentSentences.add(componentSentence);
        }
        return componentSentences;
    }
}
