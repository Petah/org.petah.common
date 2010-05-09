/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



println("This is hello from EvalFileTest.js");

// While creating a Java object is the same as in Java, to create Java arrays in
// JavaScript we need to use Java reflection explicitly. But once created the element
// access or length access is the same as in Java. Also, a script array can be used
// when a Java method expects a Java array (auto conversion). So in most cases we don't have to create Java arrays explicitly.
// create Java String array of 5 elements
var a = java.lang.reflect.Array.newInstance(java.lang.String, 5);

// Accessing elements and length access is by usual Java syntax
a[0] = "scripting is great!";
println(a.length);

// Overload Resolution
var out = java.lang.System.err;

// select a particular println function
out["println(java.lang.Object)"]("hello");
