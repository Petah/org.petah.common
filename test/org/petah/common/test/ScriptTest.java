/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.test;

import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;

/**
 *
 * @author Petah
 */
public class ScriptTest {

    // Create a script engine manager
    private static ScriptEngineManager factory = new ScriptEngineManager();
    // Create a JavaScript engine
    private static ScriptEngine engine = factory.getEngineByName("JavaScript");

    public static void main(String[] args) throws Exception {
        multiScopes();
        runnableImplObject();
        runnableImpl();
        invokeScriptMethod();
        invokeScriptFunction();
        scriptVars();
        evalScript();
        evalFile(new File("build/test/classes/org/petah/common/test/javascript/RunRunnable.js"));
        evalFile(new File("build/test/classes/org/petah/common/test/javascript/Import.js"));
        evalURI("org/petah/common/test/javascript/EvalFileTest.js");
    }


    public static void evalScript() throws Exception {
        // evaluate JavaScript code from String
        engine.eval("println('Hello, World')");
    }

    public static void evalURI(String uri) throws Exception {
        // evaluate JavaScript code from given URI
        engine.eval(new InputStreamReader(ScriptTest.class.getClassLoader().getResourceAsStream(uri)));
    }

    public static void evalFile(File file) throws Exception {
        // evaluate JavaScript code from given file 
        engine.eval(new FileReader(file));
    }

    public static void scriptVars() throws Exception {
        File f = new File("test.txt");
        // expose File object as variable to script
        engine.put("file", f);

        // evaluate a script string. The script accesses "file"
        // variable and calls method on it
        engine.eval("println(file.getAbsolutePath())");
    }

    public static void invokeScriptFunction() throws Exception {
        // JavaScript code in a String
        String script = "function hello(name) { println('Hello, ' + name); }";
        // evaluate script
        engine.eval(script);

        // javax.script.Invocable is an optional interface.
        // Check whether your script engine implements or not!
        // Note that the JavaScript engine implements Invocable interface.
        Invocable inv = (Invocable) engine;

        // invoke the global function named "hello"
        inv.invokeFunction("hello", "Scripting!!");
    }

    public static void invokeScriptMethod() throws Exception {
        // JavaScript code in a String. This code defines a script object 'obj'
        // with one method called 'hello'.
        String script = "var obj = new Object(); obj.hello = function(name) { println('Hello, ' + name); }";
        // evaluate script
        engine.eval(script);

        // javax.script.Invocable is an optional interface.
        // Check whether your script engine implements or not!
        // Note that the JavaScript engine implements Invocable interface.
        Invocable inv = (Invocable) engine;

        // get script object on which we want to call the method
        Object obj = engine.get("obj");

        // invoke the method named "hello" on the script object "obj"
        inv.invokeMethod(obj, "hello", "Script Method !!");
    }

    public static void runnableImpl() throws Exception {
        // JavaScript code in a String
        String script = "function run() { println('run called'); }";

        // evaluate script
        engine.eval(script);

        Invocable inv = (Invocable) engine;

        // get Runnable interface object from engine. This interface methods
        // are implemented by script functions with the matching name.
        Runnable r = inv.getInterface(Runnable.class);

        // start a new thread that runs the script implemented
        // runnable interface
        Thread th = new Thread(r);
        th.start();
    }

    public static void runnableImplObject() throws Exception {
        // JavaScript code in a String
        String script = "var obj = new Object(); obj.run = function() { println('run method called'); }";

        // evaluate script
        engine.eval(script);

        // get script object on which we want to implement the interface with
        Object obj = engine.get("obj");

        Invocable inv = (Invocable) engine;

        // get Runnable interface object from engine. This interface methods
        // are implemented by script methods of object 'obj'
        Runnable r = inv.getInterface(obj, Runnable.class);

        // start a new thread that runs the script implemented
        // runnable interface
        Thread th = new Thread(r);
        th.start();
    }
    public static void multiScopes() throws Exception {
        engine.put("x", "hello");
        // print global variable "x"
        engine.eval("println(x);");
        // the above line prints "hello"

        // Now, pass a different script context
        ScriptContext newContext = new SimpleScriptContext();
        Bindings engineScope = newContext.getBindings(ScriptContext.ENGINE_SCOPE);

        // add new variable "x" to the new engineScope
        engineScope.put("x", "world");

        // execute the same script - but this time pass a different script context
        engine.eval("println(x);", newContext);
        // the above line prints "world"
    }

}
