/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.commandline;

/**
 *
 * @author Petah
 */
public class ArgumentParser {

    private static String argumentPrefix = "-";

    public static ArgumentList parse(String[] args) {
        ArgumentList list = new ArgumentList();

        Argument argument = null;
        for (String arg : args) {
            if (matchesPrefix(arg)) {
                if (argument != null) {
                    list.add(argument);
                }
                argument = new Argument(arg);
            } else {
                if (argument == null) {
                    argument = new Argument(null);
                }
                argument.setValue((argument.getValue() + " " + arg).trim());
            }
        }
        if (argument != null) {
            list.add(argument);
        }
        return list;
    }

    private static boolean matchesPrefix(String arg) {
        return arg.startsWith(argumentPrefix);
    }

    public static String getArgumentPrefix() {
        return argumentPrefix;
    }

    public static void setArgumentPrefix(String argumentPrefix) {
        ArgumentParser.argumentPrefix = argumentPrefix;
    }
}
