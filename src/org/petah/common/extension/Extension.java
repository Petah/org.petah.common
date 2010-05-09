package org.petah.common.extension;

import java.io.File;
import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author David Neilsen
 */
public class Extension implements Iterable<Object> {

    private File file;
    private Vector<Object> objects = new Vector<Object>();

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean addObject(Object o) {
        return objects.add(o);
    }

    public Object getObject(int index) {
        return objects.get(index);
    }

    public Vector<Object> getObjects() {
        return objects;
    }

    public Object removeObject(int index) {
        return objects.remove(index);
    }

    public boolean removeObject(Object o) {
        return objects.remove(o);
    }

    @Override
    public String toString() {
        String s = "";
        for (Object o : objects) {
            s += s.length() != 0 ? "," : "" + o;
        }
        return "Extension[" + file.getName() + ":" + s + "]";
    }

    public Iterator<Object> iterator() {
        return objects.iterator();
    }
}
