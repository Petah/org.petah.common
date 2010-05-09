/*
 * Classname
 *
 * Version information
 *
 * Date
 *
 * Copyright notice
 */
package org.petah.common.util;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Petah
 */
//TODO: seperate math from game math into MathUtil class
public class GameMath {

    public static boolean inrect(Point point, Rectangle rectangle) {
        if (point.x >= rectangle.x && point.x <= rectangle.x + rectangle.width) {
            if (point.y >= rectangle.y && point.y <= rectangle.y + rectangle.height) {
                return true;
            }
        }
        return false;
    }

    public static boolean inrect(double pointX, double pointY, double rectX, double rectY, double rectWidth, double rectHeight) {
        if (pointX >= rectX && pointX <= rectX + rectWidth) {
            if (pointY >= rectY && pointY <= rectY + rectHeight) {
                return true;
            }
        }
        return false;
    }

    public static boolean inrect(float pointX, float pointY, float rectX, float rectY, float rectWidth, float rectHeight) {
        if (pointX >= rectX && pointX <= rectX + rectWidth) {
            if (pointY >= rectY && pointY <= rectY + rectHeight) {
                return true;
            }
        }
        return false;
    }

    public static boolean inrect(int pointX, int pointY, int rectX, int rectY, int rectWidth, int rectHeight) {
        if (pointX >= rectX && pointX <= rectX + rectWidth) {
            if (pointY >= rectY && pointY <= rectY + rectHeight) {
                return true;
            }
        }
        return false;
    }

    public static double applyFriction(double speed, double friction) {
        if (speed > 0) {
            if (speed < friction) {
                speed = 0;
            } else {
                speed -= friction;
            }
        } else {
            if (speed > friction * -1) {
                speed = 0;
            } else {
                speed += friction;
            }
        }
        return speed;
    }

    public static float applyFriction(float speed, float friction) {
        if (speed > 0) {
            if (speed < friction) {
                speed = 0;
            } else {
                speed -= friction;
            }
        } else {
            if (speed > friction * -1) {
                speed = 0;
            } else {
                speed += friction;
            }
        }
        return speed;
    }

//    @Deprecated
//    public static double radToDeg(double rad) {
//        return Math.toDegrees(rad);//rad * (180 / (double)Math.PI);
//    }
//
//    @Deprecated
//    public static double degToRad(double deg) {
//        return Math.toRadians(deg);//deg * ((double)Math.PI / 180);
//    }
//
//    @Deprecated
//    public static float radToDeg(float rad) {
//        return (float) Math.toDegrees(rad);//rad * (180 / (double)Math.PI);
//    }
//
//    @Deprecated
//    public static float degToRad(float deg) {
//        return (float) Math.toRadians(deg);//deg * ((double)Math.PI / 180);
//    }
    public static double constrain(double current, double limit1, double limit2) {
        if (limit1 > limit2) {
            if (current > limit1) {
                return limit1;
            }
            if (current < limit2) {
                return limit2;
            }
            return current;
        }
        if (limit1 < limit2) {
            if (current < limit1) {
                return limit1;
            }
            if (current > limit2) {
                return limit2;
            }
            return current;
        }
        return limit1;
    }

    public static float constrain(float current, float limit1, float limit2) {
        if (limit1 > limit2) {
            if (current > limit1) {
                return limit1;
            }
            if (current < limit2) {
                return limit2;
            }
            return current;
        }
        if (limit1 < limit2) {
            if (current < limit1) {
                return limit1;
            }
            if (current > limit2) {
                return limit2;
            }
            return current;
        }
        return limit1;
    }

    public static int constrain(int current, int limit1, int limit2) {
        if (limit1 > limit2) {
            if (current > limit1) {
                return limit1;
            }
            if (current < limit2) {
                return limit2;
            }
            return current;
        }
        if (limit1 < limit2) {
            if (current < limit1) {
                return limit1;
            }
            if (current > limit2) {
                return limit2;
            }
            return current;
        }
        return limit1;
    }

    public static double wrapAboveZero(double current, double max) {
        while (current > max) {
            current -= max;
        }
        while (current < 0) {
            current += max;
        }
        return current;
    }

    public static float wrapAboveZero(float current, float max) {
        while (current > max) {
            current -= max;
        }
        while (current < 0) {
            current += max;
        }
        return current;
    }

    public static int wrapAboveZero(int current, int max) {
        while (current > max) {
            current -= max;
        }
        while (current < 0) {
            current += max;
        }
        return current;
    }

    public static double pointDirection(double x1, double y1, double x2, double y2) {
        double direction = Math.toDegrees((double) Math.atan2(y2 - y1, x2 - x1));
        if (direction > 360) {
            direction -= 360;
        }
        if (direction < 0) {
            direction += 360;
        }
        return direction;
    }

    public static float pointDirection(float x1, float y1, float x2, float y2) {
        float direction = (float) Math.toDegrees((float) Math.atan2(y2 - y1, x2 - x1));
        if (direction > 360) {
            direction -= 360;
        }
        if (direction < 0) {
            direction += 360;
        }
        return direction;
    }

    public static double pointDistance(double x1, double y1, double x2, double y2) {
        return (double) Math.sqrt((double) Math.pow(x2 - x1, 2) + (double) Math.pow(y2 - y1, 2));
    }

    public static float pointDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt((float) Math.pow(x2 - x1, 2) + (float) Math.pow(y2 - y1, 2));
    }

    public static double lengthDirX(double length, double direction) {
        return ((double) Math.cos(direction * (double) Math.PI / 180) * length);
    }

    public static double lengthDirY(double length, double direction) {
        return ((double) Math.sin(direction * (double) Math.PI / 180) * length);
    }

    public static float lengthDirX(float length, float direction) {
        return ((float) Math.cos(direction * (float) Math.PI / 180) * length);
    }

    public static float lengthDirY(float length, float direction) {
        return ((float) Math.sin(direction * (float) Math.PI / 180) * length);
    }
}
