/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


var v = new java.lang.Runnable() {
    run: function() {
        println('hello');
    }
}
v.run();



// A Java interface can be implemented in JavaScript by using a Java anonymous class-like syntax:
var r  = new java.lang.Runnable() {
    run: function() {
        println("running...\n");
    }
};

// "r" can be passed to Java methods that expect java.lang.Runnable
var th = new java.lang.Thread(r);
th.start();

// When an interface with a single method is expected, you can pass a script function directly.(auto conversion)


function func() {
     println("I am func!");
}

// pass script function for java.lang.Runnable argument
var th2 = new java.lang.Thread(func);
th2.start();

