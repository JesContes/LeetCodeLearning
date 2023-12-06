package com.company.odlesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author awmlk
 * 求会议室占用时间，一个会议室，若干个会议，会议室全量时间段为[1,24]
 * 输入，每个会议的起始时间和结束时间
 * 输出，计算后的会议室使用时间，其实就是合并连续的会议时间
 * 思路：
 * 想法就是按开始时间和结束时间排序，排完序依次合并就行，这道题的难度不知道在哪儿，排序再遍历的耗时吗
 */
public class MeetingsOccupyTime {
    /**
     * 求会议室占用时间
     * @param times 每个占用时间集合
     * @return 会议室占用时间
     */
    public Integer[][] solve(int[][] times) {
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0]- o2[0];
            }
        });
        List<Integer[]> result = new ArrayList<>();
        int begin = 0;
        int end = 0;
        for (int[] time : times) {
            if (begin == 0) {
                begin = time[0];
                end = time[1];
                continue;
            }
            if (end >= time[0]) {
                end = Math.max(end, time[1]);
            } else {
                result.add(new Integer[]{begin, end});
                begin = time[0];
                end = time[1];
            }
        }
        result.add(new Integer[]{begin, end});
        Integer[][] arrayResult = new Integer[result.size()][2];
        result.toArray(arrayResult);
        System.out.println(Arrays.deepToString(arrayResult));
        return arrayResult;
    }
}
