package com.company.leetcode6;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void convert() {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = solution.convert(s, numRows);
        Assert.assertEquals("PAHNAPLSIIGYIR", result);
        s = "PAYPALISHIRING";
        numRows = 4;
        result = solution.convert(s, numRows);
        Assert.assertEquals("PINALSIGYAHRPI", result);
        s = "A";
        numRows = 1;
        result = solution.convert(s, numRows);
        Assert.assertEquals("A", result);
        s = "ABCDEFGH";
        numRows = 2;
        result = solution.convert(s, numRows);
        Assert.assertEquals("ACEGBDFH", result);
    }
}