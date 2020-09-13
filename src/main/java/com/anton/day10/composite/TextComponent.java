package com.anton.day10.composite;

import java.util.List;
import java.util.Optional;

public interface TextComponent {
    void addChild(TextComponent component);

    void removeChild(TextComponent component);

    boolean add(TextComponent component);

    List<TextComponent> getChildren();

    Optional<TextComponent> getChild(int id);
}
