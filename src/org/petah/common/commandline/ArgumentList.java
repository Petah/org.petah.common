/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.commandline;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

/**
 *
 * @author Petah
 */
public class ArgumentList extends Vector<Argument> {

    public int argumentAmount(String command) {
        int i = 0;
        if (command == null) {
            for (Argument a : this) {
                if (a.getCommand() == null) {
                    i++;
                }
            }
        } else {
            for (Argument a : this) {
                if (a.getCommand() != null && a.getCommand().equals(command)) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean hasArgument(String command) {
        if (command == null) {
            for (Argument a : this) {
                if (a.getCommand() == null) {
                    return true;
                }
            }
        } else {
            for (Argument a : this) {
                if (a.getCommand() != null && a.getCommand().equals(command)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasValue(String command) {
        for (Argument a : this) {
            if (a.getCommand() != null && a.getCommand().equals(command)) {
                if (a.getValue() != null && a.getValue().length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArgumentList getAllArguments(String command) {
        ArgumentList l = new ArgumentList();
        if (command == null) {
            for (Argument a : this) {
                if (a.getCommand() == null) {
                    l.add(a);
                }
            }
        } else {
            for (Argument a : this) {
                if (a.getCommand() != null && a.getCommand().equals(command)) {
                    l.add(a);
                }
            }
        }
        return l;
    }

    public Argument getArgument(String command) {
        if (command == null) {
            for (Argument a : this) {
                if (a.getCommand() == null) {
                    return a;
                }
            }
        } else {
            for (Argument a : this) {
                if (a.getCommand() != null && a.getCommand().equals(command)) {
                    return a;
                }
            }
        }
        return null;
    }


    public String getValue(String command) {
        if (command == null) {
            for (Argument a : this) {
                if (a.getCommand() == null) {
                    return a.getValue();
                }
            }
        } else {
            for (Argument a : this) {
                if (a.getCommand() != null && a.getCommand().equals(command)) {
                    return a.getValue();
                }
            }
        }
        return null;
    }
}
