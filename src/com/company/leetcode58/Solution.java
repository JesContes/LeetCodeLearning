package com.company.leetcode58;

/**
 * @author awmlk
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        int result = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            result++;
            i--;
        }
        return result;
    }
}
