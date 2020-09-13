package com.anton.day10.parser;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.parser.impl.LexemeParser;
import main.java.com.anton.day10.exception.ProgramException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexemeParserTest {
    BasicParser parser;

    @BeforeClass
    public void setUp() {
        parser = new LexemeParser();
    }

    @DataProvider(name = "textToParse")
    public Object[][] provideTextToParse() {
        return new Object[][]{{
                "asd, asdf. Asdf."
        }
        };
    }

    @Test(dataProvider = "textToParse")
    public void parseTextValidTest(String text) throws ProgramException {
        List<TextComponent> components = parser.parseData(text);
        List<String> actualResult = new ArrayList<>();
        for(TextComponent component : components) {
            actualResult.add(component.toString());
        }
        List<String> expectedResult = Arrays.asList("asd,", "asdf.", "Asdf.");
        Assert.assertEquals(actualResult, expectedResult);
    }
}
