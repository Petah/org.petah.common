/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.event;

/**
 *
 * @author Petah
 */
public class Action {

    private int id;
    private String command;

    public Action(int id, String command) {
        this.id = id;
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
}
