package com.company.leetcode68;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SolutionTest {

    @Test
    public void fullJustify() {
        Solution solution = new Solution();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> result = solution.fullJustify(words, maxWidth);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals("This    is    an", result.get(0));
        Assert.assertEquals("example  of text", result.get(1));
        Assert.assertEquals("justification.  ", result.get(2));
    }

    @Test
    public void fullJustify_2() {
        Solution solution = new Solution();
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        List<String> result = solution.fullJustify(words, maxWidth);
        Assert.assertEquals(6, result.size());
        Assert.assertEquals("Science  is  what we", result.get(0));
        Assert.assertEquals("understand      well", result.get(1));
        Assert.assertEquals("enough to explain to", result.get(2));
        Assert.assertEquals("a  computer.  Art is", result.get(3));
        Assert.assertEquals("everything  else  we", result.get(4));
        Assert.assertEquals("do                  ", result.get(5));
    }

    @Test
    public void fullJustify_3() {
        Solution solution = new Solution();
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> result = solution.fullJustify(words, maxWidth);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals("What   must   be", result.get(0));
        Assert.assertEquals("acknowledgment  ", result.get(1));
        Assert.assertEquals("shall be        ", result.get(2));
    }
}