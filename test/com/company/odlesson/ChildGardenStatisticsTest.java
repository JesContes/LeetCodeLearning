package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChildGardenStatisticsTest {

    @Test
    public void statistics() {
        ChildGardenStatistics statistics = new ChildGardenStatistics();
        int[] garden1 = new int[]{2,2,3};
        int[] garden2 = new int[]{0,0,0,1,1,1,2,2,3,3,4,4,4,4,4,4};
        assertEquals(2, statistics.statistics(garden1));
        assertEquals(9, statistics.statistics(garden2));
    }
}