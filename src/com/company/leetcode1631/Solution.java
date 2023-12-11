package com.company.leetcode1631;

import java.util.*;

/**
 * @author awmlk
 * 最小体力消耗路径
 * 思路：
 * 无脑解法就是深度优先或者广度优先遍历求最值，但是这样时间复杂度很高
 * 解法1：在遍历基础上，用二分法剪枝，然后看是否能到达
 * 解法2：用并查集，将所有边的权重按从小到大的顺序排列，从最小的开始添加到集合中，如果添加了X之后，能够到达目的地，则解为X
 * 解法3：Dijkstra 算法，这个要学习一个
 */
public class Solution {
    /**
     * 方向矩阵
     */
    private static final int[][] DIRS = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    /**
     * 最小体力
     *
     * @param heights 高度矩阵
     * @return 最小体力
     */
    public int minimumEffortPath(int[][] heights) {
        if (heights.length <= 1 && heights[0].length <= 1) {
            return 0;
        }
        return disjointSet(heights);
    }

    /**
     * 二分法解法
     *
     * @param heights 高度矩阵
     * @return 最小体力
     */
    private int dichotomy(int[][] heights) {
        int low = 0;
        int high = 999999;
        int mid = (low + high) / 2;
        int row = heights.length;
        int column = heights[0].length;
        int lastReachEnd = high;
        while (low <= high) {
            boolean reachEnd = false;
            Queue<int[]> passPoints = new ArrayDeque<>();
            passPoints.add(new int[]{0, 0});
            boolean[] seen = new boolean[row * column];
            while (!passPoints.isEmpty()) {
                int[] point = passPoints.poll();
                int x = point[0];
                int y = point[1];
                for (int[] dir : DIRS) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= row || ny < 0 || ny >= column) {
                        continue;
                    }
                    if (seen[nx * column + ny] || Math.abs(heights[x][y] - heights[nx][ny]) > mid) {
                        continue;
                    }
                    if (nx == row - 1 && ny == column - 1) {
                        reachEnd = true;
                        break;
                    }
                    seen[nx * column + ny] = true;
                    passPoints.add(new int[]{nx, ny});
                }
            }
            if (reachEnd) {
                lastReachEnd = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return lastReachEnd;
    }

    /**
     * 并查集解法
     *
     * @param heights 高度矩阵
     * @return 最小体力
     */
    private int disjointSet(int[][] heights) {
        int row = heights.length;
        int column = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int index = i * column + j;
                if (i > 0) {
                    edges.add(new int[]{index - column, index, Math.abs(heights[i - 1][j] - heights[i][j])});
                }
                if (j > 0) {
                    edges.add(new int[]{index - 1, index, Math.abs(heights[i][j - 1] - heights[i][j])});
                }
            }
        }
        edges.sort(Comparator.comparingInt(o -> o[2]));
        DisJointSet set = new DisJointSet(row * column);
        for (int[] edge : edges) {
            set.unite(edge[0], edge[1]);
            if (set.isConnect(0, row * column - 1)) {
                return edge[2];
            }
        }
        return 0;
    }

    static class DisJointSet {
        private final int[] parent;
        private final int[] size;

        public DisJointSet(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public int findSet(int a) {
            return parent[a] == a ? a : findSet(parent[a]);
        }

        public void unite(int x, int y) {
            int nx = findSet(x);
            int ny = findSet(y);
            if (size[nx] < size[ny]) {
                int temp = nx;
                nx = ny;
                ny = temp;
            }
            parent[ny] = nx;
            size[nx] += size[ny];
        }

        public boolean isConnect(int x, int y) {
            return findSet(x) == findSet(y);
        }
    }
}
