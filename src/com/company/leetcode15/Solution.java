package com.company.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 三数之和
     *
     * @param nums 原始数组
     * @return 三数之和为0的不重复组合
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int tempI = nums[0];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && tempI == nums[i]) {
                continue;
            }
            tempI = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            if (nums[i] + nums[k - 1] + nums[k] < 0) {
                continue;
            }
            if (nums[i] + nums[j] + nums[j + 1] > 0) {
                break;
            }
            Integer tempJ = null;
            while (j < k) {
                if (tempJ != null && tempJ == nums[j]) {
                    j++;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> onePair = new ArrayList<>();
                    onePair.add(nums[i]);
                    onePair.add(nums[j]);
                    onePair.add(nums[k]);
                    result.add(onePair);
                    tempJ = nums[j];
                    k--;
                    j++;
                }
            }
        }
        return result;
    }
}
