package com.company.leetcode6;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * N字形转换
     *
     * @param s 原始字符串
     * @param numRows 转换为N字形后的行数
     * @return 转换后从左到右从上到下的字符顺序
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int topGap = numRows * 2 - 2;
        int maxLen = s.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i >= maxLen) {
                break;
            }
            int rightGap = i * 2;
            int leftGap = topGap - rightGap;
            boolean addLeftSide = false;
            builder.append(s.charAt(i));
            int index = i + (leftGap == 0 ? rightGap : leftGap);
            while (index < maxLen) {
                builder.append(s.charAt(index));
                index += addLeftSide ? (leftGap == 0 ? rightGap : leftGap) : (rightGap == 0 ? leftGap : rightGap);
                addLeftSide = !addLeftSide;
            }
        }
        return builder.toString();
    }
}
