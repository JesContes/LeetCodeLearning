package com.company.leetcode2171;

import java.util.Arrays;

/**
 * @author JesContes
 * @description 给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
 * 请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
 * 请返回你需要拿出魔法豆的 最少数目。
 * 思路：
 * 先排序，然后计算从尾部舍弃到头部需要拿出的豆子数量，然后从前向后遍历，在原拿出值的基础上，加上上一个遍历的袋子的豆子数，减去上一个袋子到这个袋子的豆子存有量增值*剩余袋子数，遍历全部后取最大值
 * @since 2024/1/18
 */
public class Solution {
    public long minimumRemoval(int[] beans) {
        if (beans.length <= 1) {
            return 0;
        }
        Arrays.sort(beans);
        // 上一个相同豆子数的袋子的第一个索引，用于记录需要新拿出的豆子数
        long lastEqualIndex = 0;
        // 拿出袋子里所有豆子的数量
        long takeAllBeanNum = 0;
        // 拿出比基准值高的袋子的豆子的数量
        long takeOverBeanNum = 0;
        for (int i = beans.length - 1; i > 0; i--) {
            takeOverBeanNum += beans[i] - beans[0];
        }
        // 拿出豆子最小数，先假定用以最少的袋子中的魔法豆数量为基准，其他的袋子全部都把超过数量的豆子拿出来的情况
        long minGiveUpBeanNum = takeOverBeanNum;
        for (int i = 1; i < beans.length; i++) {
            if (beans[i] == beans[i - 1]) {
                continue;
            }
            takeAllBeanNum += beans[i - 1] * (i - lastEqualIndex);
            lastEqualIndex = i;
            takeOverBeanNum -= (long) (beans[i] - beans[i - 1]) * (beans.length - i);
            minGiveUpBeanNum = Math.min(minGiveUpBeanNum, takeAllBeanNum + takeOverBeanNum);
        }
        return minGiveUpBeanNum;
    }
}
