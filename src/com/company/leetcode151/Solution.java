package com.company.leetcode151;

import java.util.ArrayList;
import java.util.List;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 字符串单词翻转，删除多余空格
     *
     * @param s 原字符串
     * @return 翻转后的字符串
     */
    public String reverseWords(String s) {
        // 首先遍历统计所有的单词
        List<String> words = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (!stringBuilder.toString().isEmpty()) {
                    words.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
                continue;
            }
            stringBuilder.append(s.charAt(i));
        }
        int startIndex = words.size() - 1;
        // 从最后一个单词开始挨个拼凑空格和单词
        if (stringBuilder.toString().isEmpty()) {
            stringBuilder.append(words.get(startIndex));
            startIndex--;
        }
        for (int i = startIndex; i >= 0; i--) {
            stringBuilder.append(" ").append(words.get(i));
        }
        return stringBuilder.toString();
    }
}
