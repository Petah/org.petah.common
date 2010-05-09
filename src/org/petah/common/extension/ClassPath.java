/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.extension;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Petah
 */
public class ClassPath {

    private static final Class[] parameters = new Class[]{URL.class};

    public static void add(String file) {
        add(new File(file));
    }

    public static void add(File file) {
        try {
            addURL(file.toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClassPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addURL(URL u) {
        try {
            URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            Class sysclass = URLClassLoader.class;
            Method method = sysclass.getDeclaredMethod("addURL", parameters);
            method.setAccessible(true);
            method.invoke(sysloader, new Object[]{u});
        } catch (Exception ex) {
            Logger.getLogger(ClassPath.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
