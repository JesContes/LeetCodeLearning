package com.company.leetcode53;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void maxSubArray() {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution solution = new Solution();
        int result = solution.maxSubArray(nums);
        Assert.assertEquals(6, result);
    }

    @Test
    public void maxSubArrayWhenOnlyOneNum() {
        int[] nums = new int[]{1};
        Solution solution = new Solution();
        int result = solution.maxSubArray(nums);
        Assert.assertEquals(1, result);
    }

    @Test
    public void maxSubArraySecondNumArray() {
        int[] nums = new int[]{5,4,-1,7,8};
        Solution solution = new Solution();
        int result = solution.maxSubArray(nums);
        Assert.assertEquals(23, result);
    }

    @Test
    public void maxSubArrayWhenOnlyNegative() {
        int[] nums = new int[]{-3,-5,-1,-8,-4,-10};
        Solution solution = new Solution();
        int result = solution.maxSubArray(nums);
        Assert.assertEquals(-1, result);
    }
}