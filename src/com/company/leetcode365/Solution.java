package com.company.leetcode365;

import java.util.*;

/**
 * @author JesContes
 * @description 有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
 * 如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
 * 你可以：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 思路：
 * 深度遍历把，本质上是6个操作，装满A，倒掉A，装满B，倒掉B，A倒给B，B倒给A
 * 这道题发现HashSet查找元素真的比arraylist快多了，以后如果做记忆化相关的功能，着重要查找，一定用Hash家族
 * @since 2024/1/28
 */
public class Solution {
    private final HashSet<Long> capGroups = new HashSet<>();

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        return dfs(jug1Capacity, jug2Capacity, targetCapacity);
    }

    private boolean dfs(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        while (!stack.isEmpty()) {
            int[] action = stack.pop();
            int tempCap1 = action[0];
            int tempCap2 = action[1];
            if (tempCap1 + tempCap2 == targetCapacity || tempCap1 == targetCapacity || tempCap2 == targetCapacity) {
                return true;
            }
            long code = tempCap1 * 1000001L + tempCap2;
            if (capGroups.contains(code)) {
                continue;
            } else {
                capGroups.add(code);
            }
            if (tempCap1 < jug1Capacity) {
                stack.push(new int[]{jug1Capacity, tempCap2});
            }
            if (tempCap1 > 0) {
                stack.push(new int[]{0, tempCap2});
            }
            if (tempCap2 < jug2Capacity) {
                stack.push(new int[]{tempCap1, jug2Capacity});
            }
            if (tempCap2 > 0) {
                stack.push(new int[]{tempCap1, 0});
            }
            if (tempCap1 < jug1Capacity) {
                stack.push(new int[]{Math.min(tempCap1 + tempCap2, jug1Capacity)
                        , Math.max(tempCap2 - jug1Capacity + tempCap1, 0)});
            }
            if (tempCap2 < jug2Capacity) {
                stack.push(new int[]{Math.max(tempCap1 - jug2Capacity + tempCap2, 0)
                        , Math.min(tempCap2 + tempCap1, jug2Capacity)});
            }
        }
        return false;
    }
}
