/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Petah
 */
public class LookAndFeelUtil {

    public static void setLookAndFeel(final LookAndFeel lookAndFeel) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(lookAndFeel);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LookAndFeelUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public static void setLookAndFeel(final String className) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(className);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LookAndFeelUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LookAndFeelUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(LookAndFeelUtil.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(LookAndFeelUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
