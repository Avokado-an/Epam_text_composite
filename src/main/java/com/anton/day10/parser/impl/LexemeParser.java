package com.anton.day10.parser.impl;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.impl.SymbolComponent;
import com.anton.day10.composite.impl.TextComposite;
import com.anton.day10.composite.type.CharacterType;
import com.anton.day10.composite.type.ComponentType;
import com.anton.day10.interpreter.MathExpressionInterpreter;
import com.anton.day10.parser.BasicParser;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class LexemeParser implements BasicParser {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String LEXEME_REGEX = "[\\n]|[\\t]|[ ]";
    private static final String MATH_EXPRESSION_REGEX = "[\\d+\\-*/()]{3,}";
    private static final String SINGLE_CHARACTER_REGEX = "";
    private static final String SPACE = " ";

    @Override
    public List<TextComponent> parseData(String text) {
        List<TextComponent> componentLexemes = new ArrayList<>();
        String[] lexemes = text.split(LEXEME_REGEX);
        for (String lexeme : lexemes) {
            if (lexeme.matches(MATH_EXPRESSION_REGEX)) {
                componentLexemes.add(operateMathExpression(lexeme));
            } else {
                componentLexemes.add(operateWord(lexeme));
            }
            componentLexemes.add(new SymbolComponent(SPACE, CharacterType.SYMBOL));
        }
        return componentLexemes;
    }

    private TextComponent operateMathExpression(String lexeme) {
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
        } catch (ScriptException e) {
            LOGGER.log(Level.DEBUG, "Error in math expression!");
            componentExpression = operateWord(lexeme);
        }
        return componentExpression;
    }

    private TextComponent operateWord(String element) {
        TextComponent wordComponent = new TextComposite(ComponentType.WORD);
        BasicParser nextParser = new CharacterParser();
        List<TextComponent> componentSymbols = nextParser.parseData(element);
        for (TextComponent componentSymbol : componentSymbols) {
            wordComponent.add(componentSymbol);
        }
        return wordComponent;
    }
}
