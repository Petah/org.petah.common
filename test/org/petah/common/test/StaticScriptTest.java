package org.petah.common.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class StaticScriptTest {

    public static void main(String[] args) throws Exception {
        new StaticScriptTest();
    }

    public StaticScriptTest() throws Exception {
        // Create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // Create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        // Works
        engine.put("instance", this);
        engine.eval("instance.someMethod();");

        // Works
        engine.put("SomeStaticClass", new SomeStaticClass());
        engine.eval("SomeStaticClass.someStaticMethod();");

//        // Doesnt work
//        engine.eval("SomeStaticClass.someStaticMethod();");
//
//        // Also doesnt work
//        engine.eval("org.petah.common.test.SomeStaticClass.someStaticMethod();");
//
//        // Also doesnt work
//        engine.eval("importPackage(org.petah.common.test);");
//        engine.eval("SomeStaticClass.someStaticMethod();");
//
//        engine.eval("importClass(org.petah.common.test.SomeStaticClass);");
//        engine.eval("someStaticMethod();");
    }

    public void someMethod() {
        System.out.println("called: StaticScriptTest.someMethod()");
    }
}
