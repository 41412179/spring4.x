package com.smart.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptSimple {
    public static void main(String... args) throws ScriptException, NoSuchMethodException {
        //创建一个脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        //通过管理器创建引擎
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String scripText = "function sum(a,b) {return a + b;}";
        //注册函数脚本
        engine.eval(scripText);
        Invocable invocable = (Invocable) engine;
        //调用注册函数
        Object result = invocable.invokeFunction("sum", 100, 99);
        System.out.println(result);
    }
}
