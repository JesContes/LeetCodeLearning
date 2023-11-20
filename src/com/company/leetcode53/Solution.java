package com.company.leetcode53;

/**
 * @author awmlk
 */
class Solution {
    /**
     * 求解子数组最大和
     *
     * @param nums 原始数组
     * @return 子数组最大和
     */
    public int maxSubArray(int[] nums) {
        return traversal(nums);
    }

    /**
     * 遍历法求解最大和
     *
     * @param nums 原始数组
     * @return 子数组最大和
     */
    private int traversal(int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempMax < 0) {
                tempMax = nums[i];
            } else {
                tempMax += nums[i];
            }
            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }
}
