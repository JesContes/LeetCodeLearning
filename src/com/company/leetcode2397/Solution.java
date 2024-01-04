package com.company.leetcode2397;

/**
 * @author JesContes
 * @description 给你一个下标从 0 开始、大小为 m x n 的二进制矩阵 matrix ；另给你一个整数 numSelect，表示你必须从 matrix 中选择的 不同 列的数量。
 * 如果一行中所有的 1 都被你选中的列所覆盖，则认为这一行被 覆盖 了。
 * 形式上，假设 s = {c1, c2, ...., cnumSelect} 是你选择的列的集合。对于矩阵中的某一行 row ，如果满足下述条件，则认为这一行被集合 s 覆盖：
 * 对于满足 matrix[row][col] == 1 的每个单元格 matrix[row][col]（0 <= col <= n - 1），col 均存在于 s 中，或者
 * row 中 不存在 值为 1 的单元格。
 * 你需要从矩阵中选出 numSelect 个列，使集合覆盖的行数最大化。
 * 返回一个整数，表示可以由 numSelect 列构成的集合 覆盖 的 最大行数 。
 * 思路：
 * 1、看标签有个位运算，那试试遍历位运算的方法求最大值，时间复杂度是O(m*n)
 * @since 2024/1/4
 */
public class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        // 处理特殊情况，这种情况就不需要遍历了
        if (numSelect >= matrix[0].length) {
            return matrix.length;
        }
        int[] rowBinary = new int[matrix.length];
        for (int i = 0; i < rowBinary.length; i++) {
            int rowBiNum = 0;
            for (int j : matrix[i]) {
                rowBiNum = rowBiNum * 2 + j;
            }
            rowBinary[i] = rowBiNum;
        }
        return getMaxCoverRow(matrix, numSelect, rowBinary);
    }

    private int getMaxCoverRow(int[][] matrix, int numSelect, int[] rowBinary) {
        int maxCoverRow = 0;
        int selectType = (int)Math.pow(2, numSelect) - 1;
        for (; selectType <= (int)Math.pow(2, numSelect) - 1 << (matrix[0].length - numSelect); selectType ++) {
            if (countOnes(selectType) != numSelect) {
                continue;
            }
            int typeCoverRow = 0;
            for (int rowBiNum : rowBinary) {
                // 这一步先进行或运算，将这一行的1融入到我的numSelect方案中，然后再与numSelect方案自身求异或，如果有未覆盖到的1，异或结果就不为0
                typeCoverRow += ((rowBiNum | selectType) ^ selectType) == 0 ? 1 : 0;
            }
            maxCoverRow = Math.max(maxCoverRow, typeCoverRow);
        }
        return maxCoverRow;
    }

    private int countOnes(int binaryNum) {
        int count = 0;
        while (binaryNum != 0) {
            count += binaryNum & 1;  // 检查最低位是否为1
            binaryNum >>= 1;  // 右移一位，检查下一位
        }
        return count;
    }
}
