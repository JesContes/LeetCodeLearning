package com.company.odlesson;

import org.junit.Test;

import static org.junit.Assert.*;

public class MeetingsOccupyTimeTest {

    @Test
    public void solve() {
        MeetingsOccupyTime time = new MeetingsOccupyTime();
        int[][] occupy = new int[][]{{1,4},{4,5},{3,5},{6,7},{6,10},{8,20},{7,9},{21,22}};
        time.solve(occupy);
    }
}