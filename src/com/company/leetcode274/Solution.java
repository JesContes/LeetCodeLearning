package com.company.leetcode274;

import java.util.Arrays;

/**
 * @author awmlk
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        // 倒序检索，当citations[h]的值小于i，即被分享的篇数的值时，说明i-1即为最大的h值
        for (int i = 1; i <= citations.length; i++) {
            if (i > citations[citations.length - i]) {
                return i - 1;
            }
        }
        return citations.length;
    }
}
