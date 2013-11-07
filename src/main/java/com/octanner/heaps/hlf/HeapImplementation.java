package com.octanner.heaps.hlf;

/**
 * Created with IntelliJ IDEA.
 * User: howard.fackrell
 * Date: 11/6/13
 * Time: 9:13 AM
 * To change this template use File | Settings | File Templates.
 */

import com.octanner.heaps.Heap;
import com.octanner.heaps.RemoveFromEmptyHeapException;

import java.util.*;

public class HeapImplementation<T> implements Heap<T> {
    private Comparator<T> comparator;
    private List<T> elementList;

    public HeapImplementation(Comparator<T> comparator) {
        this.comparator = comparator;
        elementList = new ArrayList<T>();
    }

    public void insert(T element) {
        elementList.add(element);
    }

    public T removeMin() {
        if(isEmpty()) {
            throw new RemoveFromEmptyHeapException();
        }
        Collections.sort(elementList, comparator);
        return elementList.remove(0);
    }

    public boolean isEmpty() {
        return elementList.isEmpty();
    }

    public void merge(Heap<T> otherHeap) {
        elementList.addAll(otherHeap.allElements());
    }

    public Collection<T> allElements() {
        Collection<T> copy = new ArrayList<T>();
        copy.addAll(elementList);
        return copy;
    }
}

