package com.company.leetcode.Test;

import com.company.leetcode.StringQuestion;
import org.junit.Test;

import java.util.List;

public class StringQuestionTest {
    @Test
    public void multiplyTest(){
        StringQuestion t = new StringQuestion();
        String s = t.multiply("123", "456");
        System.out.println(s);
    }

    public void ParenthesesNumIsValidTest(){
        StringQuestion q = new StringQuestion();
        boolean IsValid = q.isValid("");
        System.out.println(IsValid);
    }

    public void countSubstringTest(){
        StringQuestion q = new StringQuestion();
        String s = "aaa";
        int sum = q.countSubstrings(s);
        System.out.println(sum);
    }

    public void letterCombinationsTest(){
        StringQuestion q = new StringQuestion();
        String digits = "";
        System.out.println(q.letterCombinations(digits));
    }

    public void shortestPalindromeTest(){
        StringQuestion q = new StringQuestion();
        String s = "";
        System.out.println(q.shortestPalindrome(s));
    }

    public void isNumberTest(){
        StringQuestion q = new StringQuestion();
        String s = ".1";
        System.out.println(q.isNumber(s));
    }

    @Test
    public void lengthOfLongestSubstringTest() {
        StringQuestion q = new StringQuestion();
        String s = "abcabcbb";
        System.out.println(q.lengthOfLongestSubstring(s));
    }

    @Test
    public void restoreIpAddressesTest() {
        StringQuestion q = new StringQuestion();
        String s = "25525511135";
        List<String> result = q.restoreIpAddresses(s);
        System.out.println(result);
    }
}
