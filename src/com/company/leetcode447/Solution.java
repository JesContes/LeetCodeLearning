package com.company.leetcode447;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JesContes
 * @description 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * 思路：
 * 首先至少要三个points才能成立回旋镖，相当于对于i点，j、k两点是可以交换的，所以我们计算每个点到每个点的距离，然后统计每个距离的点的数量，求A(x,2) 组合即可，也就是x * (x - 1)
 * @since 2024/1/8
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Map<Long, Integer>> distanceMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            distanceMap.put(i, new HashMap<>());
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                long distance = (long) x * x + (long) y * y;
                Map<Long, Integer> disNumMapI = distanceMap.get(i);
                disNumMapI.put(distance, disNumMapI.getOrDefault(distance,0) + 1);
                Map<Long, Integer> disNumMapJ = distanceMap.get(j);
                disNumMapJ.put(distance, disNumMapJ.getOrDefault(distance,0) + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Long, Integer> disNumMap = distanceMap.get(i);
            for (int disNum : disNumMap.values()) {
                if (disNum < 2) {
                    continue;
                }
                result += disNum * (disNum - 1);
            }
        }
        return result;
    }
}
