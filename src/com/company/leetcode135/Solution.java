package com.company.leetcode135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author awmlk
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }
        // 第一步先找到所有谷底点
        List<Integer> bottoms = new ArrayList<>();
        if (ratings[0] <= ratings[1]) {
            bottoms.add(0);
        }
        if (ratings[ratings.length - 1] <= ratings[ratings.length - 2]) {
            bottoms.add(ratings.length - 1);
        }
        for (int i = 1; i < ratings.length - 1; i++) {
            if (ratings[i - 1] >= ratings[i] && ratings[i + 1] >= ratings[i]) {
                bottoms.add(i);
            }
        }
        int[] everyChildCandies = new int[ratings.length];
        for (int index : bottoms) {
            everyChildCandies[index] = 1;
            for (int j = index - 1; j >= 0; j--) {
                if (ratings[j] <= ratings[j + 1]) {
                    break;
                } else {
                    everyChildCandies[j] = Math.max(everyChildCandies[j], everyChildCandies[j + 1] + 1);
                }
            }
            for (int j = index + 1; j < ratings.length; j++) {
                if (ratings[j] <= ratings[j - 1]) {
                    break;
                } else {
                    everyChildCandies[j] = Math.max(everyChildCandies[j], everyChildCandies[j - 1] + 1);
                }
            }
        }
        return Arrays.stream(everyChildCandies).sum();
    }
}
