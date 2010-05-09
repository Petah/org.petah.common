/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.commandline;

/**
 *
 * @author Petah
 */
public class Argument {

    String command;
    String value;

    public Argument(String command) {
        this.command = command;
        this.value = "";
    }

    public Argument(String command, String value) {
        this.command = command;
        this.value = value;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Argument[" + command + "," + value + "]";
    }
}
