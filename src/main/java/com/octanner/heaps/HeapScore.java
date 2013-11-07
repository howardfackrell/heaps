package com.octanner.heaps;

import com.octanner.heaps.hlf.HeapImplementation;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * Created with IntelliJ IDEA.
 * User: howard.fackrell
 * Date: 11/6/13
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeapScore<T> {

    public static void main(String[] args) {

        HeapScore score = new HeapScore();
        score.scoreHeap();
    }

    private void scoreHeap() {


    }

    private Heap<T> instantiate(String className) {
        Class heapClass = Class.forName(className);
        Constructor<T> heapConstuctor = heapClass.getConstructor(Comparator.class);
        heapConstuctor.newInstance(new IntComparator

    }

    class IntComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }
}
