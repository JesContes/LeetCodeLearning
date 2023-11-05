package com.company.leetcode187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 重复子串长度
     */
    private static final int REPEAT_SUB_LENGTH = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<>();
        Map<String, Integer> resultMap = new HashMap<>(10);
        for (int i = 0; i <= s.length() - REPEAT_SUB_LENGTH; i++) {
            String tempStr = s.substring(i, i + REPEAT_SUB_LENGTH);
            int appearNum = resultMap.getOrDefault(tempStr, 0);
            if (appearNum == 1) {
                results.add(tempStr);
            }
            resultMap.put(tempStr, appearNum + 1);
        }
        return results;
    }
}
