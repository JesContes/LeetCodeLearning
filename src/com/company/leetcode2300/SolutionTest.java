package com.company.leetcode2300;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author awmlk
 */
public class SolutionTest {
    @Test
    public void calSuccessfulPairsSuccess() {
        int[] spells = new int[]{5,1,3};
        int[] potions = new int[]{1,2,3,4,5};
        int success = 7;
        Solution solution = new Solution();
        int[] result = solution.successfulPairs(spells, potions, success);
        Assert.assertEquals(4, result[0]);
        Assert.assertEquals(0, result[1]);
        Assert.assertEquals(3, result[2]);
        spells = new int[]{3,1,2};
        potions = new int[]{8,5,8};
        success = 16;
        result = solution.successfulPairs(spells, potions, success);
        Assert.assertEquals(2, result[0]);
        Assert.assertEquals(0, result[1]);
        Assert.assertEquals(2, result[2]);
    }
}