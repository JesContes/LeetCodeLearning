package com.company.leetcode1410;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void entityParserWhenHavaToConvertAmp() {
        String text = "&amp; is an HTML entity but &ambassador; is not.";
        Solution solution = new Solution();
        String result = solution.entityParser(text);
        assertEquals("& is an HTML entity but &ambassador; is not.", result);
    }

    @Test
    public void entityParserWhenHavaToConvertQuot() {
        String text = "and I quote: &quot;...&quot;";
        Solution solution = new Solution();
        String result = solution.entityParser(text);
        assertEquals("and I quote: \"...\"", result);
    }

    @Test
    public void entityParserWhenNotHaveToConvertAny() {
        String text = "Stay home! Practice on Leetcode :)";
        Solution solution = new Solution();
        String result = solution.entityParser(text);
        assertEquals("Stay home! Practice on Leetcode :)", result);
    }

    @Test
    public void entityParserWhenHaveToConvertGtLtAmp() {
        String text = "x &gt; y &amp;&amp; x &lt; y is always false";
        Solution solution = new Solution();
        String result = solution.entityParser(text);
        assertEquals("x > y && x < y is always false", result);
    }
}