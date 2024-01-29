package com.company.leetcode2808;

import java.util.HashMap;
import java.util.List;

/**
 * @author JesContes
 * @description 给你一个下标从 0 开始长度为 n 的数组 nums 。
 * 每一秒，你可以对数组执行以下操作：
 * 对于范围在 [0, n - 1] 内的每一个下标 i ，将 nums[i] 替换成 nums[i] ，nums[(i - 1 + n) % n] 或者 nums[(i + 1) % n] 三者之一。
 * 注意，所有元素会被同时替换。
 * 请你返回将数组 nums 中所有元素变成相等元素所需要的 最少 秒数。
 * 思路：
 * 先遍历找出每个值两两之间的最大距离，用最小的最大距离除以2，商和余数的和就是需要的最小秒数
 * @since 2024/1/30
 */
public class Solution {
    public int minimumSeconds(List<Integer> nums) {
        // int[]共3位，int[0]记录首次出现的坐标，int[1]记录上次出现的坐标，int[2]记录相邻坐标中，距离最大的值，这个求的是不包含这两个坐标本身的距离
        HashMap<Integer, int[]> numAppearIndex = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (!numAppearIndex.containsKey(nums.get(i))) {
                // 赋初值，当num仅出现一次时，距离为列表里面除开它本身的所有数的数量
                numAppearIndex.put(nums.get(i), new int[]{i, i, nums.size() - 1});
                continue;
            }
            int[] indexDisCal = numAppearIndex.get(nums.get(i));
            // 因为要找的是最大距离，所以这里要考虑初值最大的特殊情况，如果是初值，则一定要修改为当前距离
            indexDisCal[2] = indexDisCal[0] == indexDisCal[1]
                    ? i - indexDisCal[1] - 1 : Math.max(indexDisCal[2], i - indexDisCal[1] - 1);
            indexDisCal[1] = i;
        }
        int minDistance = nums.size() - 1;
        for (int[] indexDisCal : numAppearIndex.values()) {
            // 考虑最尾和头部的两个坐标的特殊情况
            indexDisCal[2] = Math.max(indexDisCal[2], nums.size() - 1 - indexDisCal[1] + indexDisCal[0]);
            minDistance = Math.min(minDistance, indexDisCal[2]);
        }
        return minDistance / 2 + minDistance % 2;
    }
}
