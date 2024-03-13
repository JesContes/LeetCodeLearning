package com.company.leetcode2864;

/**
 * @author JesContes
 * @description 给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
 * 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
 * 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
 * 注意 返回的结果字符串 可以 含前导零。
 * 思路：
 * 遍历字符串，把1添加到一个StringBuilder，把0添加到另一个StringBuilder，遍历完之后，把0的StringBuilder插入到1的StringBuilder的最后一个1之前
 * @since 2024/3/13
 */
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        StringBuilder builder0 = new StringBuilder();
        StringBuilder builder1 = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ('0' == c) {
                builder0.append('0');
            } else {
                builder1.append('1');
            }
        }
        builder1.insert(builder1.length() - 1, builder0);
        return builder1.toString();
    }
}
