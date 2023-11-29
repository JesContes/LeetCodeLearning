package com.company.leetcode1221;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 分割平衡字符串，字符串中仅包含两种字符，题目默认是L和R，要求分割成尽可能多的同样是平衡字符串的字串
     * 思路是遍历就完事了
     *
     * @param s 原始平衡字符串
     * @return 分割后的平衡字符串数量
     */
    public int balancedStringSplit(String s) {
        int balanceCount = 0;
        int result = 0;
        for (char c : s.toCharArray()) {
            balanceCount += c == 'L' ? 1 : -1;
            if (balanceCount == 0) {
                result++;
            }
        }
        return result;
    }
}
