package com.anton.day10.parser;

import com.anton.day10.composite.TextComponent;

import java.util.List;

public interface BasicParser {
    public abstract List<TextComponent> parseData(String text);
}
