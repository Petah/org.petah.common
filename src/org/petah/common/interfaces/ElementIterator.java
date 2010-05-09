/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.interfaces;

/**
 *
 * @author Petah
 */
public class ElementIterator {

    public static <T> void iterateElements(Iterable<T> iterable, ElementProcessor<T> elementProcessor) {
        for (T element : iterable) {
            elementProcessor.process(element);
        }
    }
}
