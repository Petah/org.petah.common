/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.event;

import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Petah
 */
public abstract class UpdateAdapter {

    private final List<UpdateListener> updateListeners = new Vector<UpdateListener>();

    public void fireUpdate(Object source) {
        synchronized (updateListeners) {
            //Update listeners
            for (UpdateListener updateListener : updateListeners) {
                updateListener.update(source);
            }
        }
    }

    public void addUpdateListener(UpdateListener updateListener) {
        synchronized (updateListeners) {
            updateListeners.add(updateListener);
        }
    }

    public void removeUpdateListener(UpdateListener updateListener) {
        synchronized (updateListeners) {
            updateListeners.remove(updateListener);
        }
    }
}
