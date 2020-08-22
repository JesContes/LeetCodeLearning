package com.company.leetcode;

import java.util.ArrayList;
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
}
