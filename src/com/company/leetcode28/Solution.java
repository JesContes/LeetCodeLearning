package com.company.leetcode28;

/**
 * @author awmlk
 */
class Solution {
    /**
     * 找出字符串中第一个匹配项的下标
     *
     * @param haystack 源字符串
     * @param needle 匹配子字符串
     * @return 第一次出现子字符串的下标
     */
    public int strStr(String haystack, String needle) {
        // 暴力遍历解法懒得写了，kmp解法没弄懂，先直接调api吧
        return haystack.indexOf(needle);
    }
}
