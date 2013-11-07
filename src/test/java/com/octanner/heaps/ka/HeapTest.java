package com.octanner.heaps.ka;

import junit.framework.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: howard.fackrell
 * Date: 11/6/13
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class HeapTest {
    @Test
    public void testIsEmpty(){
        Heap<Integer> heap = new Heap<Integer>();
        Assert.assertTrue(heap.isEmpty());
    }

    @Test
    public void testInsert() {

    }
}
