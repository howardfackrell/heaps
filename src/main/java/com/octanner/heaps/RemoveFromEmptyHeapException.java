package com.octanner.heaps;

/**
 * Created with IntelliJ IDEA.
 * User: howard.fackrell
 * Date: 11/6/13
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class RemoveFromEmptyHeapException extends RuntimeException {
    public RemoveFromEmptyHeapException() {
        super("Can't call removeMin() on an empty Heap");
    }
}
