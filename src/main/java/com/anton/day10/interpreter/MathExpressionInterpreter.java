package com.anton.day10.interpreter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MathExpressionInterpreter {
    private static MathExpressionInterpreter instance = new MathExpressionInterpreter();

    public static MathExpressionInterpreter getInstance() {
        return instance;
    }

    private MathExpressionInterpreter() {}

    public String interpretExpression(String text) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return engine.eval(text).toString();
    }
}
