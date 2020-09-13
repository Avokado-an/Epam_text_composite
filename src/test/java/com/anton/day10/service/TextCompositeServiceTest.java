package com.anton.day10.service;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.exception.ProgramException;
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
    public void sortParagraphsBySentencesAmountValidTest(String text) throws ProgramException {
        List<TextComponent> sortedParagraphs = service.sortParagraphsBySentencesAmount(text);
        for (TextComponent component : sortedParagraphs) {
            System.out.println(component.toString());
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
    public void sortSentencesByByMaxLexemeLengthValidTest(String text) throws ProgramException {
        List<TextComponent> sortedSentences = service.sortSentencesByMaxLexemeLength(text);
        for (TextComponent component : sortedSentences) {
            System.out.println(component.toString());
        }
    }

    @Test(dataProvider = "textForMaxLexeme")
    public void sortSentencesByByMaxWordLengthValidTest(String text) throws ProgramException {
        List<TextComponent> sortedSentences = service.sortSentencesByMaxWordLength(text);
        for (TextComponent component : sortedSentences) {
            System.out.println(component.toString());
        }
    }

    @DataProvider(name = "textForMaxSymbolEntries")
    public Object[][] provideLexemesWithSymbol() {
        return new Object[][]{{
                "abc aac bbaaac aab cccccc bbbbb"
        }
        };
    }

    @Test(dataProvider = "textForMaxSymbolEntries")
    public void sortLexemesByFrequencyOfSymbolAndAlphabetValidTest(String text) throws ProgramException {
        char symbolToFind = 'a';
        List<TextComponent> sortedLexemes = service.sortLexemesByFrequencyOfSymbolAndAlphabet(symbolToFind, text);
        for (TextComponent component : sortedLexemes) {
            System.out.println(component.toString());
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void sortParagraphsBySentencesAmountExceptionTest() throws ProgramException {
        service.sortParagraphsBySentencesAmount(null);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void sortSentencesByByMaxLexemeLengthExceptionTest() throws ProgramException {
        service.sortSentencesByMaxLexemeLength(null);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void sortSentencesByByMaxWordLengthExceptionTest() throws ProgramException {
        service.sortSentencesByMaxWordLength(null);
    }

    @Test(expectedExceptions = ProgramException.class)
    public void sortLexemesByFrequencyOfSymbolAndAlphabetExceptionTest() throws ProgramException {
        service.sortLexemesByFrequencyOfSymbolAndAlphabet('a', null);
    }
}
