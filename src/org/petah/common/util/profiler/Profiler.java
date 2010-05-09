/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util.profiler;

import java.util.HashMap;

/**
 *
 * @author Petah
 */
public class Profiler {

    private static boolean active = true;
    private static ProfileHandler profileHandler = new DefaultProfileHandler();
    private static HashMap<String, Profile> profiles = new HashMap<String, Profile>();

    public static void main(String[] args) {
//        SimpleDateFormat formatter = new SimpleDateFormat("H:mm:ss");
//        System.out.println(formatter.format(new Date(System.currentTimeMillis())));
        start(Profiler.class, "Test Main");
//        try {
//            Thread.sleep(100,500);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Profiler.class.getName()).log(Level.SEVERE, null, ex);
//        }
        stop(Profiler.class, "Test Main");
    }

    public static void start(Class profileClass, String name) {
        start(profileClass, name, null);
    }

    public static void start(Class profileClass, String name, String description) {
        if (active) {
            Profile profile = new Profile(profileClass, name, description, Thread.currentThread());
            profiles.put(profileClass.getName() + ":" + name, profile);
            profile.start();
        }
    }

    public static void stop(Class profileClass, String name) {
        if (active) {
            Profile profile = profiles.remove(profileClass.getName() + ":" + name);
            if (profile != null) {
                profile.stop();
                profileHandler.publish(profile);
            }
        }
    }

    public static void setActive(boolean active) {
        Profiler.active = active;
    }

    public static void setProfileHandler(ProfileHandler profileHandler) {
        Profiler.profileHandler = profileHandler;
    }
}
