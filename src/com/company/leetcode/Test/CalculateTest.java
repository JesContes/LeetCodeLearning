package com.company.leetcode.Test;

import com.company.leetcode.Calculate;

import java.util.Arrays;
import java.util.List;

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

    public void topKFrequentTest(){
        Calculate cal = new Calculate();
        int[] nums = new int[]{1,2};
        int[] res = cal.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));
    }

    public void checkArithmeticSubarraysTest(){
        int[] nums = new int[]{4,6,5,9,3,7};
        int[] l = new int[]{0,0,2};
        int[] r = new int[]{2,3,5};
        Calculate cal = new Calculate();
        List<Boolean> answers = cal.checkArithmeticSubarrays(nums, l, r);
        System.out.println(answers.toString());
    }
}
