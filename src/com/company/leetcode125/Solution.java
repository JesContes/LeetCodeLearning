package com.company.leetcode125;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 验证回文串
     *
     * @param s 原始字符串
     * @return 是否是回文串
     */
    public boolean isPalindrome(String s) {
        int lIndex = 0;
        int rIndex = s.length() - 1;
        while (lIndex < rIndex) {
            while (!checkIfCharacter(s.charAt(lIndex))) {
                lIndex++;
                if (lIndex >= s.length()) {
                    return true;
                }
            }
            while (!checkIfCharacter(s.charAt(rIndex))) {
                rIndex--;
            }
            if (convertToLowerCase(s.charAt(lIndex)) != convertToLowerCase(s.charAt(rIndex))) {
                break;
            }
            lIndex++;
            rIndex--;
        }
        return lIndex >= rIndex;
    }

    /**
     * 判断是否处于判定字符区间
     *
     * @param ch 字符
     * @return 是否处于判定字符区间
     */
    private boolean checkIfCharacter(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }

    /**
     * 大写转小写
     *
     * @param ch 字符
     * @return 小写字符
     */
    private char convertToLowerCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)((int)ch + 32);
        }
        return ch;
    }
}
