/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.option;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Petah
 */
public class Option<T> implements Serializable {

    private String name;
    private T value;
    private Map<String, Option> metaOptions = new TreeMap<String, Option>();

    public Option(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setMetaOption(Option option) {
        if (metaOptions.containsKey(option.getName())) {
            Option currentOption = metaOptions.get(option.getName());
            currentOption.setValue(option.getValue());
        } else {
            metaOptions.put(option.getName(), option);
        }
    }

    public Object getMetaOptionValue(String optionName) {
        if (metaOptions.containsKey(optionName)) {
            return metaOptions.get(optionName).getValue();
        }
        return null;
    }

    public Option getMetaOption(Option defaultOption) {
        if (!metaOptions.containsKey(defaultOption.getName())) {
            setMetaOption(defaultOption);
            return defaultOption;
        }
        return getMetaOption(defaultOption.getName());
    }

    public Option getMetaOption(String optionName) {
        if (metaOptions.containsKey(optionName)) {
            return metaOptions.get(optionName);
        }
        return null;
    }

    public Map<String, Option> getMetaOptions() {
        return metaOptions;
    }
}
