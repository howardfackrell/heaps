package com.octanner.heaps.hlf;

import com.octanner.heaps.Heap;
import com.octanner.heaps.RemoveFromEmptyHeapException;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Howard.Fackrell
 * Date: 11/6/13
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class PerformantHeap<T> implements Heap<T> {
    private PriorityQueue<T> queue;

    public PerformantHeap(Comparator<T> comparator) {
        queue = new PriorityQueue<T>(10, comparator);
    }

    public void insert(T element) {
        queue.add(element);
    }

    public T removeMin() {
        if(isEmpty()) {
            throw new RemoveFromEmptyHeapException();
        }
        return queue.remove();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void merge(Heap<T> otherHeap) {
        queue.addAll(otherHeap.allElements());
    }

    public Collection<T> allElements() {
        Collection<T> copy = new ArrayList<T>();
        copy.addAll(queue);
        return copy;
    }

}
