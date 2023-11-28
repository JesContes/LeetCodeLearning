package com.company.leetcode1670;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrontMiddleBackQueueTest {
    @Test
    public void test1() {
        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        queue.pushFront(888438);
        queue.pushMiddle(772690);
        queue.pushMiddle(375192);
        queue.pushFront(411268);
        queue.pushFront(885613);
        queue.pushMiddle(508187);
        assertEquals(508187,queue.popMiddle());
        assertEquals(772690, queue.popMiddle());
        queue.pushMiddle(111498);
        queue.pushMiddle(296008);
        assertEquals(885613, queue.popFront());
    }
}