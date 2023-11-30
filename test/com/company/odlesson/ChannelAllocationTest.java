package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChannelAllocationTest {

    @Test
    public void channelAllocation() {
        int r = 5;
        int d = 30;
        int[] channelNum = new int[]{10,5,0,1,3,2};
        ChannelAllocation allocation = new ChannelAllocation();
        int result = allocation.channelAllocation(r, channelNum, d);
        assertEquals(4, result);
    }
}