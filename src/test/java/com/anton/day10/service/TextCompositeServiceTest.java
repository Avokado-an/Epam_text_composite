package com.anton.day10.service;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.service.impl.CompositeServiceImplementation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TextCompositeServiceTest {
    CompositeService service;

    @BeforeClass
    public void setup() {
        service = new CompositeServiceImplementation();
    }

    @DataProvider(name = "textToParse")
    public Object[][] provideTextToParse() {
        return new Object[][]{{
                "It has survived - not only (five) centuries, but also the leap into\n" +
                        "electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was\n" +
                        "popularised in the 5*(1*2*(3*(4*(5+4)-3)-2)-1) with the release of Letraset sheets\n" +
                        "containing Lorem Ipsum passages, and more recently with desktop publishing software\n" +
                        "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                        "\tIt is a long established fact that a reader will be distracted by the readable\n" +
                        "content of a page when looking at its layout. The point of using (71-(2*(3*(2-1/2*2)-2)-10/2))\n" +
                        " Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
                        "opposed to using (Content here), content here', making it look like readable English.\n" +
                        "\tIt is a (-5+1/2*(2+5*2))*1200 established fact that a reader will be of a page\n" +
                        "when looking at its layout.\n" +
                        "\tBye."
        }
        };
    }

    @Test(dataProvider = "textToParse")
    public void sortParagraphsBySentencesAmountValidTest(String text) {
        List<TextComponent> sortedParagraphs = service.sortParagraphsBySentencesAmount(text);
        for(TextComponent component : sortedParagraphs) {
            System.out.println(component);
        }
    }

    @DataProvider(name = "textForMaxLexeme")
    public Object[][] provideLexemes() {
        return new Object[][]{{
                "12. 11,,,,,,,,,,, 1 1. 123456, 13, 1. 12345 1234."
        }
        };
    }

    @Test(dataProvider = "textForMaxLexeme")
    public void sortSentencesByByMaxLexemeLengthValidTest(String text) {
        List<TextComponent> sortedSentences = service.sortSentencesByMaxLexemeLength(text);
        for(TextComponent component : sortedSentences) {
            System.out.println(component);
        }
    }

    @Test(dataProvider = "textForMaxLexeme")
    public void sortSentencesByByMaxWordLengthValidTest(String text) {
        List<TextComponent> sortedSentences = service.sortSentencesByMaxWordLength(text);
        for(TextComponent component : sortedSentences) {
            System.out.println(component); //todo do all it
        }
    }
}
