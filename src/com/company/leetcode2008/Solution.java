package com.company.leetcode2008;

import java.util.ArrayList;
import java.util.List;

/**
 * @author awmlk
 * 出租车最大盈利问题
 * 思路：
 * 动态规划，先把终点为m的划出一个队列，然后依次计算求出m点最大营收，状态转移方程为p[m] = Max(p[starti]+tripi+m-starti)
 */
public class Solution {
    /**
     * 求最大收益
     *
     * @param n 地点数量
     * @param rides 乘客乘坐范围和收益
     * @return 最大收益
     */
    public long maxTaxiEarnings(int n, int[][] rides) {
        // 因为起点索引是1，所以创建n+1的长度，比较好处理
        List<int[]>[] ridesList = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            ridesList[i] = new ArrayList<>();
        }
        for (int[] ride : rides) {
            ridesList[ride[1]].add(ride);
        }
        long[] earning = new long[n+1];
        for (int i = 2; i < n + 1; i++) {
            earning[i] = earning[i - 1];
            for (int[] ride : ridesList[i]) {
                earning[i] = Math.max(earning[i], earning[ride[0]] + ride[1] - ride[0] + ride[2]);
            }
        }
        return earning[n];
    }
}
