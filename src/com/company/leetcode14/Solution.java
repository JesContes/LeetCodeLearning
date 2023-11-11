package com.company.leetcode14;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 遍历法，求公共前缀
     *
     * @param strs 字符串数组
     * @return 公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = strs[0];
        for (String s : strs) {
            for (int i = 0; i < commonPrefix.length() && i < s.length(); i++) {
                if (commonPrefix.charAt(i) != s.charAt(i)) {
                    commonPrefix = commonPrefix.substring(0, i);
                    break;
                }
            }
            if (commonPrefix.isEmpty()) {
                break;
            }
            if (commonPrefix.length() > s.length()) {
                commonPrefix = s;
            }
        }
        return commonPrefix;
    }
}
