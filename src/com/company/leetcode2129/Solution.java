package com.company.leetcode2129;

/**
 * @author JesContes
 * @description 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 * 思路：
 * 首先分割字符串，分割完成后遍历每个单词，先直接置为小写，然后检测长度，如果长度大于2，则将首字母转为大写
 * @since 2024/3/11
 */
public class Solution {
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (builder.length() > 0) {
                builder.append(" ");
            }
            String lowerWord = word.toLowerCase();
            if (lowerWord.length() > 2) {
                builder.append((char)(lowerWord.charAt(0) - 32));
                builder.append(lowerWord.substring(1));
            } else {
                builder.append(lowerWord);
            }
        }
        return builder.toString();
    }
}
