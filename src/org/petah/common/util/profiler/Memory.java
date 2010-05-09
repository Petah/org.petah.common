package org.petah.common.util.profiler;

/**
 * This class is used to get information about the current memory state.
 * @author David Neilsen
 */
public class Memory {

    /** The amount of free memory (in bytes) */
    private long free;
    /** The amount of used memory (in bytes) */
    private long used;
    /** The amount of allocated memory (in bytes) */
    private long allocated;
    /** The maximum amount of memory (in bytes) */
    private long maximum;

    /**
     * Gets the amount of free memory in bytes.
     * @return the amount of free memory
     */
    public long getFree() {
        return free;
    }

    /**
     * Gets the amount of used memory in bytes.
     * @return the amount of used memory
     */
    public long getUsed() {
        return used;
    }

    /**
     * Gets the amount of allocated memory in bytes.
     * @return the amount of allocated memory
     */
    public long getAllocated() {
        return allocated;
    }

    /**
     * Gets the maximum amount of memory in bytes.
     * @return the maximum amount of memory
     */
    public long getMaximum() {
        return maximum;
    }

    /**
     * Updates the current memory state
     */
    public void update() {
        // The amount of memory allocated so far (usually the -Xms setting)
        allocated = Runtime.getRuntime().totalMemory();

        // Free memory out of the amount allocated (value above minus used)
        free = Runtime.getRuntime().freeMemory();

        //Calculate the used memory
        used = allocated - free;

        // The maximum amount of memory that can eventually be consumed
        // by this application. This is the value set by the Preferences
        // dialog box to increase the memory settings for an application.
        maximum = Runtime.getRuntime().maxMemory();
    }
}