package com.company.leetcode2859;

import java.util.List;

/**
 * @author JesContes
 * @description 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
 * 整数的二进制表示中的 1 就是这个整数的 置位 。
 * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
 * 思路：
 * 遍历人，遍历魂。完整遍历整个数组，对每个下标计算置位数，如果置位数等于k，则最终结果加上这个数
 * @since 2024/1/25
 */
public class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            int cal = i;
            int count = 0;
            while (cal > 0) {
                count += cal % 2;
                if (count > k) {
                    break;
                }
                cal = cal >> 1;
            }
            if (count == k) {
                result += nums.get(i);
            }
        }
        return result;
    }
}
