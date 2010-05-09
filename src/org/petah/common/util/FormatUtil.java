/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util;

/**
 *
 * @author Petah
 */
public class FormatUtil {

    public static String addWhiteSpace(Object o, int amount) {
        String string = o == null ? "null" : o.toString();
        String whiteSpace = "";
        for (int i = string.length(); i < amount; i++) {
            whiteSpace += " ";
        }
        return string + whiteSpace;
    }

    /**
     * Converts a file size to a String with the relitive b, Kb, or Mb symbol and
     * rounds to 2 decimal places.
     * @param bytes the about of bytes
     * @return the String representation
     */
    public static String formatBytes(long bytes) {
        if (bytes < 500) {
            return bytes + "b";
        } else if (bytes < ((1024 * 1024) / 2)) {
            return MathUtil.round(bytes / 1024, 2) + "Kb";
        } else {
            return MathUtil.round((bytes / 1024 / 1024), 2) + "Mb";
        }
    }

    /**
     * Returns a formatted String denoting the amount of time that has past.
     * @param time time in milliseconds
     * @return a formatted String e.g. 2h 42m 12s 934ms
     */
    public static String formatTime(long time) {
        long hours = time / (1000 * 60 * 60);
        long minutes = (time % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = ((time % (1000 * 60 * 60)) % (1000 * 60)) / 1000;
        long milliseconds = (((time % (1000 * 60 * 60)) % (1000 * 60)) % 1000);
        String result = "";
        if (hours > 0) {
            result += hours + "h " + minutes;
        }
        if (minutes > 0) {
            result += minutes + "m ";
        }
        if (seconds > 0) {
            result += seconds + "s ";
        }
        result += milliseconds + "ms";
        return result;
    }

    public static String formatNanoTime(long time) {
        long nanosPerMillisecond = 1000000;
        long nanosPerSecond = nanosPerMillisecond * 1000;
        long nanosPerMinute = nanosPerSecond * 60;
        long nanosPerHour = nanosPerMinute * 60;
        long hours = time / nanosPerHour;
        long minutes = (time % nanosPerHour) / nanosPerMinute;
        long seconds = ((time % nanosPerHour) % nanosPerMinute) / nanosPerSecond;
        long milliseconds = (((time % nanosPerHour) % nanosPerMinute) % nanosPerSecond) / nanosPerMillisecond;
        long nanoseconds = (((time % nanosPerHour) % nanosPerMinute) % nanosPerSecond) % nanosPerMillisecond;
        String result = "";
        if (hours > 0) {
            result += hours + "h " + minutes;
        }
        if (minutes > 0) {
            result += minutes + "m ";
        }
        if (seconds > 0) {
            result += seconds + "s ";
        }
        if (milliseconds > 0) {
            result += milliseconds + "ms ";
        }
        result += nanoseconds + "ns";
        return result;
    }
}
