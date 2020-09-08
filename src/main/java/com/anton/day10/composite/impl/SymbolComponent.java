package com.anton.day10.composite.impl;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.type.CharacterType;
import com.anton.day10.composite.type.ComponentType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SymbolComponent implements TextComponent {
    private static final Logger LOGGER = LogManager.getLogger();
    private String symbol;
    private ComponentType componentType = ComponentType.SYMBOL;
    private CharacterType characterType;

    public SymbolComponent(String symbol, CharacterType characterType) {
        this.symbol = symbol;
        this.characterType = characterType;
    }

    public String getSymbol() {
        return symbol;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    @Override
    public void addChild(TextComponent component) {
        LOGGER.log(Level.WARN, "Adding is not supported operation");
    }

    @Override
    public void removeChild(TextComponent component) {
        LOGGER.log(Level.WARN, "Removal is not supported operation");
    }

    @Override
    public boolean add(TextComponent component) {
        LOGGER.log(Level.WARN, "Removal is not supported operation");
        return false;
    }

    @Override
    public List<TextComponent> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public Optional<TextComponent> getChild(int id) {
        return Optional.empty();
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
