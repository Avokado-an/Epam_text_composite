package com.anton.day10.parser;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.exception.ProgramException;

import java.util.List;

public interface BasicParser {
    List<TextComponent> parseData(String text) throws ProgramException;
}
