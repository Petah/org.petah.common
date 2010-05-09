/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util.profiler;

import java.io.PrintStream;

/**
 *
 * @author Petah
 */
public class DefaultProfileHandler implements ProfileHandler {

    private static ProfileFormatter formatter = new DefaultProfileFormatter();
    private static long threshHold = 0;
    private static PrintStream printStream = System.out;

    public void publish(Profile profile) {
        if (profile.getRunTime() > threshHold) {
            printStream.println(formatter.format(profile));
        }
    }

    public static void setPrintStream(PrintStream printStream) {
        DefaultProfileHandler.printStream = printStream;
    }

    public static void setFormatter(ProfileFormatter formatter) {
        DefaultProfileHandler.formatter = formatter;
    }

    public static void setThreshHold(long threshHold) {
        DefaultProfileHandler.threshHold = threshHold;
    }
}
