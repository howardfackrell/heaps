package com.octanner.heaps.hlf;

import com.octanner.heaps.Heap;
import com.octanner.heaps.RemoveFromEmptyHeapException;
import org.testng.annotations.Test;

import java.util.Comparator;

import static org.testng.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: howard.fackrell
 * Date: 11/6/13
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class HeapTest {

    private HeapImplementation<Integer> createIntegerHeap() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        return new HeapImplementation<Integer>(comparator);
    }

    @Test
    public void exists() {
        Heap<Integer> intHeap = createIntegerHeap();
        assertNotNull(intHeap);
    }

    @Test
    public void newHeapIsEmpty() {
        Heap<Integer> intHeap = createIntegerHeap();
        assertTrue(intHeap.isEmpty());
    }

    @Test(expectedExceptions = RemoveFromEmptyHeapException.class)
    public void popEmptyHeapThrowsException() {
        Heap<Integer> intHeap = createIntegerHeap();
        Integer min = intHeap.removeMin();
    }

    @Test
    public void insertMakesHeapNotEmpty() {
        Heap<Integer> intHeap = createIntegerHeap();
        Integer three = new Integer(3);
        intHeap.insert(three);
        assertFalse(intHeap.isEmpty());
    }

    @Test
    public void insertThenRemoveMakesHeapEmpty() {
        Heap<Integer> intHeap = createIntegerHeap();
        Integer three = new Integer(3);
        intHeap.insert(three);
        Integer min = intHeap.removeMin();
        assertTrue(intHeap.isEmpty());
    }

    @Test
    public void insertThenRemoveReturnsTheInsertedElement() {
        Heap<Integer> intHeap = createIntegerHeap();
        Integer three = new Integer(3);
        intHeap.insert(three);
        Integer min = intHeap.removeMin();
        assertEquals(min, three);
    }

    @Test
    public void removeMinReturnsMinOfTwoElements() {
        Heap<Integer> intHeap = createIntegerHeap();
        Integer three = new Integer(3);
        Integer five = new Integer(5);
        intHeap.insert(three);
        intHeap.insert(five);
        assertEquals(three, intHeap.removeMin());
    }

    @Test
    void mergeTwoEmptyHeapsGivesEmptyHeap() {
        Heap<Integer> h1 = createIntegerHeap();
        HeapImplementation<Integer> h2 = createIntegerHeap();
        h1.merge(h2);
        assertTrue(h1.isEmpty());
    }

    @Test
    void mergedNotEmptyIntoEmptyGivesNotEmpty() {
        Heap<Integer> h1 = createIntegerHeap();
        HeapImplementation<Integer> h2 = createIntegerHeap();

        h2.insert(4);
        h2.insert(6);

        h1.merge(h2);
        assertFalse(h1.isEmpty());
    }

    @Test
    void mergedHeapContainsAllElements() {
        Heap<Integer> h1 = createIntegerHeap();
        HeapImplementation<Integer> h2 = createIntegerHeap();

        h1.insert(1);
        h1.insert(2);
        h2.insert(3);
        h2.insert(4);

        h1.merge(h2);

        assertEquals(h1.removeMin(), new Integer(1));
        assertEquals(h1.removeMin(), new Integer(2));
        assertEquals(h1.removeMin(), new Integer(3));
        assertEquals(h1.removeMin(), new Integer(4));
    }


}
