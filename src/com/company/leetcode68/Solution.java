package com.company.leetcode68;

import java.util.ArrayList;
import java.util.List;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 文本左右对齐
     *
     * @param words 单词数组
     * @param maxWidth 单行最大长度
     * @return 重新排版后的单词
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int tempLen = words[0].length();
        int totalLen;
        int startIndex = 0;
        int i = 1;
        while (i < words.length) {
            totalLen = tempLen;
            tempLen += 1 + words[i].length();
            if (tempLen > maxWidth) {
                int repeatBlank = maxWidth - totalLen + i - startIndex - 1;
                int averageBlank = startIndex + 1 == i ? repeatBlank: repeatBlank / (i - startIndex - 1);
                int additionBlank = startIndex + 1 == i ? 0 : repeatBlank - averageBlank * (i - startIndex - 1);
                String oneLine = generateOneLine(words, startIndex, i, averageBlank, additionBlank, maxWidth);
                result.add(oneLine);
                startIndex = i;
                tempLen = words[startIndex].length();
            }
            i++;
        }
        if (startIndex < i) {
            String lastLine = generateOneLine(words, startIndex, i, 1, 0, maxWidth);
            result.add(lastLine);
        }
        return result;
    }

    /**
     * 生成单行信息
     *
     * @param words 单词数组
     * @param startIndex 起始索引
     * @param i 结束索引
     * @param averageBlank 平均单词间隔空格
     * @param additionBlank 额外空格
     */
    private String generateOneLine(String[] words, int startIndex, int i, int averageBlank, int additionBlank, int maxWidth) {
        StringBuilder builder = new StringBuilder();
        for (int t = 0; startIndex + t < i; t++) {
            if (t > 0) {
                builder.append(" ".repeat(averageBlank));
                if (additionBlank > 0) {
                    builder.append(" ");
                    additionBlank--;
                }
            }
            builder.append(words[startIndex + t]);
        }
        builder.append(" ".repeat(maxWidth - builder.toString().length()));
        return builder.toString();
    }
}
