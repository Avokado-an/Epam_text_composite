package com.anton.day10.interpreter;

import com.anton.day10.exception.ProgramException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathExpressionInterpreter {
    private static MathExpressionInterpreter instance = new MathExpressionInterpreter();

    public static MathExpressionInterpreter getInstance() {
        return instance;
    }

    private MathExpressionInterpreter() {
    }

    public String interpretExpression(String text) throws ProgramException {
        if (text == null) {
            throw new ProgramException("Null String");
        }
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            return engine.eval(text).toString();
        } catch (ScriptException e) {
            throw new ProgramException("Can't process math expression script", e);
        }
    }
}
