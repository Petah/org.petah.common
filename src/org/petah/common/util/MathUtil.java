/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util;

/**
 *
 * @author Petah
 */
public class MathUtil {

    /**
     * Rounds a float to a specified number of decimal places.
     * @param value the float value to round
     * @param decimalPlaces the amonut of decimal places
     * @return the rounded value
     */
    public static float round(float value, int decimalPlaces) {
        float power = (float) Math.pow(10, decimalPlaces);
        value = value * power;
        float tmp = Math.round(value);
        return (float) tmp / power;
    }

    /**
     * Rounds a double to a specified number of decimal places.
     * @param value the double value to round
     * @param decimalPlaces the amonut of decimal places
     * @return the rounded value
     */
    public static double round(double value, int decimalPlaces) {
        double power = Math.pow(10, decimalPlaces);
        value = value * power;
        double tmp = Math.round(value);
        return tmp / power;
    }

    public static boolean between(double current, double limit1, double limit2) {
        if (limit1 > limit2) {
            if ((current < limit1) && (current > limit2)) {
                return true;
            }
        }
        if (limit1 < limit2) {
            if ((current > limit1) && (current < limit2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean between(float current, float limit1, float limit2) {
        if (limit1 > limit2) {
            if ((current < limit1) && (current > limit2)) {
                return true;
            }
        }
        if (limit1 < limit2) {
            if ((current > limit1) && (current < limit2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean between(int current, int limit1, int limit2) {
        if (limit1 > limit2) {
            if ((current < limit1) && (current > limit2)) {
                return true;
            }
        }
        if (limit1 < limit2) {
            if ((current > limit1) && (current < limit2)) {
                return true;
            }
        }
        return false;
    }
}
