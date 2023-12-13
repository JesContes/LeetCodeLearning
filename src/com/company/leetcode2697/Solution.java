package com.company.leetcode2697;

/**
 * @author awmlk
 * 字典序最小回文串，原始字符串为全小写字符。一次操作可以替换一个字符为任意其他小写字符，要求最小操作，最小字典序，得到回文串
 * 思路：
 * 双指针头尾向中间遍历，两相比较时用字典序小的字符替换大的字符
 */
public class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i < j) {
            if (chs[i] <= chs[j]) {
                chs[j] = chs[i];
            } else {
                chs[i] = chs[j];
            }
            i++;
            j--;
        }
        return String.valueOf(chs);
    }
}
