package com.company.odlesson;

import java.util.Arrays;

/**
 * 统计小朋友至少来自多少个小区
 * 输入garden[]，代表每个被统计的小朋友提供的班级里还有多少个小朋友和自己来源于同一个小区
 * 输出班级里的小朋友至少来自多少个小区
 * 思路：
 * 这道题简单思考，暴露数量不同的小朋友必定不是来自于同一个小区，数量相同的小朋友，如果遍历到数量超过，也认为来自于不同小区
 * 总的来说，遍历就完事了
 * @author awmlk
 */
public class ChildGardenStatistics {
    public int statistics(int[] garden) {
        // 先排个序
        Arrays.sort(garden);
        int last = 0;
        int result = 0;
        int oneGardenCount = 0;
        for (int j : garden) {
            if (j == last) {
                oneGardenCount++;
            } else {
                oneGardenCount = 0;
                last = j;
                result++;
            }
            if (oneGardenCount > j) {
                oneGardenCount = 0;
                result++;
            }
        }
        // 最后一批相同数量的，可能不会在循环里面截止，所以要做下最后处理
        if (oneGardenCount > 0) {
            result++;
        }
        return result;
    }
}
