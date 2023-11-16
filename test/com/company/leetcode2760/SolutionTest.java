package com.company.leetcode2760;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author awmlk
 */
public class SolutionTest {

    @Test
    public void longestAlternatingSubarray() {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,5,4};
        int threshold = 5;
        int result = solution.longestAlternatingSubarray(nums, threshold);
        Assert.assertEquals(3, result);
        nums = new int[]{1, 2};
        threshold = 2;
        result = solution.longestAlternatingSubarray(nums, threshold);
        Assert.assertEquals(1, result);
        nums = new int[]{2,3,4,5};
        threshold = 4;
        result = solution.longestAlternatingSubarray(nums, threshold);
        Assert.assertEquals(3, result);
        nums = new int[]{4,10,3};
        threshold = 10;
        result = solution.longestAlternatingSubarray(nums, threshold);
        Assert.assertEquals(2, result);
    }
}