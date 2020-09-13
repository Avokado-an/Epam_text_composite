package com.anton.day10.parser;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.parser.impl.ParagraphParser;
import main.java.com.anton.day10.exception.ProgramException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParagraphParserTest {
    BasicParser parser;

    @BeforeClass
    public void setUp() {
        parser = new ParagraphParser();
    }

    @DataProvider(name = "textToParse")
    public Object[][] provideTextToParse() {
        return new Object[][]{{
                "Asd\tZxcv\tzxc"
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
        List<String> expectedResult = Arrays.asList("    ", "Asd \n", "    ", "Zxcv \n", "    ", "zxc \n");
        Assert.assertEquals(actualResult, expectedResult);
    }
}
