package com.anton.day10.parser.impl;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.impl.SymbolComponent;
import com.anton.day10.composite.impl.TextComposite;
import com.anton.day10.composite.type.CharacterType;
import com.anton.day10.composite.type.ComponentType;
import com.anton.day10.interpreter.MathExpressionInterpreter;
import com.anton.day10.parser.BasicParser;
import main.java.com.anton.day10.exception.ProgramException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class LexemeParser implements BasicParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String LEXEME_REGEX = "[\\n]|[\\t]|[ ]";
    private static final String MATH_EXPRESSION_REGEX = "[\\d+\\-*/()]{3,}";
    private static final String SINGLE_CHARACTER_REGEX = "";

    @Override
    public List<TextComponent> parseData(String text) throws ProgramException {
        if (text == null) {
            throw new ProgramException();
        }
        List<TextComponent> componentLexemes = new ArrayList<>();
        String[] lexemes = text.split(LEXEME_REGEX);
        for (String lexeme : lexemes) {
            if (lexeme.matches(MATH_EXPRESSION_REGEX)) {
                componentLexemes.add(operateMathExpression(lexeme));
            } else {
                componentLexemes.add(operateWord(lexeme));
            }
        }
        return componentLexemes;
    }

    private TextComponent operateMathExpression(String lexeme) throws ProgramException {
        TextComponent componentExpression;
        try {
            MathExpressionInterpreter interpreter = MathExpressionInterpreter.getInstance();
            componentExpression = new TextComposite(ComponentType.WORD);
            String expressionResult = interpreter.interpretExpression(lexeme);
            String[] characters = expressionResult.split(SINGLE_CHARACTER_REGEX);
            for (String numberSymbol : characters) {
                SymbolComponent numberComponent = new SymbolComponent(numberSymbol, CharacterType.SYMBOL);
                componentExpression.add(numberComponent);
            }
        } catch (ProgramException e) {
            LOGGER.log(Level.DEBUG, "Error in math expression!");
            componentExpression = operateWord(lexeme);
        }
        return componentExpression;
    }

    private TextComponent operateWord(String element) throws ProgramException {
        TextComponent wordComponent = new TextComposite(ComponentType.WORD);
        BasicParser nextParser = new CharacterParser();
        List<TextComponent> componentSymbols = nextParser.parseData(element);
        for (TextComponent componentSymbol : componentSymbols) {
            wordComponent.add(componentSymbol);
        }
        return wordComponent;
    }
}
