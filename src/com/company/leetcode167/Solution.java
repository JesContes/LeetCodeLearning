package com.company.leetcode167;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 求两数和达到target的两个数在numbers中的下标
     *
     * @param numbers 原始数组
     * @param target 目标和
     * @return 两个数下标
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] result = new int[2];
        while (i < j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }
}
