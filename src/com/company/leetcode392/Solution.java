package com.company.leetcode392;

import java.util.Arrays;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 小写字母数
     */
    private static final int LOWER_CASE_CH = 26;

    /**
     * 判断s是否是t的子序列
     *
     * @param s 字符串
     * @param t 字符串
     * @return s是否是t的子序列
     */
    public boolean isSubsequence(String s, String t) {
        return dpSearch(s, t);
    }

    /**
     * 动态规划算法求解，先求出每一个字符在t中出现的情况，动态转移方程f[i][j]，i表示当前索引，j表示字符，用0-26表示a-z，
     * f[i][j]表示从i索引开始，后面第一次出现字符j的索引
     *
     * @param s 待匹配字符串
     * @param t 原始字符串
     * @return s是否是t的子序列
     */
    private boolean dpSearch(String s, String t) {
        // 提前判定一下s是否为空
        if (s == null || s.isEmpty()) {
            return true;
        }
        // 提前判定一下参数是否非法
        if (s.length() > t.length()) {
            return false;
        }
        // 尾部增加一位，赋值不存在的参数，说明此时开始不存在对应字符
        int[][] dp = new int[t.length() + 1][LOWER_CASE_CH];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < t.length(); i++) {
            dp[i][t.charAt(i) - 'a'] = i;
        }
        for (int j = 0; j < LOWER_CASE_CH; j++) {
            for (int i = t.length() - 1; i >= 0; i--) {
                if (dp[i][j] == -1) {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        int[] sIndexSearch = new int[s.length()];
        sIndexSearch[0] = dp[0][s.charAt(0) - 'a'];
        if (sIndexSearch[0] == -1) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            sIndexSearch[i] = dp[sIndexSearch[i-1] + 1][s.charAt(i) - 'a'];
            if (sIndexSearch[i] == -1) {
                return false;
            }
        }
        return true;
    }
}
