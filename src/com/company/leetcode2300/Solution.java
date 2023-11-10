package com.company.leetcode2300;

import java.util.Arrays;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 计算咒语能成功组合的药水数目
     *
     * @param spells 咒语数组
     * @param potions 药水数组
     * @param success 成功值
     * @return 咒语能成功组合的药水数目
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // 排序药水，如果药水遍历到某个值的乘积大于等于success的值，则意味着接下来的也能大于，直接赋值length-j即可
        Arrays.sort(potions);
        int[] pairNumbers = new int[spells.length];
        // 二分法提升取值效率
        for (int i = 0; i < spells.length; i++) {
            int lowIndex = 0;
            int highIndex = potions.length - 1;
            boolean lessThanSuccess = false;
            int midIndex = 0;
            while (lowIndex <= highIndex) {
                midIndex = (lowIndex + highIndex) / 2;
                if ((long) spells[i] * potions[midIndex] < success) {
                    lowIndex = midIndex + 1;
                    lessThanSuccess = true;
                } else {
                    highIndex = midIndex - 1;
                    lessThanSuccess = false;
                }
            }
            pairNumbers[i] = lessThanSuccess ? potions.length - midIndex - 1 : potions.length - midIndex;
        }
        return pairNumbers;
    }
}
