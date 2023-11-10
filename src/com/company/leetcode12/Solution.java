package com.company.leetcode12;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 整数转罗马数字
     *
     * @param num 整数
     * @return 罗马数字字符串
     */
    public String intToRoman(int num) {
        int tempNum = num;
        StringBuilder stringBuilder = new StringBuilder();
        int thousands = tempNum / 1000;
        tempNum -= thousands * 1000;
        stringBuilder.append("M".repeat(Math.max(0, thousands)));
        int hundreds = tempNum / 100;
        tempNum -= hundreds * 100;
        if (hundreds == 9) {
            stringBuilder.append("CM");
        } else if (hundreds >= 5) {
            stringBuilder.append("D");
            stringBuilder.append("C".repeat(Math.max(0, hundreds - 5)));
        } else if (hundreds == 4) {
            stringBuilder.append("CD");
        } else {
            stringBuilder.append("C".repeat(Math.max(0, hundreds)));
        }
        int tens = tempNum / 10;
        tempNum -= tens * 10;
        if (tens == 9) {
            stringBuilder.append("XC");
        } else if (tens >= 5) {
            stringBuilder.append("L");
            stringBuilder.append("X".repeat(Math.max(0, tens - 5)));
        } else if (tens == 4) {
            stringBuilder.append("XL");
        } else {
            stringBuilder.append("X".repeat(Math.max(0, tens)));
        }
        int ones = tempNum;
        if (ones == 9) {
            stringBuilder.append("IX");
        } else if (ones >= 5) {
            stringBuilder.append("V");
            stringBuilder.append("I".repeat(Math.max(0, ones - 5)));
        } else if (ones == 4) {
            stringBuilder.append("IV");
        } else {
            stringBuilder.append("I".repeat(Math.max(0, ones)));
        }
        return stringBuilder.toString();
    }
}
