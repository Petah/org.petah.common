/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.option;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 *
 * @author Petah
 */
public class OptionsManager implements Serializable {

    private static Map<String, Option> options = new TreeMap<String, Option>();

    static {
        Logger.getLogger(OptionsManager.class.getName()).info(OptionsManager.class.getName() + " initialized");
    }

    public static Object getValue(String optionName) {
        assert (options.containsKey(optionName)) : "OptionsManager does not contain option " + optionName;
        return options.get(optionName).getValue();
    }

    public static Option getOption(Option defaultOption, Option... metaOptions) {
        Option option;
        if (!options.containsKey(defaultOption.getName())) {
            setOption(defaultOption);
            option = defaultOption;
        }
        option = getOption(defaultOption.getName());
        for (Option metaOption : metaOptions) {
            option.getMetaOption(metaOption);
        }
        return option;
    }

    public static Option getOption(String optionName) {
        assert (options.containsKey(optionName)) : "OptionsManager does not contain option " + optionName;
        return options.get(optionName);
    }

    public static void setOption(Option option) {
        if (options.containsKey(option.getName())) {
            Option currentOption = options.get(option.getName());
            currentOption.setValue(option.getValue());
        } else {
            options.put(option.getName(), option);
        }
    }

    public static Map<String, Option> getOptions() {
        return options;
    }
}
