package com.company.leetcode151;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author awmlk
 */
public class SolutionTest {
    @Test
    public void reverseWordsSuccess() {
        Solution solution = new Solution();
        String s = "the sky is blue";
        Assert.assertEquals("blue is sky the", solution.reverseWords(s));
        s = "  hello world  ";
        Assert.assertEquals("world hello", solution.reverseWords(s));
        s = "a good   example";
        Assert.assertEquals("example good a", solution.reverseWords(s));
    }
}