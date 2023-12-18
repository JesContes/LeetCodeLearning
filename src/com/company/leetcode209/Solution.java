package com.company.leetcode209;

import java.util.Arrays;

/**
 * @author awmlk
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 思路：
 * 1、两头剪枝，先算出来全部数字的和，然后一直循环，减去头尾的较小值，直到不管减去头还是减去尾，都无法满足target，就返回当前长度 -- 这个方法不行，比如target = 15， nums = [6,6,6,1,1,1,1,1,1,1,1,1,7]，会一直裁剪左侧，但实际上前三个6就满足了
 * 2、滑动窗口，左右指针都从起点开始，先把右指针一直向右，当超过target时，移动左指针，小于target时，移动右指针，不停循环，中间根据实际情况更新最小长度
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        return slidingWindow(target, nums);
    }

    @Deprecated
    private int tailorSides(int target, int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target) {
            return 0;
        }
        int len = nums.length;
        int start = 0;
        int end = nums.length - 1;
        while (sum >= target) {
            if (nums[start] <= nums[end]) {
                sum -= nums[start];
                start++;
            } else {
                sum -= nums[end];
                end--;
            }
        }
        return end - start + 2;
    }

    private int slidingWindow(int target, int[] nums) {
        int i = 0;
        int j = 1;
        int sum = nums[0];
        if (sum >= target) {
            return 1;
        }
        int minLen = 0;
        while (j < nums.length) {
            while (j < nums.length && sum < target) {
                sum += nums[j];
                j++;
            }
            if (sum >= target) {
                minLen = minLen == 0 ? j - i : Math.min(minLen, j - i);
            }
            while (sum >= target) {
                minLen = Math.min(minLen, j - i);
                sum -= nums[i];
                i++;
            }
        }
        return minLen;
    }
}
