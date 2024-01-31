package com.company.leetcode2670;

/**
 * @author JesContes
 * @description nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
 * 返回 nums 的 不同元素数目差 数组。
 * 注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）。特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组。
 * 思路：
 * 两个哈希表，统计前缀数量和后缀数量，然后随着遍历过程，对于前缀数量递增，对于后缀数量递减，后缀递减到0后删除key，根据key的数量去计算，根据题目输入限制可以优化一下，用两个数组就行
 * @since 2024/1/31
 */
public class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] pre = new int[50];
        int[] back = new int[50];
        int preDifCount = 1;
        int backDifCount = 0;
        pre[nums[0] - 1] = 1;
        int[] difCount = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (back[nums[i] - 1] == 0) {
                backDifCount++;
            }
            back[nums[i] - 1]++;
        }
        difCount[0] = preDifCount - backDifCount;
        for (int i = 1; i < nums.length; i++) {
            if (pre[nums[i] - 1] == 0) {
                preDifCount++;
            }
            pre[nums[i] - 1]++;
            if (back[nums[i] - 1] == 1) {
                backDifCount--;
            }
            back[nums[i] - 1]--;
            difCount[i] = preDifCount - backDifCount;
        }
        return difCount;
    }
}
