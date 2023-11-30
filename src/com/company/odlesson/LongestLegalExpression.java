package com.company.odlesson;

import java.util.*;

/**
 * @author awmlk
 */
public class LongestLegalExpression {
    /**
     * 会出现的计算字符
     */
    private static final List<Character> SYMBOLS = Arrays.asList('+', '-', '*');

    /**
     * 判定是否是计算符号
     *
     * @param c 字符
     * @return 是否是计算符号
     */
    private boolean isSymbol(char c) {
        return SYMBOLS.contains(c);
    }

    private boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    /**
     * 计算字符串中最长合法数字表达式的值
     * 思路：
     * 先遍历找到最长的表达式，然后按照先乘后+-的原则计算就行
     *
     * @param s 原始字符串
     * @return 最长合法数字表达式的值
     */
    public long longestLegalExpression(String s) {
        String longest = getLongestExpression(s);
        return calExpression(longest);
    }

    private Long calExpression(String s) {
        if ("".equals(s)) {
            return 0L;
        }
        List<Long> nums = new ArrayList<>();
        List<String> symbols = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && !isSymbol(s.charAt(j))) {
                j++;
            }
            nums.add(Long.parseLong(s.substring(i, j)));
            if (j < s.length()) {
                symbols.add(String.valueOf(s.charAt(j)));
            }
            i = j;
        }
        return getResultFromList(nums, symbols);
    }

    private static Long getResultFromList(List<Long> nums, List<String> symbols) {
        Stack<Long> addSubNums = new Stack<>();
        addSubNums.add(nums.get(0));
        for (int i = 0; i < symbols.size(); i++) {
            if ("*".equals(symbols.get(i))) {
                Long temp = addSubNums.pop();
                addSubNums.push(temp * nums.get(i + 1));
            } else {
                addSubNums.push("-".equals(symbols.get(i)) ? -1 * nums.get(i + 1) : nums.get(i + 1));
            }
        }
        Long result = addSubNums.pop();
        while (!addSubNums.isEmpty()) {
            result += addSubNums.pop();
        }
        return result;
    }

    private String getLongestExpression(String s) {
        String longest = "";
        int begin = 0;
        while (begin < s.length()) {
            while (begin < s.length() && !isNum(s.charAt(begin))) {
                begin++;
            }
            if (begin == s.length()) {
                break;
            }
            int end = begin + 1;
            int continuousSymbolCount = 0;
            int symbolCount = 0;
            while (end < s.length()) {
                if (!isNum(s.charAt(end)) && !isSymbol(s.charAt(end))) {
                    if (isSymbol(s.charAt(end - 1))) {
                        symbolCount--;
                        end--;
                    }
                    break;
                }
                if (isSymbol(s.charAt(end))) {
                    continuousSymbolCount++;
                    symbolCount++;
                }
                if (isNum(s.charAt(end))) {
                    continuousSymbolCount = 0;
                }
                if (continuousSymbolCount == 2) {
                    symbolCount -= 2;
                    end--;
                    break;
                }
                end++;
            }
            if (isNum(s.charAt(end - 1)) && symbolCount > 0 && end - begin > longest.length()) {
                longest = s.substring(begin, end);
            }
            begin = end;
        }
        return longest;
    }
}
