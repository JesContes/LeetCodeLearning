package com.company.leetcode.Test;

import com.company.leetcode.Calculate;

public class CalculateTest {
    public void judgePoint24Test(){
        Calculate cal = new Calculate();
        int[] nums = new int[]{1, 1, 7, 7};
        System.out.println(cal.judgePoint24(nums));
    }

    public void findLatestStepTest(){
        Calculate cal = new Calculate();
        int[] nums = new int[]{};
        int m = 75198;
        int res = cal.findLatestStep(nums, m);
        System.out.println(res);
    }

    public void PredictTheWinnerTest(){
        Calculate cal = new Calculate();
        int[] nums = new int[]{1,5,2};
        System.out.println(cal.PredictTheWinner(nums));
    }
}
