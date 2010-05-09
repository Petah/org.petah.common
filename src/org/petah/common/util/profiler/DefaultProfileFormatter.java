/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.util.profiler;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.petah.common.util.FormatUtil;

/**
 *
 * @author Petah
 */
public class DefaultProfileFormatter implements ProfileFormatter {

    public String format(Profile profile) {
        SimpleDateFormat formatter = new SimpleDateFormat("H:mm:ss");
        if (profile.getDescription() == null) {
            return profile.getThread().getName() + "\t" + profile.getProfileClass().getName() + "\t" + profile.getName() + "\t" +
                    formatter.format(new Date(profile.getStartTime() / 1000000)) + "\t" + FormatUtil.formatNanoTime(profile.getRunTime());
        } else {
            return profile.getThread().getName() + "\t" + profile.getProfileClass().getName() + "\t" + profile.getName() + "\t" +
                    formatter.format(new Date(profile.getStartTime() / 1000000)) + "\t(" +
                    profile.getDescription() + ")\t" + FormatUtil.formatNanoTime(profile.getRunTime());
        }
    }
}
