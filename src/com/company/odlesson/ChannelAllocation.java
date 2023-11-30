package com.company.odlesson;

/**
 * @author awmlk
 */
public class ChannelAllocation {
    public int channelAllocation(int r, int[] channelNum, int d) {
        int onceSum = dfs(channelNum, d, r, 0);
        int result = 0;
        while (onceSum >= d) {
            result++;
            onceSum = dfs(channelNum, d, r, 0);
        }
        return result;
    }

    private int dfs(int[] channelNum, int d, int i, int tempSum) {
        if (i < 0) {
            return tempSum;
        }
        if (tempSum == d) {
            return tempSum;
        }
        if (i == 0 && tempSum + channelNum[i] < d) {
            return tempSum;
        }
        int tempChannel = (int) Math.pow(2, i);
        int needNum = (d - tempSum) / tempChannel;
        int newSum;
        if (needNum == 0) {
             newSum = dfs(channelNum, d, i - 1, tempSum);
        } else {
            int actualUseNum = Math.min(channelNum[i], needNum);
            channelNum[i] -= actualUseNum;
            newSum = dfs(channelNum, d, i - 1, tempSum + actualUseNum * tempChannel);
        }
        while (channelNum[i] > 0 && newSum < d) {
            newSum += tempChannel;
            channelNum[i]--;
        }
        return newSum;
    }
}
