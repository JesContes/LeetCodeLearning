package com.company.leetcode135;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author awmlk
 */
public class SolutionTest {
    @Test
    public void candyCalculateSuccess() {
        Solution solution = new Solution();
        int[] ratings = new int[]{1, 2, 2};
        Assert.assertEquals(4, solution.candy(ratings));
        ratings = new int[]{1, 3, 2, 2, 1};
        Assert.assertEquals(7, solution.candy(ratings));
    }
}