package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Calculate {
    //679. 24 点游戏
    public boolean judgePoint24(int[] nums) {
        boolean flag = false;
        List<Double> ToCalNums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            ToCalNums.add((double)nums[i]);
        }
        flag = judgePoint24All(ToCalNums);
        return flag;
    }

    public boolean judgePoint24All(List<Double> ToCalNums){
        if (ToCalNums.size() == 1 && Math.abs(ToCalNums.get(0) - 24) < 0.000001){
            return true;
        }
        else {
            Double temp;
            boolean flag = false;
            for (int i = 0; i < ToCalNums.size() - 1 && !flag; i++) {
                for (int j = i + 1; j < ToCalNums.size(); j++){
                    List<Double> NextToCalNums = new ArrayList<>();
                    //构建加法数据
                    NextToCalNums.addAll(ToCalNums);
                    NextToCalNums.remove(i);
                    NextToCalNums.remove(j - 1);
                    temp =  PointAdd(ToCalNums.get(i), ToCalNums.get(j));
                    NextToCalNums.add(temp);
                    flag = judgePoint24All(NextToCalNums);
                    if (flag == true){
                        break;
                    }
                    //构建减法数据
                    NextToCalNums.clear();
                    NextToCalNums.addAll(ToCalNums);
                    NextToCalNums.remove(i);
                    NextToCalNums.remove(j - 1);
                    temp =  PointSub(ToCalNums.get(i), ToCalNums.get(j));
                    NextToCalNums.add(temp);
                    flag = judgePoint24All(NextToCalNums);
                    if (flag == true){
                        break;
                    }
                    //构建减法数据，ij对调
                    NextToCalNums.clear();
                    NextToCalNums.addAll(ToCalNums);
                    NextToCalNums.remove(i);
                    NextToCalNums.remove(j - 1);
                    temp =  PointSub(ToCalNums.get(j), ToCalNums.get(i));
                    NextToCalNums.add(temp);
                    flag = judgePoint24All(NextToCalNums);
                    if (flag == true){
                        break;
                    }
                    //构建乘法数据
                    NextToCalNums.clear();
                    NextToCalNums.addAll(ToCalNums);
                    NextToCalNums.remove(i);
                    NextToCalNums.remove(j - 1);
                    temp =  PointMulty(ToCalNums.get(i), ToCalNums.get(j));
                    NextToCalNums.add(temp);
                    flag = judgePoint24All(NextToCalNums);
                    if (flag == true){
                        break;
                    }
                    //构建除法数据
                    if (ToCalNums.get(j) != 0) {
                        NextToCalNums.clear();
                        NextToCalNums.addAll(ToCalNums);
                        NextToCalNums.remove(i);
                        NextToCalNums.remove(j - 1);
                        temp = PointDiv(ToCalNums.get(i), ToCalNums.get(j));
                        NextToCalNums.add(temp);
                        flag = judgePoint24All(NextToCalNums);
                        if (flag == true) {
                            break;
                        }
                    }
                    //构建除法数据，ij对调
                    if (ToCalNums.get(i) != 0) {
                        NextToCalNums.clear();
                        NextToCalNums.addAll(ToCalNums);
                        NextToCalNums.remove(i);
                        NextToCalNums.remove(j - 1);
                        temp = PointDiv(ToCalNums.get(j), ToCalNums.get(i));
                        NextToCalNums.add(temp);
                        flag = judgePoint24All(NextToCalNums);
                        if (flag == true) {
                            break;
                        }
                    }
                }
            }
            return flag;
        }
    }

    public double PointAdd(double a, double b){
        return a+b;
    }

    public double PointSub(double a, double b){
        return a-b;
    }

    public double PointMulty(double a, double b){
        return a*b;
    }

    public double PointDiv(double a, double b){
        return a/b;
    }

    //5495. 圆形赛道上经过次数最多的扇区
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> result = new ArrayList<>();
        if (n == 0){
            return result;
        }
        int StartPoint = rounds[0];
        int EndPoint = rounds[rounds.length - 1];
        if (StartPoint == EndPoint){
            result.add(StartPoint);
        }
        else if (StartPoint < EndPoint){
            for (int i = StartPoint; i <= EndPoint; i++){
                result.add(i);
            }
        }
        else if (StartPoint > EndPoint){
            for (int i = 1; i <= EndPoint; i++){
                result.add(i);
            }
            for (int i = StartPoint; i <= n; i++){
                result.add(i);
            }
        }
        return result;
    }

    //5496. 你可以获得的最大硬币数目
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int result = 0;
        for (int i = piles.length - 2, j = 0; j < piles.length / 3; i -= 2, j++){
            result += piles[i];
        }
        return result;
    }

    //5497. 查找大小为 M 的最新分组
    public int findLatestStep(int[] arr, int m) {
        if (arr.length < 3||arr.length == m){
            return m;
        }
        int n = arr.length;
        int res = -1;
        List<Integer> MidPoint = new ArrayList<>();
        MidPoint.add(0);
        MidPoint.add(arr.length+1);
        boolean flag = false;
        for (int i = arr.length - 1; i >= 0 && !flag; i--){
            int tmp = arr[i];
            for (int j = 0; j < MidPoint.size(); j++){
                if (MidPoint.get(j) > tmp){
                    MidPoint.add(j, tmp);
                    int left = MidPoint.get(j) - MidPoint.get(j - 1) - 1;
                    int right = MidPoint.get(j + 1) - MidPoint.get(j) - 1;
                    if (left == m || right == m){
                        flag = true;
                        res = i;
                    }
                    break;
                }
            }
        }
        return res;
    }
}
