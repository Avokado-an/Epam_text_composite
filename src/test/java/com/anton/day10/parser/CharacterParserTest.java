package com.anton.day10.parser;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.parser.impl.CharacterParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class CharacterParserTest {
    BasicParser parser;

    @BeforeClass
    public void setUp() {
        parser = new CharacterParser();
    }

    @DataProvider(name = "textToParse")
    public Object[][] provideTextToParse() {
        return new Object[][]{{
                "It has survived - not only (five) centuries, but also the leap into\n" +
                        "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was\n" +
                        "popularised in the 5*(1*2*(3*(4*(5+4)-3)-2)-1) with the release of Letraset sheets\n" +
                        "containing Lorem Ipsum passages, and more recently with desktop publishing software\n" +
                        "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                        "It is a long established fact that a reader will be distracted by the readable\n" +
                        "content of a page when looking at its layout. The point of using (71-(2*(3*(2-1/2*2)-2)-10/2))\n" +
                        "Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
                        "opposed to using (Content here), content here', making it look like readable English.\n" +
                        "It is a (-5+1/2*(2+5*2))*1200 established fact that a reader will be of a page\n" +
                        "when looking at its layout.\n" +
                        "Bye."
        }
        };
    }

    @Test(dataProvider = "textToParse")
    public void parseTextValidTest(String text) {
        List<TextComponent> components = parser.parseData(text);
        System.out.println(components);
    }
}
