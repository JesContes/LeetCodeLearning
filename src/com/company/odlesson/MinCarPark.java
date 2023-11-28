package com.company.odlesson;

/**
 * @author awmlk
 * 特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车。
 * 车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3）。
 * 统计停车场最少可以停多少辆车，返回具体的数目。
 */
public class MinCarPark {
    /**
     * 求停车场当前已停放的最小停车数量
     *
     * @param cars 停车场车位占位数组
     * @return 最小停车数量
     */
    public int minCarPark(int[] cars) {
        int result = 0;
        int temp = 0;
        for (int car : cars) {
            if (car == 1) {
                temp++;
            } else {
                result += temp > 0 ? 1 : 0;
                temp = 0;
            }
            if (temp >= 3) {
                temp = 0;
                result++;
            }
        }
        result += temp > 0 ? 1 : 0;
        return result;
    }
}
