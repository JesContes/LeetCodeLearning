package com.company.leetcode.Test;

import com.company.leetcode.StringQuestion;

public class StringQuestionTest {
    public void multiplyTest(){
        StringQuestion t = new StringQuestion();
        String s = t.multiply("140", "721");
        String s1 = t.multiplyOne("140", '7')+"0";
        String s2 = t.multiplyOne("140", '2');
        String s3 = t.stringadd(s1, s2);
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
}
