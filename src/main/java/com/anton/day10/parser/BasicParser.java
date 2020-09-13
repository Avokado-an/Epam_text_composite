package com.anton.day10.parser;

import com.anton.day10.composite.TextComponent;

import java.util.List;

public interface BasicParser {
    List<TextComponent> parseData(String text) throws main.java.com.anton.day10.exception.ProgramException;
}
