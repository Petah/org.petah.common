package org.petah.common.extension;

import java.util.Vector;
import org.petah.common.event.ListenerAdapter;

/**
 *
 * @author David Neilsen
 */
public class ExtensionManager extends ListenerAdapter<ExtensionListener> {

    private Vector<Extension> extensions = new Vector<Extension>();
    private Vector<Class> compatibleClasses = new Vector<Class>();

    public void addExtension(Extension e) {
        extensions.add(e);
        for (ExtensionListener listener : listeners) {
            listener.addExtension(e);
        }
    }

    public Extension getExtension(int index) {
        return extensions.get(index);
    }

    public Vector<Extension> getExtensions() {
        return extensions;
    }

    public void removeExtension(Extension e) {
        extensions.remove(e);
        for (ExtensionListener listener : listeners) {
            listener.removeExtension(e);
        }
    }

    public void removeAllExtensions() {
        while (extensions.size() > 0) {
            removeExtension(getExtension(0));
        }
    }

    public Vector<Class> getCompatibleClasses() {
        return compatibleClasses;
    }

    public void addCompatibleClass(Class c) {
        compatibleClasses.add(c);
    }

    public void removeCompatibleClass(Class c) {
        compatibleClasses.remove(c);
    }

    public boolean isClassCompatible(Class c) {
        if (compatibleClasses.contains(c)) {
            return true;
        }
        if (isInterfaceCompatible(c)) {
            return true;
        }
        while (c.getSuperclass() != null) {
            if (compatibleClasses.contains(c.getSuperclass())) {
                return true;
            }
            if (isInterfaceCompatible(c)) {
                return true;
            }
            c = c.getSuperclass();
        }
        return false;
    }

    private boolean isInterfaceCompatible(Class c) {
        for (Class i : c.getInterfaces()) {
            if (compatibleClasses.contains(i)) {
                return true;
            }
        }
        return false;
    }
}
