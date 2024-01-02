package com.company.leetcode466;

/**
 * @author JesContes
 * @description 定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。
 * 例如，str == ["abc", 3] =="abcabcabc" 。
 * 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
 * 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。
 * 现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, n2] 。
 * 请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。
 * 思路：
 * 1、先把str1和str2构造出来，然后遍历str1依次匹配str2，遍历完可以匹配多少个str2，就是m的值
 * 2、1不可行，会有特有长的字符串，超出内存限制，优化一下不构造完整str1和str2，就用s1和s2匹配
 * 3、2也不可行，会超时，考虑计算一下能够完整匹配x个s2的s1数量，再用乘法算出最终值
 * @since 2024/1/2
 */
public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // m 代表s1完整匹配s2后能匹配的s2数量，完整匹配的意思是上一个s2的末尾匹配和这一个s2的开头匹配不在一个s1中
        int m = 0;
        int c2Index = 0;
        int lastMatch = 0;
        for (int i = 0; i < n1; i++) {
            for (char c1 : s1.toCharArray()) {
                char c2 = s2.charAt(c2Index);
                if (c1 == c2) {
                    if (c2Index == 0 && i > lastMatch) {
                        break;
                    }
                    c2Index++;
                    if (c2Index == s2.length()) {
                        m++;
                        c2Index = 0;
                        lastMatch = i;
                    }
                }
            }
        }
        return (int)((long)n1 * m / (lastMatch + 1) / n2);
    }
}
