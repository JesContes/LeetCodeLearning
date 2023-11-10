package com.company.leetcode42;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 接雨水
     *
     * @param height 每根柱子高度
     * @return 接雨水体积
     */
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        // 首先从左往右获取左起当前最高值
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 然后从右往左获取右起当前最高值
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        // i位置的雨水高度最高为左起最高值和右起最高值的较小值，较小值减去i位置柱子的高度，就是i位置积累雨水的体积
        int trapRainVolume = 0;
        for (int i = 0; i < height.length; i++) {
            trapRainVolume += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return trapRainVolume;
    }
}
