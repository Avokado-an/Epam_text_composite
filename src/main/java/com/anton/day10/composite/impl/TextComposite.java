package com.anton.day10.composite.impl;

import com.anton.day10.composite.TextComponent;
import com.anton.day10.composite.type.ComponentType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TextComposite implements TextComponent {
    private List<TextComponent> components;
    private ComponentType type;

    public TextComposite(ComponentType type) {
        components = new ArrayList<>();
        this.type = type;
    }

    public void setComponents(List<TextComponent> components) {
        if(components != null) {
            this.components = components;
        }
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    public int getComponentsSize() {
        return components.size();
    }

    @Override
    public Optional<TextComponent> getChild(int id) {
        Optional<TextComponent> searchedChild;
        if(id > 0 && id < getComponentsSize()) {
            searchedChild = Optional.of(components.get(id));
        } else {
            searchedChild = Optional.empty();
        }
        return searchedChild;
    }

    @Override
    public List<TextComponent> getChildren() {
        return Collections.unmodifiableList(components);
    }

    @Override
    public boolean add(TextComponent component) {
        boolean flag = false;
        if(component != null) {
            flag = components.add(component);
        }
        return flag;
    }

    @Override
    public void addChild(TextComponent component) {
        if(component != null) {
            components.add(component);
        }
    }

    @Override
    public void removeChild(TextComponent component) {
        if(component != null) {
            components.remove(component);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(TextComponent component : components) {
            res.append(component.toString());
        }
        return res.toString();
    }
}
