/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author Petah
 */
public class FileUtil {

    /**
     *
     * @param fromDirectory
     * @param toDirectory
     * @return the amount of files moved
     */
    public static int moveAllFiles(File fromDirectory, File toDirectory) {
        return moveAllFiles(fromDirectory, toDirectory, new FilenameFilter() {

            public boolean accept(File dir, String name) {
                return true;
            }
        });
    }

    public static int moveAllFiles(File fromDirectory, File toDirectory, FilenameFilter filter) {
        if (!fromDirectory.isDirectory()) {
            throw new IllegalArgumentException(fromDirectory + " is not a valid directory.");
        }
        if (!toDirectory.isDirectory()) {
            toDirectory.mkdirs();
        }
        int movedFiles = 0;
        for (File file : fromDirectory.listFiles(filter)) {
            if (file.isFile()) {
                File newFile = new File(toDirectory + File.separator + file.getName());
                if (newFile.isFile()) {
                    throw new RuntimeException("File already exists in " + toDirectory + ". Files moved: " + movedFiles);
                }
                if (file.renameTo(newFile)) {
                    movedFiles++;
                } else {
                    throw new RuntimeException("Could not move file: " + file.getAbsolutePath() + " to " + newFile.getAbsolutePath());
                }
            }
        }
        return movedFiles;
    }

    public static boolean deleteDirectory(File path) {
        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        return path.delete();
    }
}
