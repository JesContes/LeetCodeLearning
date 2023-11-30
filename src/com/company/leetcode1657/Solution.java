package com.company.leetcode1657;

import java.util.*;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 求两个字符串是否接近，如果可以通过交换字符位置或者将两类字符互相转化使两个字符串一致，则认为接近
     * 思路：
     * 可以任意交换字符位置，说明字符顺序不重要，字符之间可以互相转化，说明单一字符的数量不需要一致，而是不同类的字符必须要有同数量的任意字符匹配
     * 基于以上，先统计每个字符串中，有哪些字符，有哪些字符数，然后比较，相同即可
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @return 是否是接近字符串
     */
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> word1ChaList = generateCharacterMap(word1);
        Map<Character, Integer> word2ChaList = generateCharacterMap(word2);
        // 如果字符类型数量都不同，那肯定是不接近的
        if (word1ChaList.keySet().size() != word2ChaList.keySet().size()) {
            return false;
        }
        Character[] word1ChaArray = new Character[word1ChaList.keySet().size()];
        word1ChaList.keySet().toArray(word1ChaArray);
        Arrays.sort(word1ChaArray);
        String word1ChaString = Arrays.toString(word1ChaArray);
        Character[] word2ChaArray = new Character[word2ChaList.keySet().size()];
        word2ChaList.keySet().toArray(word2ChaArray);
        Arrays.sort(word2ChaArray);
        String word2ChaString = Arrays.toString(word2ChaArray);
        // 然后比较包含的字符类型是否一致
        if (!word1ChaString.equals(word2ChaString)) {
            return false;
        }
        Integer[] word1ChaNumArray = new Integer[word1ChaList.values().size()];
        word1ChaList.values().toArray(word1ChaNumArray);
        Arrays.sort(word1ChaNumArray);
        Integer[] word2ChaNumArray = new Integer[word2ChaList.values().size()];
        word2ChaList.values().toArray(word2ChaNumArray);
        Arrays.sort(word2ChaNumArray);
        // 最后遍历比较从最小到最大是否数量一致
        for (int i = 0; i < word1ChaNumArray.length; i++) {
            if (!word1ChaNumArray[i].equals(word2ChaNumArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计一个字符串中所有类型字符的数量
     *
     * @param word 字符串
     * @return 字符串中所有类型字符的数量
     */
    private Map<Character, Integer> generateCharacterMap(String word) {
        Map<Character, Integer> wordChMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordChMap.put(c, wordChMap.getOrDefault(c, 0) + 1);
        }
        return wordChMap;
    }
}
