package com.octanner.heaps;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: howard.fackrell
 * Date: 11/6/13
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Heap<T> {
    void insert(T element);

    T removeMin();

    boolean isEmpty();

    void merge(Heap<T> otherHeap);

    Collection<T> allElements();

}
