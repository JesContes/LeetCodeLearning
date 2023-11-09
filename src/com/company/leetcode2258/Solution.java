package com.company.leetcode2258;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author awmlk
 */
public class Solution {
    /**
     * 定义无法到达时间
     */
    private static final int INF = 1000000000;

    /**
     * 移动方向集
     */
    private static final int[][] DIRS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * 墙
     */
    private static final int WALL = 2;

    /**
     * 计算起点最长停留时间
     *
     * @param grid 初始着火情况矩阵
     * @return 起点最长停留时间
     */
    public int maximumMinutes(int[][] grid) {
        int[][] fireTime = getFireTime(grid);
        int lowTime = 0;
        int highTime = INF;
        int midTime = highTime;
        boolean checkResult = checkArrive(grid, fireTime, highTime);
        if (checkResult) {
            return INF;
        }
        while (lowTime < highTime) {
            midTime = (lowTime + highTime) / 2;
            checkResult = checkArrive(grid, fireTime, midTime);
            if (checkResult) {
                lowTime = midTime + 1;
            } else {
                highTime = midTime;
            }
        }
        return checkResult ? midTime : midTime - 1;
    }

    /**
     * 获取每个格子着火时间
     *
     * @param grid 初始着火情况矩阵
     * @return 每个格子着火时间
     */
    private int[][] getFireTime(int[][] grid) {
        int[][] fireTime = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(fireTime[i], INF);
        }
        Queue<int[]> firePoints = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                firePoints.add(new int[]{i, j});
                fireTime[i][j] = 0;
            }
        }
        int time = 1;
        while (!firePoints.isEmpty()) {
            int onceTimeSize = firePoints.size();
            for (int i = 0; i < onceTimeSize; i++) {
                int[] point = firePoints.poll();
                for (int[] dir : DIRS) {
                    int tempY = point[0] + dir[0];
                    int tempX = point[1] + dir[1];
                    if (tempX < 0 || tempY < 0 || tempX >= fireTime[0].length || tempY >= fireTime.length
                            || fireTime[tempY][tempX] != INF || grid[tempY][tempX] == WALL) {
                        continue;
                    }
                    fireTime[tempY][tempX] = time;
                    firePoints.offer(new int[]{tempY, tempX});
                }
            }
            time++;
        }
        return fireTime;
    }

    /**
     * 判定停留时间为stayTime的情况下，是否能在火烧前到达安全屋
     *
     * @param grid 初始着火情况矩阵
     * @param fireTime 着火时间矩阵
     * @param stayTime 初始停留时间
     * @return 是否能到达安全屋
     */
    private boolean checkArrive(int[][] grid, int[][] fireTime, int stayTime) {
        boolean[][] moveRecord = new boolean[grid.length][grid[0].length];
        Queue<int[]> movePoints = new ArrayDeque<>();
        moveRecord[0][0] = true;
        movePoints.add(new int[]{0, 0});
        int time = 1;
        while (!movePoints.isEmpty()) {
            int onceTimeSize = movePoints.size();
            for (int i = 0; i < onceTimeSize; i++) {
                int[] point = movePoints.poll();
                for (int[] dir : DIRS) {
                    int tempY = point[0] + dir[0];
                    int tempX = point[1] + dir[1];
                    if (tempX == grid[0].length - 1 && tempY == grid.length - 1 &&
                            (fireTime[tempY][tempX] == INF || fireTime[tempY][tempX] >= stayTime + time)) {
                        return true;
                    }
                    if (tempX < 0 || tempY < 0 || tempX >= grid[0].length || tempY >= grid.length) {
                        continue;
                    }
                    if (moveRecord[tempY][tempX]) {
                        continue;
                    }
                    if ((fireTime[tempY][tempX] != INF && fireTime[tempY][tempX] <= stayTime + time)
                            || grid[tempY][tempX] == WALL) {
                        continue;
                    }
                    moveRecord[tempY][tempX] = true;
                    movePoints.offer(new int[]{tempY, tempX});
                }
            }
            time++;
        }
        return false;
    }
}
