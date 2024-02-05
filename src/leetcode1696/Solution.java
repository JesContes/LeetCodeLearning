package leetcode1696;

import java.util.TreeMap;

/**
 * @author JesContes
 * @description 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * 请你返回你能得到的 最大得分 。
 * 思路：
 * 主要是有负数，不然就是所有数字的和了，用动态规划
 * dp[i] = Math.max(dp[i-k] + nums[i], ..., dp[i - 1] + nums[i])
 * dp[i] 代表跳到i位置的最大得分
 * @since 2024/2/5
 */
public class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        TreeMap<Integer, Integer> kNumList = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int outsideBound = i - k - 1;
            if (outsideBound >= 0) {
                int boundNum = kNumList.get(dp[outsideBound]);
                if (boundNum == 1) {
                    kNumList.remove(dp[outsideBound]);
                } else {
                    kNumList.put(dp[outsideBound], boundNum - 1);
                }
            }
            int lastMaxDp = kNumList.isEmpty() ? 0 : kNumList.lastKey();
            dp[i] = nums[i] + lastMaxDp;
            kNumList.put(dp[i], kNumList.getOrDefault(dp[i], 0) + 1);
        }
        return dp[nums.length - 1];
    }
}
