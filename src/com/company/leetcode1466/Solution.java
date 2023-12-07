package com.company.leetcode1466;

import java.util.ArrayList;
import java.util.List;

/**
 * @author awmlk
 * 有向树，求让所有节点都能前往0，需要反转多少条方向
 * 思路：
 * 求出每个节点连接的所有子节点，同时记录连接方向，我想的是用负数表示反向
 * 然后一层层遍历，把所有的反向记录下来就行
 */
public class Solution {
    /**
     * 需要变更方向的最小路线数，不知道为啥是求最小，我理解n个节点，n-1条路线，那应该是唯一的呀
     *
     * @param n 节点数
     * @param connections 路线
     * @return 变更方向的最小路线数
     */
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] childList = new List[n];
        // 因为0本身没有负数，所以所有的节点值都+1处理
        for (int[] connection : connections) {
            if (childList[connection[0]] == null) {
                childList[connection[0]] = new ArrayList<>();
            }
            if (childList[connection[1]] == null) {
                childList[connection[1]] = new ArrayList<>();
            }
            childList[connection[0]].add(-1*(connection[1] + 1));
            childList[connection[1]].add(connection[0] + 1);
        }
        return traverseToRevert(0, -1, childList);
    }

    private int traverseToRevert(int index, int parent, List<Integer>[] childList) {
        int revertNum = 0;
        for (int child : childList[index]) {
            // 赋值的时候加了1，所以这里要-1
            int actualChild = Math.abs(child) - 1;
            if (actualChild == parent) {
                continue;
            }
            if (child < 0) {
                // System.out.println("revert " + index + " " + actualChild);
                revertNum++;
            }
            revertNum += traverseToRevert(actualChild, index, childList);
        }
        return revertNum;
    }
}
