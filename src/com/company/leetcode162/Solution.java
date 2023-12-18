package com.company.leetcode162;

/**
 * @author awmlk
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 思路：
 * O(log n)算法，第一时间想到二分，但是没明白这种顺序不规则的情况下，二分的判定条件是什么
 * 看了官方题解，理解了下，比如第一轮我们找了中间点，这个时候中间点不满足要求，那么如果右邻更高，那右侧一定存在峰值点，因为即便是右边一直递增，
 * 那最右因为是边界点，一定满足右邻小于自身，所以结果就是最右，左侧同理，再次拆分之后划出来的区间范围也同样满足这个逻辑，所以虽然不是严格的，
 * 但最终一定会找到这个点
 */
public class Solution {
    /**
     * 查找峰值元素
     *
     * @param nums 原始数组
     * @return 峰值元素下标
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (mid + 1 < nums.length && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }
}
