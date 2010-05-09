package org.petah.common.extension;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author David Neilsen
 */
public class ExtensionLoader {

    public static void load(ExtensionManager extensionManager, File file, File workingDir) {
        extensionManager.addExtension(extractFile(extensionManager, file, workingDir));
    }

    public static void loadAll(ExtensionManager extensionManager, File directory, File workingDir) {
        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".jar")) {
                load(extensionManager, file, workingDir);
            }
        }
    }

    private static Extension extractFile(ExtensionManager extensionManager, File file, File workingDir) {
        workingDir = new File(workingDir.getAbsolutePath() + File.separator + System.currentTimeMillis());
        Vector<File> files = new Vector<File>();
        OutputStream out = null;
        ZipInputStream in = null;
        try {
            // Open the ZIP file
            in = new ZipInputStream(new FileInputStream(file));

            while (true) {
                // Get the next entry
                ZipEntry entry = in.getNextEntry();
                if (entry == null) {
                    break;
                }

                //If the entry is a directory continue to the next entry
                if (entry.isDirectory()) {
                    continue;
                } else {
                    // Create the directorys the file is in (if needed)
                    File outputDir = new File(workingDir.getAbsolutePath() + File.separator + entry.getName());
                    outputDir = outputDir.getParentFile();
                    outputDir.mkdirs();
                    outputDir.deleteOnExit();
                }

                // Open the output file
                File outputFile = new File(workingDir.getAbsolutePath() + File.separator + entry.getName());
                if (outputFile.exists()) {
                    Logger.getLogger(ExtensionLoader.class.getName()).log(Level.WARNING, null,
                            new Exception("Warning file already exists in working directory: " + outputFile.getAbsoluteFile()));
                }
                out = new FileOutputStream(outputFile);

                // Transfer bytes from the ZIP file to the output file
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                // Close the output file stream
                out.close();

                // Delete the file from the working directory on exit
                outputFile.deleteOnExit();

                //Add the file to the list of files
                files.add(outputFile);
            }
            // Close the input file stream
            in.close();
        } catch (Exception ex) {
            Logger.getLogger(ExtensionLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        Extension extension = loadClasses(extensionManager, files, workingDir);
        extension.setFile(file);
        return extension;
    }

    private static String parseClassName(File file, File workingDir) {
        String className = file.getAbsolutePath();
        className = className.substring(workingDir.getAbsolutePath().length() + 1);
        if (File.separator.equals("\\")) {
            className = className.replaceAll("\\\\", ".");
        } else {
            className = className.replaceAll(File.separator, ".");
        }
        className = className.replace(".class", "");
        return className;
    }

    private static Extension loadClasses(ExtensionManager extensionManager, Vector<File> files, File workingDir) {
        ClassPath.add(workingDir.getAbsoluteFile());
        Extension extension = new Extension();
        for (File file : files) {
            // Attempt to load the class
            if (file.getName().endsWith(".class")) {
                try {
                    //Get the fully qualified class name
                    String className = parseClassName(file, workingDir);
                    // Convert File to a URL
                    URL[] urls = {file.toURI().toURL()};
                    // Create a new class loader with the directory
                    ClassLoader loader = new URLClassLoader(urls);
                    // Load the class
                    Class c = loader.loadClass(className);
                    //Check if class is conpatible for loading
                    if (extensionManager.isClassCompatible(c)) {
                        Object o = c.newInstance();
                        extension.addObject(o);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ExtensionLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return extension;
    }
}
