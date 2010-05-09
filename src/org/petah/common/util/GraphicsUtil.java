/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util;

import java.awt.Graphics;

/**
 *
 * @author Petah
 */
public class GraphicsUtil {

    public static void drawCross(Graphics g, int x, int y, int size) {
        g.drawLine(x - size, y - size, x + size, y + size);
        g.drawLine(x + size, y - size, x - size, y + size);
    }

    public static void drawPlus(Graphics g, int x, int y, int size) {
        g.drawLine(x, y - size, x, y + size);
        g.drawLine(x + size, y, x - size, y);
    }
}
