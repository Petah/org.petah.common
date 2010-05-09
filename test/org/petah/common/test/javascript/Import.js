/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


// Import Java packages and classes
// like import package.*; in Java
//importPackage(java.awt);
// like import java.awt.Frame in Java
importClass(javax.swing.JFrame);
// Create Java Objects by "new ClassName"
var frame = new JFrame("frame title");
// Call Java public methods from script
frame.setVisible(true);
frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);


// importPackage and importClass functions "pollute" the global variable scope of JavaScript.
// To avoid that, you may use JavaImporter.
// create JavaImporter with specific packages and classes to import

//var SwingGui = new JavaImporter(javax.swing,
//                            javax.swing.event,
//                            javax.swing.border,
//                            java.awt.event);
//with (SwingGui) {
//    // within this 'with' statement, we can access Swing and AWT
//    // classes by unqualified (simple) names.
//
//    var mybutton = new JButton("test");
//    var myframe = new JFrame("test");
//}
//

