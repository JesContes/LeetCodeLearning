package com.company.leetcode238;

/**
 * @author awmlk
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
            rightProduct[nums.length - 1 - i] = rightProduct[nums.length - i] * nums[nums.length - i];
        }
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = leftProduct[i] * rightProduct[i];
        }
        return results;
    }
}
