package com.company.leetcode3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author awmlk
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 思路：
 * 滑动窗口，用哈希表保存当前窗口每个字符出现的坐标
 * 当不存在重复字符时，一直延展右指针，当出现重复字符时，将重复字符的坐标赋值给左指针，循环上一步
 */
public class Solution {
    /**
     * 求最长子串长度
     *
     * @param s 原始字符串
     * @return 最长子串长度
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> index = new HashMap<>(10);
        int i = 0;
        int j = 1;
        char[] chs = s.toCharArray();
        index.put(chs[0], 0);
        int maxLen = 1;
        while (j < chs.length) {
            while (j < chs.length && index.getOrDefault(chs[j], -1) < i) {
                index.put(chs[j], j);
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            if (j == chs.length) {
                break;
            }
            i = index.get(chs[j]) + 1;
            index.put(chs[j], j);
            j++;
        }
        return maxLen;
    }
}
