/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.test;

import java.util.TreeMap;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author Petah
 */
public class TestTreeMap {

    public static void main(String[] args) {
        TreeMap<Double, Integer> map = new TreeMap<Double, Integer>();
        for (int i = 0; i < 100; i++) {
            map.put((double) i, i);
        }
        for (Double i : map.keySet()) {
            System.out.println(i);
        }
    }
}
