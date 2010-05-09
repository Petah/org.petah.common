/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.petah.common.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author davnei06
 */
public class TestCollection {

    private static final int SIZE = 50000;

    public static void main(String[] args) {
        while (true) {
//            testQueue(new ConcurrentLinkedQueue<Double>());
//            testQueue(new PriorityBlockingQueue<Double>());
//            testList(new LinkedList<Double>());
//            testList(new ArrayList<Double>());
//            testList(new Vector<Double>());
//            testSet(new TreeSet<Double>());
            iterateTest(fillCollection(new TreeSet<Double>(), 500000));
            iterateTest(fillCollection(new ArrayList<Double>(500000), 500000));
            iterateTest(fillCollection(new LinkedList<Double>(), 500000));
//            testSet(new CopyOnWriteArraySet<Double>());
        }
    }

    public static void testAllLists() {
        testList(new CopyOnWriteArrayList<Double>());
    }

    public static Collection<Double> fillCollection(Collection<Double> c, int amount) {
        while (amount > 0) {
            c.add(Math.random());
            amount--;
        }
        return c;
    }

    public static void iterateTest(Collection c) {
        long time = System.currentTimeMillis();
        for (Object o : c) {
        }
        System.out.println(c.getClass().getSimpleName() + " iterate in " + (System.currentTimeMillis() - time) + "ms");
    }

    public static void testList(List c) {
        String result = "";
        result += c.getClass().getSimpleName() + ": ";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            c.add(Math.random());
        }
        result += "adding " + SIZE + " values: " + (System.currentTimeMillis() - startTime) + "ms ";
        long count = 0;
        startTime = System.currentTimeMillis();
        long time = System.currentTimeMillis() + 1000;

        while (time > System.currentTimeMillis()) {
            c.add(Math.random());
            c.add(Math.random());
            c.add(Math.random());
            c.remove(c.get((int) (Math.random() * c.size())));
            c.remove(c.get((int) (Math.random() * c.size())));
            c.remove(c.get((int) (Math.random() * c.size())));
            count++;
        }
        result += "add/remove/get test: " + count + " in " + (System.currentTimeMillis() - startTime) + "ms ";
        System.out.println(result);
    }

    public static void testSet(Set c) {
        String result = "";
        result += c.getClass().getSimpleName() + ": ";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            c.add(Math.random());
        }
        result += "adding " + SIZE + " values: " + (System.currentTimeMillis() - startTime) + "ms ";
        long count = 0;
        startTime = System.currentTimeMillis();
        long time = System.currentTimeMillis() + 1000;

        while (time > System.currentTimeMillis()) {
            double d;
            c.add(d = Math.random());
            c.remove(d);
            c.add(d = Math.random());
            c.remove(d);
            c.add(d = Math.random());
            c.remove(d);
            count++;
        }
        result += "add/remove/get test: " + count + " in " + (System.currentTimeMillis() - startTime) + "ms ";
        System.out.println(result);
    }

    public static void testQueue(Queue c) {
        String result = "";
        result += c.getClass().getSimpleName() + ": ";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            c.add(Math.random());
        }
        result += "adding " + SIZE + " values: " + (System.currentTimeMillis() - startTime) + "ms ";
        long count = 0;
        startTime = System.currentTimeMillis();
        long time = System.currentTimeMillis() + 1000;

        while (time > System.currentTimeMillis()) {
            double d;
            c.add(d = Math.random());
            c.remove(d);
            c.add(d = Math.random());
            c.remove(d);
            c.add(d = Math.random());
            c.remove(d);
            count++;
        }
        result += "add/remove/get test: " + count + " in " + (System.currentTimeMillis() - startTime) + "ms ";
        System.out.println(result);
    }
}
