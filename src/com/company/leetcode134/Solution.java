package com.company.leetcode134;

/**
 * @author awmlk
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minGas = 0;
        int sumGasCost = minGas;
        int grow_index = -1;
        for (int i = 0; i < gas.length; i++) {
            int tempGasCost = gas[i] - cost[i];
            sumGasCost += tempGasCost;
            if (sumGasCost < minGas) {
                minGas = sumGasCost;
                grow_index = i;
            }
        }
        if (sumGasCost < 0) {
            return -1;
        }
        return (grow_index + 1) % gas.length;
    }
}
