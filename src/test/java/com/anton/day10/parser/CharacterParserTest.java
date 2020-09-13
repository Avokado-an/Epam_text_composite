package com.anton.day10.parser;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.parser.impl.CharacterParser;
import com.anton.day10.exception.ProgramException;
import org.testng.Assert;
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
                "It has survived - not only (five) centuries, but also the leap into " +
                        "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was " +
                        "popularised in the 5*(1*2*(3*(4*(5+4)-3)-2)-1) with the release of Letraset sheets " +
                        "containing Lorem Ipsum passages, and more recently with desktop publishing software " +
                        "like Aldus PageMaker including versions of Lorem Ipsum. " +
                        "It is a long established fact that a reader will be distracted by the readable " +
                        "content of a page when looking at its layout." +
                        "\tThe point of using (71-(2*(3*(2-1/2*2)-2)-10/2)) " +
                        "Ipsum is that it has a more-or-less normal distribution of letters, as " +
                        "opposed to using (Content here), content here', making it look like readable English. " +
                        "It is a (-5+1/2*(2+5*2))*1200 established fact that a reader will be of a page " +
                        "when looking at its layout." +
                        "\tBye."
        }
        };
    }

    @Test(dataProvider = "textToParse")
    public void parseTextValidTest(String text) throws ProgramException {
        List<TextComponent> components = parser.parseData(text);
        StringBuilder expectedResult = new StringBuilder();
        for(TextComponent component : components) {
            expectedResult.append(component.toString());
        }
        Assert.assertEquals(expectedResult.toString(), text);
    }
}
