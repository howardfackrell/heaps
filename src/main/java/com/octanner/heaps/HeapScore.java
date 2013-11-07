package com.octanner.heaps;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: howard.fackrell
 * Date: 11/6/13
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class HeapScore {

    public static int MAX_ELEMENTS = 5000;
    public static String[] implementations = {
            "com.octanner.heaps.hlf.SlowHeap",
            "com.octanner.heaps.hlf.PerformantHeap"

    };


    public static void main(String[] args) {

        HeapScore score = new HeapScore();

        List<HeapResult> resultList = new ArrayList<HeapResult>();
        for(String implementation :implementations) {
            resultList.add(score.testHeapImplementation(implementation));
        }

        for (HeapResult result : resultList) {
            System.out.println(result);
        }

    }

    private int random(int min, int max) {
        int scale = max - min;
        Double r = Math.floor(Math.random() * scale + min);
        return r.intValue();
    }
    private HeapResult testHeapImplementation(String className) {

        Date start = new Date();
        boolean passed = true;
        try {
            passed = excerciseHeap(className);
        } catch (Exception e) {
            passed = false;
        }
        Date stop = new Date();

        long millis = stop.getTime() - start.getTime();
        return new HeapResult(className, passed, millis);
    }

    private boolean excerciseHeap(String className) throws Exception {
        Heap<Integer> h1 = instantiate(className);
        fillHeap(h1);

        Heap<Integer> h2 = instantiate(className);
        fillHeap(h2);

        h1.merge(h2);

        return isHeapInOrder(h1);
    }

    private boolean isHeapInOrder(Heap<Integer> h1) {
        int last = -1;
        boolean isInOrder = true;
        while (h1.isEmpty() == false) {
            int current = h1.removeMin();
            if (current < last) {
                isInOrder = false;
            }
            last = current;
        }
        return isInOrder;
    }

    private void fillHeap(Heap<Integer> h1) {
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            h1.insert(random(0, 1000));
        }
    }

    private Heap<Integer> instantiate(String className) throws Exception {
        Class<Heap<Integer>> heapClass = (Class<Heap<Integer>>) Class.forName(className);
        Constructor<Heap<Integer>> heapConstuctor = heapClass.getConstructor(Comparator.class);
        Heap<Integer> heap = heapConstuctor.newInstance(new IntComparator());
        return heap;
    }

    class IntComparator implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o1-o2;
        }
    }

    class HeapResult {
        public HeapResult(String name, boolean passed, long executionTime) {
            this.name = name;
            this.passed = passed;
            this.executionTime = executionTime;
        }
        final String name;
        final long executionTime;
        final boolean passed;
        public String toString() {
            return name + "\t" + passed + "\t" + executionTime;
        }
    }
}
