package com.company.leetcode2760;

/**
 * @author awmlk
 */
class Solution {
    /**
     * 求最长奇偶循环子数组长度
     *
     * @param nums 原始数组
     * @param threshold 子数组中最大限制值
     * @return 最长奇偶循环子数组长度
     */
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int subArrayLen = 0;
        int tempLen = 0;
        boolean evenNumCheck = false;
        for (int num : nums) {
            if (num <= threshold) {
                if (!evenNumCheck && num % 2 == 0) {
                    evenNumCheck = true;
                    tempLen++;
                    continue;
                }
                if (evenNumCheck && num % 2 == 1) {
                    evenNumCheck = false;
                    tempLen++;
                    continue;
                }
            }
            subArrayLen = Math.max(tempLen, subArrayLen);
            tempLen = num % 2 == 0 && num <= threshold ? 1 : 0;
            evenNumCheck = num % 2 == 0 && num <= threshold;
        }
        subArrayLen = Math.max(tempLen, subArrayLen);
        return subArrayLen;
    }
}
