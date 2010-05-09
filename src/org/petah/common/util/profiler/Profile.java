/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util.profiler;

import java.text.SimpleDateFormat;
import org.petah.common.util.FormatUtil;

/**
 *
 * @author Petah
 */
public class Profile {

    private Class profileClass;
    private String name;
    private String description;
    private Thread thread;
    private long startTime;
    private long endTime;

    public Profile(Class profileClass, String name, String description, Thread thread) {
        this.profileClass = profileClass;
        this.name = name;
        this.description = description;
        this.thread = thread;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getRunTime() {
        return endTime - startTime;
    }

    // Getters
    public Class getProfileClass() {
        return profileClass;
    }

    public Thread getThread() {
        return thread;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getStartTime() {
        return startTime;
    }
}
