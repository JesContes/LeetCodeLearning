package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContinuousNaturalNumTest {

    @Test
    public void solve() {
        ContinuousNaturalNum continuousNaturalNum = new ContinuousNaturalNum();
        int target = 9;
        continuousNaturalNum.solve(target);
        target = 25;
        continuousNaturalNum.solve(target);
        target = 16;
        continuousNaturalNum.solve(target);
        target = 999;
        continuousNaturalNum.solve(target);
    }
}