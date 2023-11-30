package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestLegalExpressionTest {

    @Test
    public void longestLegalExpressionWhenHave1LegalExpression() {
        LongestLegalExpression expression = new LongestLegalExpression();
        String s = "1-2abcd";
        long result = expression.longestLegalExpression(s);
        assertEquals(-1, result);
    }

    @Test
    public void longestLegalExpressionWhenNotLegalExpression() {
        LongestLegalExpression expression = new LongestLegalExpression();
        String s = "1--2-abcd";
        long result = expression.longestLegalExpression(s);
        assertEquals(0, result);
    }

    @Test
    public void longestLegalExpressionWhenHave2LegalExpression() {
        LongestLegalExpression expression = new LongestLegalExpression();
        String s = "1-2ab8*9-6*7+9+10cd";
        long result = expression.longestLegalExpression(s);
        assertEquals(49, result);
    }
}