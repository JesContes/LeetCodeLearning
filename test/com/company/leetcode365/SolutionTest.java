package com.company.leetcode365;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author JesContes
 * @description some desc
 * @since 2024/1/28
 */
public class SolutionTest {

    @Test
    public void canMeasureWater() {
        int jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4;
        Solution solution = new Solution();
        boolean result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        assertTrue(result);
    }

    @Test
    public void canMeasureWater_2() {
        int jug1Capacity = 22003, jug2Capacity = 31237, targetCapacity = 1;
        Solution solution = new Solution();
        boolean result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        assertTrue(result);
    }

    @Test
    public void canMeasureWater_3() {
        int jug1Capacity = 13, jug2Capacity = 11, targetCapacity = 1;
        Solution solution = new Solution();
        boolean result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        assertTrue(result);
    }

    @Test
    public void canMeasureWater_4() {
        int jug1Capacity = 104693, jug2Capacity = 104701, targetCapacity = 324244;
        Solution solution = new Solution();
        boolean result = solution.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity);
        assertFalse(result);
    }
}