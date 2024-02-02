package com.company.leetcode1686;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JesContes
 * @description Alice 和 Bob 轮流玩一个游戏，Alice 先手。
 * 一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方都知道对方的评判标准。
 * 给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。
 * 所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。
 * 请你推断游戏的结果，用如下的方式表示：
 * 如果 Alice 赢，返回 1 。
 * 如果 Bob 赢，返回 -1 。
 * 如果游戏平局，返回 0 。
 * 思路：
 * 首先是如何判定最优策略，即拿取某个石子后，获得更高的相对分，那么这个相对分如何计算呢，我认为是这个石子的得分减去对对方来说所有剩余石子中最高得分的得分
 * 为了方便计算，就不去找剩余石子中的最高分了，直接计算当前石子分数与对方剩余石子总分的差值即可，这样每次取最大差值的石子
 * -- 上面的方法会超时，因为有双重循环
 * 按官方参考答案做：
 * 其实最优的选取方向是同一个石子，两边的分值加起来最高的。尽量保证自己得分的情况下，削减对方的得分。所以先求出所有石子的总分，然后按总分排序依次选取就行
 * @since 2024/2/2
 */
public class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        List<int[]> sumValues = new ArrayList<>();
        for (int i = 0; i < aliceValues.length; i++) {
            sumValues.add(new int[]{aliceValues[i]+bobValues[i], i});
        }
        sumValues.sort((o1, o2) -> o2[0] - o1[0]);
        int aRecord = 0;
        int bRecord = 0;
        boolean aPart = true;
        for (int[] sumValue : sumValues) {
            if (aPart) {
                aRecord += aliceValues[sumValue[1]];
            } else {
                bRecord += bobValues[sumValue[1]];
            }
            aPart = !aPart;
        }
        return Integer.compare(aRecord, bRecord);
    }

    public int stoneGameVIOrigon(int[] aliceValues, int[] bobValues) {
        int aSum = 0;
        for (int num : aliceValues) {
            aSum += num;
        }
        int bSum = 0;
        for (int num : bobValues) {
            bSum += num;
        }
        int aRecord = 0;
        int bRecord = 0;
        boolean aPart = true;
        for (int cycle = 0; cycle < aliceValues.length; cycle++) {
            int maxValue = Integer.MIN_VALUE;
            int maxIndex = 0;
            if (aPart) {
                for (int i = 0; i < aliceValues.length; i++) {
                    if (aliceValues[i] == 0) {
                        continue;
                    }
                    int tempValue = aliceValues[i] - bSum + bobValues[i];
                    if (tempValue > maxValue) {
                        maxValue = tempValue;
                        maxIndex = i;
                    }
                }
                aPart = false;
                aRecord += aliceValues[maxIndex];
            } else {
                for (int i = 0; i < bobValues.length; i++) {
                    if (bobValues[i] == 0) {
                        continue;
                    }
                    int tempValue = bobValues[i] - aSum + aliceValues[i];
                    if (tempValue > maxValue) {
                        maxValue = tempValue;
                        maxIndex = i;
                    }
                }
                aPart = true;
                bRecord += bobValues[maxIndex];
            }
            aSum -= aliceValues[maxIndex];
            aliceValues[maxIndex] = 0;
            bSum -= bobValues[maxIndex];
            bobValues[maxIndex] = 0;
        }
        return Integer.compare(aRecord, bRecord);
    }
}
