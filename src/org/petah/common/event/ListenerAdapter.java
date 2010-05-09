package org.petah.common.event;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author David
 */
public class ListenerAdapter<T> {

    protected final List<T> listeners = new LinkedList<T>();

    public void addListener(T listener) {
        listeners.add(listener);
    }

    public void removeListener(T listener) {
        listeners.remove(listener);
    }
}
