package com.anton.day10.parser.impl;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.impl.SymbolComponent;
import com.anton.day10.composite.impl.TextComposite;
import com.anton.day10.composite.type.CharacterType;
import com.anton.day10.composite.type.ComponentType;
import com.anton.day10.parser.BasicParser;

import java.util.ArrayList;
import java.util.List;

public class ParagraphParser implements BasicParser {
    private static final String PARAGRAPH_REGEX = "[\\t]";
    private static final BasicParser nextParser = new SentenceParser();

    @Override // TODO: 05.09.2020 Do something to make it better(especially naming)
    public List<TextComponent> parseData(String text) {
        List<TextComponent> componentParagraphs = new ArrayList<>();
        String[] paragraphs = text.split(PARAGRAPH_REGEX);
        for(String paragraph : paragraphs) {
            TextComponent componentParagraph = new TextComposite(ComponentType.PARAGRAPH);
            List<TextComponent> componentSentences = nextParser.parseData(paragraph);
            for(TextComponent componentSentence : componentSentences) {
                componentParagraph.add(componentSentence);
            }
            componentParagraphs.add(componentParagraph);
        }
        return componentParagraphs;
    }
}
