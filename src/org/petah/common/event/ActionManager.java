/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 *
 * @author Petah
 */
public class ActionManager {

    private Vector<ActionListener> actionListeners = new Vector<ActionListener>();

    public void fireActionEvent(ActionEvent e) {
        for (ActionListener a : actionListeners) {
            a.actionPerformed(e);
        }
    }

    public void removeAllActionListeners() {
        actionListeners.removeAllElements();
    }

    public boolean removeActionListener(ActionListener a) {
        return actionListeners.remove(a);
    }

    public boolean addActionListener(ActionListener a) {
        return actionListeners.add(a);
    }
}
