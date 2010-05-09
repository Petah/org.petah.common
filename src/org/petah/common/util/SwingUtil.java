/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util;

import com.sun.awt.AWTUtilities;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Petah
 */
public class SwingUtil {

    public static JFrame getImageJFrame(BufferedImage image) {
        ImageIcon icon = new ImageIcon();
        icon.setImage(image);
        JFrame frame = new JFrame();
        frame.add(new JLabel(icon));
        frame.pack();
        return frame;
    }

    public static void centerFrame(Window frame) {
        //Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        //Calculate the frame location
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;

        frame.setLocation(x, y);
    }

    public static void setFrameRelativeSize(Window frame, int width, int height) {
        //Get the screen size
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        //Calculate the frame location
        frame.setSize(screenSize.width - width, screenSize.height - height);
    }

    /**
     * This method returns the selected radio button in a button group.
     * @param group the button group
     * @return the selected radio button
     */
    public static JRadioButton getSelectedRadioButton(ButtonGroup group) {
        for (Enumeration e = group.getElements(); e.hasMoreElements();) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (b.getModel() == group.getSelection()) {
                return b;
            }
        }
        return null;
    }

    /**
     * Removes all buttons from a button group.
     * @param group the button group
     */
    public static void clearButtonGroup(ButtonGroup group) {
        while (group.getElements().hasMoreElements()) {
            group.remove(group.getElements().nextElement());
        }
    }

    /**
     * Places an internal frame on top of all other frames and selects it.
     * @param frame the JInternalFrame to bring to the top
     */
    public static void bringInternalFrameToTop(JDesktopPane desktopPane, JInternalFrame frame) {
        try {
            desktopPane.getDesktopManager().activateFrame(frame);
            frame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SwingUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a thread to fade a window in the out and then disposes of the window.
     * Note: Time is in seconds
     * @param window Window to fade
     * @param fadeIn Time  for fade in
     * @param wait Time to wait at full alpha
     * @param fadeOut Time to fade out
     */
    public static void fadeWindow(final Window window, final float fadeIn, final float wait, final float fadeOut) {
        new Thread(new Runnable() {

            public void run() {
                float alpha = 0;
                long time = System.currentTimeMillis();
                try {
                    while (alpha < 1) {
                        long elapsedTime = System.currentTimeMillis() - time;
                        time = System.currentTimeMillis();
                        alpha = Math.min(alpha + (1 * (float) elapsedTime / 1000f) / fadeIn, 1);
                        AWTUtilities.setWindowOpacity(window, alpha);
                        Thread.sleep(10);
                    }
                    Thread.sleep((long) (wait * 1000f));
                    time = System.currentTimeMillis();
                    while (alpha > 0) {
                        long elapsedTime = System.currentTimeMillis() - time;
                        time = System.currentTimeMillis();
                        alpha = Math.max(alpha - (1 * (float) elapsedTime / 1000f) / fadeOut, 0);
                        AWTUtilities.setWindowOpacity(window, alpha);
                        Thread.sleep(10);
                    }
                    window.setVisible(false);
                    window.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(SwingUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}
